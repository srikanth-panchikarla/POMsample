package com.oakton.hwi.Utility;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to open Web browser
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
*01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used open Web browser 
*                                                                                                                                                                                 
*
*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class BrowserFactory {

	public static WebDriver driver;
	static ReadConfigFile rcf = new ReadConfigFile();

	/*
	 * This method is to open web browser
	 */
	public static WebDriver openBrowser(String browser) {
		Log.info("******** :::: Inside the openBrowser :::::*********");
		if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", rcf.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", rcf.getIEPath());
			driver = new InternetExplorerDriver();
		} else if (browser.equals("GC")) {
			System.setProperty("webdriver.chrome.driver", rcf.getChromePath());
			driver = new ChromeDriver();
		}

		String appUrl = rcf.getApplicationURL();
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
