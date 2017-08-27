package com.automation.withoutpagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Home Page(Without PageFactory)
 * @author Poornima
 *
 */
public class HomePage {
	WebDriver driver;
	AboutPage objAbout;
	By titleText = By.className("hero__subtitle");
	By btnClick = By.xpath("/html/body/header/div[1]/nav/a[1]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAbout() {
		driver.findElement(btnClick).click();
	}

	public String getHomePageTitle() {
		return driver.findElement(titleText).getText();
	}

}
