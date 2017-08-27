package com.automation.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.withpagefactory.pages.HomePage;
import com.automation.withpagefactory.pages.IndustriesPage;
import com.automation.withpagefactory.pages.RequestInfoPage;

/**
 * Test cases for Home Page and its navigation to Request Info Page
 * @author Poornima
 *
 */
public class TestHomePageNavigationWithPageFactory {
	public WebDriver driver;
	RequestInfoPage objReqInfo;
	IndustriesPage objIndustries;
	HomePage objHome;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Poornima/Desktop/Selenium Web Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.uptake.com/");
		objHome = new HomePage(driver);
	}

	/*
	 * Tests navigation from Home Page to Contact Page and from Contact Page to Industries 
	 * Page.
	 */
	@Test(priority = 0)
	public void doNavigationFromHome_verifyTitle_success() throws InterruptedException {
		String homePageTitle = objHome.getHomePageTitle();
		Thread.sleep(2000);
		Assert.assertTrue(homePageTitle.toLowerCase().startsWith("actionable insights"));
		
		objHome.clickRequestInfo();
		objReqInfo = new RequestInfoPage(driver);
		Thread.sleep(2000);
		String requestInfoPageTitle = objReqInfo.getRequestInfoPageTitle();
		Assert.assertTrue(requestInfoPageTitle.toLowerCase().contains("request more info"));
		
		objReqInfo.clickIndustries();
		objIndustries = new IndustriesPage(driver);
		Thread.sleep(2000);
		String industriesPageTitle = objIndustries.getIndustriesPageTitle();
		Assert.assertTrue(industriesPageTitle.toLowerCase().contains("built to scale insights across global industries"));
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.close();
	}
}
