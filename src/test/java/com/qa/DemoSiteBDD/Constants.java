package com.qa.DemoSiteBDD;

public class Constants {

	public static final String FeatureFile = "C:\\Users\\Admin\\Documents\\Lucy Hamilton\\DemoSiteBDD\\src\\test\\java\\featureFile.feature";
	//getting the user directory and it will get it from where the current project is located 
	public static final String ReportFile = System.getProperty("user.dir") + "\\reportDemo.html";  
	
	public static final String ChromeDriver = "C:/Users/Admin/Documents/Selenium/chromedriver.exe"; 
	
	public static final String HomePage = "http://php.thedemosite.co.uk/index.php";
	public static final String UserPage = "http://php.thedemosite.co.uk/addauser.php"; 
	public static final String LogPage = "http://php.thedemosite.co.uk/login.php";
	public static final String UserPageButton = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
	public static final String LogPageButton = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"; 
	
}
