package com.automation.withoutpagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * About Page(Without PageFactory)
 * @author Poornima
 *
 */
public class AboutPage {
	public WebDriver driver;
	By titleText= By.className("hero__subtitle");

	public AboutPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getAboutPageTitle(){
		return driver.findElement(titleText).getText();
	}

}
