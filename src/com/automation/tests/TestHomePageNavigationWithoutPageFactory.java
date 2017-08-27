package com.automation.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.withoutpagefactory.pages.AboutPage;
import com.automation.withoutpagefactory.pages.HomePage;

/**
 * Test cases for Home Page and its navigation to About Page
 * @author Poornima
 *
 */
public class TestHomePageNavigationWithoutPageFactory {
	public WebDriver driver;
	AboutPage objAbout;
	HomePage objHome;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Poornima/Desktop/Selenium Web Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.uptake.com/");
		objHome = new HomePage(driver);
	}

	/*
	 * Tests navigation from Home Page to Contact Page.
	 */
	@Test(priority = 0)
	public void invokeHomePage_verifyTitle_success() throws InterruptedException {
		objHome = new HomePage(driver);
		String homePageTitle = objHome.getHomePageTitle();
		Thread.sleep(3000);
		Assert.assertTrue(homePageTitle.toLowerCase().contains("uptake is the actionable insights platform"));
		
		objHome.clickAbout();
		objAbout = new AboutPage(driver);
		Thread.sleep(3000);
		String aboutPageTitle = objAbout.getAboutPageTitle();
		Assert.assertTrue(aboutPageTitle.toLowerCase().contains("uptake is transforming "));
	}

	@AfterMethod
	public void cleanUp(){
		driver.close();
	}
}
