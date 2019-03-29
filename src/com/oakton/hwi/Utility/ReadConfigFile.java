package com.oakton.hwi.Utility;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used read config properties file
*  
* @author Srikanth Panchikarla
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
*01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used read config properties file 
*                                                                                                                                                                                 
*
*/
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

	Properties pro;

	/*
	 * This method is to read config file
	 */
	public ReadConfigFile() {

		try {

			File src = new File("./Config/config.properties");
			FileInputStream fio = new FileInputStream(src);
			pro = new Properties();
			pro.load(fio);

		} catch (Exception e) {

			System.out.println("Exception Message ::::" + e);

		}
	}

	/*
	 * This method is to read path of ChromeDriver from config file
	 */
	public String getChromePath() {
		
		String path = pro.getProperty("ChromeDriver");
		return path;
	}
	/*
	 * This method is to read path of Firefox from config file
	 */
	public String getFirefoxPath() {
		String path = pro.getProperty("FireFoxDriver");
		return path;
	}
	/*
	 * This method is to read path of InternetExplorerDriver from config file
	 */
	public String getIEPath() {
		String path = pro.getProperty("IEDriver");
		return path;
	}
	/*
	 * This method is to read path of application URL from config file
	 */
	public String getApplicationURL() {
		String url = pro.getProperty("ApplicationURL");
		return url;
	}
	/*
	 * This method is to read path of excelsheet from config file
	 */
	public String getExcelPath() {
		System.out.println("In getExcelPath method");
		String xcelPath = pro.getProperty("ExcelPath");
		return xcelPath;
	}

	public String getScreenPath() {
		System.out.println("In getScreenPath method");
		String screenshotPath = pro.getProperty("ScreenshotPath");
		return screenshotPath;
	}
	/*
	 * This method is to read path of Pass screen from config file
	 */
	public String getPassScreenPath() {
		System.out.println("In getScreenPath method");
		String screenshotPath = pro.getProperty("PassScreenshotPath");
		return screenshotPath;
	}
	/*
	 * This method is to read path of Fail screen from config file
	 */
	public String getFailScreenPath() {
		System.out.println("In getScreenPath method");
		String screenshotPath = pro.getProperty("FailScreenshotPath");
		return screenshotPath;
	}
	/*
	 * This method is to read path of TestNG xml file from config file
	 */
	public String getTestNGPath() {
		System.out.println("Testng.xml");
		String TestNgPath = pro.getProperty("TestNGXmlPath");
		return TestNgPath;
	}
	
	public String getBrowser() {
		System.out.println("Get Browser");
		String browser = pro.getProperty("Browser");
		return browser;
	}
}
