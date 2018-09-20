package com.qa.DemoSiteBDD;

import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver driver = null; 
	public ExtentReports report; 
	public ExtentTest test; 
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", Constants.ChromeDriver); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		report = new ExtentReports(Constants.ReportFile, false);
		
	}
	
	
	@Given("^That I created a User using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void that_I_created_a_User_using_username_and_password(String arg1, String arg2) {
		test = report.startTest("UserAndLogIn Test");
		driver.get(Constants.HomePage);
		HomeDemoPage home = PageFactory.initElements(driver, HomeDemoPage.class);
	    home.clickUserPage();
	    UserPage user = PageFactory.initElements(driver, UserPage.class);
	    test.log(LogStatus.INFO, "Create User. Username: " + arg1 + ", Password: " + arg2);
	    user.createUser(arg1, arg2);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^I log into the page using username \"([^\"]*)\" and passwprd \"([^\"]*)\"$")
	public void i_log_into_the_page_using_username_and_passwprd(String arg1, String arg2) {
		HomeDemoPage home = PageFactory.initElements(driver, HomeDemoPage.class);
		home.clickLogPage();
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		log.checkUser(arg1, arg2);
	}

	@Then("^I am successfully logged in$")
	public void i_am_successfully_logged_in() {
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		if(log.getCheckLogInSuccess().getText().equals("**Successful Login**"))
		{
			test.log(LogStatus.PASS, "**Login Successful");
		}
		else
		{
			test.log(LogStatus.FAIL, "**Login Unsuccessful");
		}
		Assert.assertEquals("**Login Unsuccessful", "**Successful Login**", log.getCheckLogInSuccess().getText());
	}
	
	@After
	public void tearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
