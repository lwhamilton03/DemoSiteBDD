package com.qa.DemoSiteBDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPage {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userBox; 
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passBox; 
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit; 
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement checkLogInSuccess; 
	
	public void checkUser(String username, String password)
	{
		userBox.click();
		userBox.sendKeys(username);
		passBox.click();
		passBox.sendKeys(password);
		submit.click();
	}

	public WebElement getCheckLogInSuccess() {
		return checkLogInSuccess;
	}

	public void setCheckLogInSuccess(WebElement checkLogInSuccess) {
		this.checkLogInSuccess = checkLogInSuccess;
	}
	
}
