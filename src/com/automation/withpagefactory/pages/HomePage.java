package com.automation.withpagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(className = "hero__title")
	WebElement titleText;
	@FindBy(xpath="/html/body/header/div[1]/div[2]/button")
	WebElement btnClick;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getHomePageTitle(){
		return titleText.getText();
	}

	public void clickRequestInfo() {
		btnClick.click();
	}
}
