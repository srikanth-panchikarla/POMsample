package com.oakton.hwi.Utility;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used capture failed and passed screenshots
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
*01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used capture failed and passed screenshots 
*                                                                                                                                                                                 
*
*/
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CaptureScreenshot {

	WebDriver driver;
	/*
	 * This method is to capture Failed screenshot
	 */
	public void getFailuerScreenShot(WebDriver driver, String screenshotpath, String SheetName) throws IOException {
		try {
		PageFactory.initElements(driver, this);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in c drive with name
		// "screenshot.png"
		String Path = screenshotpath + SheetName + "_FAILscreenshot_" + dateFormat.format(date).toString() + ".png";
	
			FileUtils.copyFile(scrFile, new File(Path));
		} catch (IOException e) {
		Log.error("IOException error in getFailuerScreenShot"+ e);
		}

	}
	/*
	 * This method is to capture Passed screenshot
	 */
	public void getSuccessScreenShot(WebDriver driver, String screenshotpath, String SheetName) throws IOException {

		try{
			PageFactory.initElements(driver, this);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date date = new Date();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in c drive with name
			// "screenshot.png"
			String Path = screenshotpath + SheetName + "_PASSscreenshot_" + dateFormat.format(date).toString() + ".png";
			FileUtils.copyFile(scrFile, new File(Path));
		}
		catch(IOException e)
		{
			Log.error("IOException error getSuccessScreenShot" + e);
		}
		

	}

}
