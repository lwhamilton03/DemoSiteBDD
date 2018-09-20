package com.qa.DemoSiteBDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeDemoPage {

	@FindBy(xpath = Constants.UserPageButton)
	private WebElement userPage; 
	
	@FindBy(xpath = Constants.LogPageButton)
	private WebElement logPage; 
	
	public void clickUserPage()
	{
		userPage.click(); 
	}
	
	public void clickLogPage()
	{
		logPage.click(); 
	}
}
