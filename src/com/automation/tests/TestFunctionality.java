package com.automation.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.withoutpagefactory.pages.AboutPage;
import com.automation.withoutpagefactory.pages.HomePage;

public class TestFunctionality {
	public WebDriver driver;
	AboutPage objAbout;
	HomePage objHome;

	@BeforeMethod
	public void setUp() {
		System.out.println("I am setting up");
		System.setProperty("webdriver.chrome.driver", "/Users/Poornima/Desktop/Selenium Web Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.uptake.com/");
		objHome = new HomePage(driver);
		objHome.clickAbout();
		objAbout = new AboutPage(driver);
	}

	@Test(priority = 0)
	public void test_Home_Page() throws InterruptedException {
		objHome = new HomePage(driver);
		String homePageTitle = objHome.getHomePageTitle();
		Thread.sleep(3000);
		System.out.println(homePageTitle);
		Assert.assertTrue(homePageTitle.toLowerCase().contains("uptake is the actionable insights platform"));
	}

	@Test(priority = 1)
	public void test_Home_Navigation() throws InterruptedException{
		Thread.sleep(3000);
		String aboutPageTitle = objAbout.getAboutPageTitle();
		System.out.println(aboutPageTitle);
		Assert.assertTrue(aboutPageTitle.toLowerCase().contains("uptake is transforming "));
	}
	
	@AfterMethod
	public void cleanUp(){
		System.out.println("I am cleaning up");
		driver.close();
	}

}
