package com.automation.withpagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * RequestInfo Page(With PageFactory)
 * @author Poornima
 *
 */
public class RequestInfoPage {
	WebDriver driver;
	@FindBy (xpath= "/html/body/header/div[1]/div[2]/button")
	WebElement requestInfoPageTitle;
	@FindBy (xpath= "/html/body/header/div[1]/nav/a[3]")
	WebElement btnCLick;
	
	public RequestInfoPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getRequestInfoPageTitle(){
		return requestInfoPageTitle.getText();
	}
	public void clickIndustries(){
		btnCLick.click();
	}
}
