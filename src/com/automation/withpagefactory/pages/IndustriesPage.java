package com.automation.withpagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndustriesPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/main/article/div[1]/div[1]")
	WebElement industriesPageTitle;

	public IndustriesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getIndustriesPageTitle() {
		return industriesPageTitle.getText();
	}
}
