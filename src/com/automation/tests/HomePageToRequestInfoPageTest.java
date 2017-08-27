package com.automation.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.withpagefactory.pages.HomePage;
import com.automation.withpagefactory.pages.RequestInfoPage;

/**
 * Test cases for Home Page and its navigation to Request Info Page
 * @author Poornima
 *
 */
public class HomePageToRequestInfoPageTest {
	public WebDriver driver;
	RequestInfoPage objReqInfo;
	HomePage objHome;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Poornima/Desktop/Selenium Web Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.uptake.com/");
		objHome = new HomePage(driver);
	}

	@Test(priority = 0)
	public void invokeHomePage_verifyTitle_success() throws InterruptedException {
		String homePageTitle = objHome.getHomePageTitle();
		Thread.sleep(3000);
		Assert.assertTrue(homePageTitle.toLowerCase().startsWith("actionable insights"));
	}
	
	@Test(priority = 1)
	public void homePageToReqInfoPage_verifyTitle_success() throws InterruptedException{
		objHome.clickRequestInfo();
		objReqInfo = new RequestInfoPage(driver);
		Thread.sleep(3000);
		String requestInfoPageTitle = objReqInfo.getRequestInfoTitle();
		Assert.assertTrue(requestInfoPageTitle.toLowerCase().contains("request more info"));
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.close();
	}
}
