package com.oakton.hwi.Testsuite;

import java.io.IOException;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to create Online Health Check for the business 
*  
* @author Sri Ram Kovvuri
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
* 01/06/2017                                1.0                          Sri Ram Kovvuri                            This Class is used to create Online Health Check
                                                                                                                                                                   
*
*/
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oakton.hwi.Pages.BusinessHealthCheckOnlinePage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestBusinessHealthCheckOnlinePage {
	WebDriver driver;
	BusinessHealthCheckOnlinePage onlineHealthCheck = new BusinessHealthCheckOnlinePage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "BusinessOnlineHealthChk";
	String windowHandle;
	ArrayList tabs;

	/*
	 * This method is to initialize the page elements and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = onlineHealthCheck.Setup();
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
	 * This method is used to create online health check for business
	 */
	@Test(dataProvider = "Data")
	public void healthCheckOnline(String Testcase, String BusinessUsername, String Password, String GmailUserName,
			String GmailPassword, String WaistSize) throws InterruptedException, Exception {

		try {

			Log.info("******** :::: Inside the healthCheckOnline :::::*********");
			onlineHealthCheck.loginLinkClick.click();
			onlineHealthCheck.BusineesUsername_Txt.sendKeys(BusinessUsername + "@gmail.com");
			onlineHealthCheck.BusinessPassword_Txt.sendKeys(Password);
			onlineHealthCheck.BusineesLogin_btn.click();
			Thread.sleep(1000);
			onlineHealthCheck.manageHealthcheck_Link.click();
			Select dd = new Select(onlineHealthCheck.Worksite_dropdown);
			dd.selectByIndex(1);
			Thread.sleep(2000);
			String name = onlineHealthCheck.BusinessUsernameText.getText();
			onlineHealthCheck.GenerateHealthcheckEmail_btn.click();
			Thread.sleep(2000);
			onlineHealthCheck.Confirmation_btn.click();
			Thread.sleep(2000);
			WebDriverWait waiting = new WebDriverWait(driver, 10);
			waiting.until(ExpectedConditions.elementToBeClickable(onlineHealthCheck.Close_btn));
			onlineHealthCheck.Close_btn.click();
			driver.get("https://accounts.google.com/signin");
			onlineHealthCheck.Gmail_UserName.sendKeys(GmailUserName);
			onlineHealthCheck.Gmail_NextClick.click();
			onlineHealthCheck.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			onlineHealthCheck.Gmail_NextClick.click();
			Thread.sleep(2000);
			onlineHealthCheck.GmailLogo_Click.click();
			onlineHealthCheck.Gmail_Searchbar.sendKeys(name);
			Thread.sleep(2000);
			onlineHealthCheck.Gmail_SearchBtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(onlineHealthCheck.Gmail_ClickMail));
			Thread.sleep(2000);
			onlineHealthCheck.Gmail_ClickMail.click();
			Thread.sleep(2000);
			onlineHealthCheck.Gmail_HealthCheckActivation_Link.click();
			Thread.sleep(2000);
			windowHandle = driver.getWindowHandle();
			tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			onlineHealthCheck.Agree_checkbox.click();
			Thread.sleep(2000);
			onlineHealthCheck.Submit_btn.click();
			Thread.sleep(2000);
			onlineHealthCheck.Agegroup_sel.click();
			Thread.sleep(2000);
			onlineHealthCheck.gender_Sel.click();
			Thread.sleep(2000);
			onlineHealthCheck.Ethnicity_sel.click();
			Thread.sleep(2000);
			onlineHealthCheck.AsianDescent_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Born_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.ParentsDiabetic_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Bloodpressure_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Medication_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Smokecigarettes_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.veggie_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.physicalexercise_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Waist_Txt.sendKeys(WaistSize);
			Thread.sleep(1000);
			onlineHealthCheck.okbutton_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.SmokingCigareetes_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Smokecigar.click();
			Thread.sleep(1000);
			onlineHealthCheck.Firstcigar_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Cigareete_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.vegetable_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Servingfruits_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Fishandchips_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.chocandBis_Sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.softdrinks_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.plainwater_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.Alcoholoften_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.DrinkSize_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.WalkbyOffice_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.JobAct_sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.PhyActiv_Sel.click();
			Thread.sleep(1000);
			onlineHealthCheck.HealthCheckresult_btn.click();
			Thread.sleep(1000);
			onlineHealthCheck.PDF_btn.click();
			Thread.sleep(2000);
			windowHandle = driver.getWindowHandle();
			tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(2));

			Assert.assertEquals("http://test.gethealthyatwork.com.au:7001/api/sitecore/HealthCheck/DownloadResults",
					driver.getCurrentUrl());
			Log.info("******** :::: End the healthCheckOnline :::::*********");

		} catch (Exception e) {
			
			Log.error("Exception Error in healthCheckOnline Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			Assert.fail("Exception Error in healthCheckOnline Method::::: " + e);
		}

	}

	/*
	 * @ Method Description This method will save the Passed or Failed
	 * screenshots
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
