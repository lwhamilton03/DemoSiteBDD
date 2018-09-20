package com.qa.DemoSiteBDD;

import com.relevantcodes.extentreports.ExtentReports;

public class Constants {

	
	
	/* You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * You need to make all of these Uppercase for the name
	 * */
	
	public static final String LOGSCREENSHOT = System.getProperty("user.dir") + "\\screenshot.png";
	public static final String FeatureFile = "C:\\Users\\Admin\\Documents\\Lucy Hamilton\\DemoSiteBDD\\src\\test\\java\\featureFile.feature";
	//getting the user directory and it will get it from where the current project is located 
	public static final String ReportFile = System.getProperty("user.dir") + "\\reportDemo.html";  
	public static final String ExcelReportPath = "C:\\Users\\Admin\\Documents\\Lucy Hamilton\\DemoSiteBDD\\";
	public static final String ExcelReportFile = "excelReport.xlsx";
	
	public static final String ChromeDriver = "C:/Users/Admin/Documents/Selenium/chromedriver.exe"; 
	
	public static final String HomePage = "http://php.thedemosite.co.uk/index.php";
	public static final String UserPage = "http://php.thedemosite.co.uk/addauser.php"; 
	public static final String LogPage = "http://php.thedemosite.co.uk/login.php";
	public static final String UserPageButton = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
	public static final String LogPageButton = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"; 
	
	//Should really be in another class! Do that later! 
	//Move to LOG PAGE YOU MUG 
	public static int Count = 0; 
	
	public static ExtentReports report = new ExtentReports(Constants.ReportFile, true);
}
