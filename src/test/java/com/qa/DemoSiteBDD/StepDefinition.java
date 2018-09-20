package com.qa.DemoSiteBDD;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	}
	
	
	@Given("^That I created a User using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void that_I_created_a_User_using_username_and_password(String arg1, String arg2) {
		test = Constants.report.startTest("UserAndLogIn Test");
		Constants.Count++; 
//		file = new FileInputStream(Constants.ExcelReportPath + Constants.ExcelReportFile);
//		XSSFWorkbook workbook = null; 
//		workbook = new XSSFWorkbook(file);
//		
//		XSSFSheet sheet = workbook.ExcelUtils.setCellData(Result, RowNum, ColNum);
//		XSSFCell cell = sheet.setCellData(); 
		driver.get(Constants.HomePage);
		HomeDemoPage home = PageFactory.initElements(driver, HomeDemoPage.class);
	    home.clickUserPage();
	    UserPage user = PageFactory.initElements(driver, UserPage.class);
	    test.log(LogStatus.INFO, "Create User. Username: " + arg1 + ", Password: " + arg2);
	    user.createUser(arg1, arg2);
	    try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^I log into the page using username \"([^\"]*)\" and passwprd \"([^\"]*)\"$")
	public void i_log_into_the_page_using_username_and_passwprd(String arg1, String arg2) {
		HomeDemoPage home = PageFactory.initElements(driver, HomeDemoPage.class);
		home.clickLogPage();
		ExcelUtils.setExcelFile(Constants.ExcelReportPath + Constants.ExcelReportFile, 0);
		ExcelUtils.setCellData(arg1, Constants.Count, 0);
		ExcelUtils.setCellData(arg2, Constants.Count, 1);
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		log.checkUser(arg1, arg2);
	}

	@Then("^I am successfully logged in$")
	public void i_am_successfully_logged_in() {
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		
		ExcelUtils.setExcelFile(Constants.ExcelReportPath + Constants.ExcelReportFile, 0);
		
		if(log.getCheckLogInSuccess().getText().equals("**Successful Login**"))
		{
			ExcelUtils.setCellData("PASS", Constants.Count, 2);
			test.log(LogStatus.PASS, "**Login Successful");
		}
		else
		{
			ExcelUtils.setCellData("FAIL", Constants.Count, 2);
			test.log(LogStatus.FAIL, "**Login Unsuccessful");
		}
		test.log(LogStatus.INFO, "Screenshot of Log In" + test.addScreenCapture(log.takeScreenShot(driver)));
		Assert.assertEquals("**Login Unsuccessful", "**Successful Login**", log.getCheckLogInSuccess().getText());
	}
	
	@After
	public void tearDown()
	{
		Constants.report.endTest(test);
		Constants.report.flush();
		driver.quit();
	}
}
