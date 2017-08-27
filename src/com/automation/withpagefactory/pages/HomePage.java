package com.automation.withpagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home Page(With PageFactory)
 * @author Poornima
 *
 */
public class HomePage {
	WebDriver driver;
	@FindBy(className = "hero__title")
	WebElement homePageTitle;
	@FindBy(xpath="/html/body/header/div[1]/div[2]/button")
	WebElement btnClick;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getHomePageTitle(){
		return homePageTitle.getText();
	}

	public void clickRequestInfo() {
		btnClick.click();
	}
}
