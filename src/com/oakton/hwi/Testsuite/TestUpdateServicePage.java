package com.oakton.hwi.Testsuite;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to Create Service Provider and update the details
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
* 01/06/2017                                1.0                          Srikanth Panchikarla                             This Class is used to Create Service Provider and update the details
*                                                                                                                                                                                
**/
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oakton.hwi.Pages.CreateServicePage;
import com.oakton.hwi.Pages.UpdateServicePage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestUpdateServicePage {

	WebDriver driver;

	UpdateServicePage updateservice = new UpdateServicePage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String path = rcf.getExcelPath();
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "UpdateServiceAddress";
	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = updateservice.Setup();
	}
	/*
	 * This method is to retrieve test data from excel sheet
	 */
	@DataProvider(name = "Data")
	public Object[][] testData() throws Exception {

		System.out.println("=====InSide testData method======");

		Object[][] excelData = null;

		int row = rtd.getRowCount(sheetName);
		int columns = rtd.getcolCount(sheetName);
		excelData = new Object[row - 1][columns];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = rtd.getCellData(sheetName, j, i);

			}
		}
		return excelData;
	}

	/*
	 * This Method is used for create Service Provider and update details
	 */
	@Test(dataProvider = "Data")
	public void updateServiceAddress(String TestCase, String username, String password, String SearchService,
			String AddressLine1, String AddressLine2, String Suburb, String State, String Postcode) throws Exception {

		try {
			Log.info("******** :::: Inside the updateServiceAddress :::::*********");
			updateservice.loginLinkClick.click();
			updateservice.emailtxt.sendKeys(username);
			updateservice.passwordtxt.sendKeys(password);
			updateservice.loginButton.click();
			updateservice.serviceProviderLink.click();
			updateservice.quickSerachTxtbx.sendKeys(SearchService);
			updateservice.modifyAddresslink.click();
			// Clear the fields
			updateservice.serviceProviderAddrs1txt.clear();
			updateservice.serviceProviderAddrs1txt.sendKeys(AddressLine1);
			updateservice.serviceProviderAddrs2txt.clear();
			updateservice.serviceProviderAddrs2txt.sendKeys(AddressLine2);
			updateservice.serviceProviderSuburbtxt.clear();
			updateservice.serviceProviderSuburbtxt.sendKeys(Suburb);
			// updateservice.serviceProviderStatetxt.clear();
			updateservice.serviceProviderStatetxt.sendKeys(State);
			updateservice.serviceProviderPostcodetxt.clear();
			updateservice.serviceProviderPostcodetxt.sendKeys(Postcode);
			updateservice.savechangesBtn.click();
			Assert.assertEquals("Edit Service Provider", driver.getTitle());
			updateservice.completeAccountSetupBtn.click();
			updateservice.closeDialogboxSuccessCreated.click();
			Assert.assertEquals("Service Providers", driver.getTitle());

			updateservice.quickSerachTxtbx.sendKeys(SearchService);
			updateservice.modifyAddresslink.click();
			assertEquals(AddressLine1, updateservice.serviceProviderAddrs1txt.getAttribute("value"));
			assertEquals(AddressLine2, updateservice.serviceProviderAddrs2txt.getAttribute("value"));
			assertEquals(Postcode, updateservice.serviceProviderPostcodetxt.getAttribute("value"));
			Log.info("******** :::: End the updateServiceAddress :::::*********");
		} catch (Exception e) {
			Log.error("Exception Error in updateServiceAddress Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);

		}

	}

	/*
	 * This method will save the Passed or Failed screenshots
	 */
	@AfterMethod()
	public void createScreenShot(ITestResult testResult) throws Exception

	{
		try {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				System.out.println(testResult.getStatus());
				capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			}

			if (testResult.getStatus() == ITestResult.SUCCESS) {
				System.out.println(testResult.getStatus());
				capturescreen.getSuccessScreenShot(driver, passScreenshotpath, sheetName);
			}
		} catch (Exception e) {

			Log.error(":::: Error in createScreenShot :::::::" + e);

		}
	}
}
