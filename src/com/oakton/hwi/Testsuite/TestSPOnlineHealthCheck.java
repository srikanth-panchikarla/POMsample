package com.oakton.hwi.Testsuite;

import java.io.IOException;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is to create online Health Check for Business via Service Provider   
* @author Srikanth Panchikarla
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is to create online Health Check for Business via Service Provider   
*                                                                                                                                                                                
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

public class TestSPOnlineHealthCheck {

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
	String sheetName = "SPOnlineHealthCheck";
	String windowHandle;

	/*
	 * This method is to initialize the page element and the browser
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
	 * This method is to create online Health Check for Business via Service
	 * Provider
	 * 
	 */
	@Test(dataProvider = "Data")
	public void spHealthOnline(String Testcase, String spUsernamer, String SpPassword, String quicksearch,
			String totalhealthcheck, String WaistSize) throws InterruptedException, Exception {

		try

		{
			Log.info("******** :::: Inside the spHealthOnline :::::*********");
			onlineHealthCheck.loginLinkClick.click();
			onlineHealthCheck.emailtxt.sendKeys(spUsernamer);
			onlineHealthCheck.passwordtxt.sendKeys(SpPassword);
			onlineHealthCheck.loginButton.click();
			onlineHealthCheck.myBusinessLink.click();
			onlineHealthCheck.quickSearch.sendKeys(quicksearch);
			onlineHealthCheck.healthProgramManageLink.click();
			Thread.sleep(2000);
			onlineHealthCheck.launchHealthCheckTab.click();
			Thread.sleep(2000);
			onlineHealthCheck.totalNoOfHealthCheckTxt.sendKeys(totalhealthcheck);
			Thread.sleep(2000);
			onlineHealthCheck.createOnlineHealthCheckBtn.click();
			Thread.sleep(2000);
			onlineHealthCheck.launchBtn.click();
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
			onlineHealthCheck.nextButton.click();
			Thread.sleep(1000);
			onlineHealthCheck.ChkboxSmoking.click();
			Thread.sleep(1000);
			onlineHealthCheck.RadioBtnQuitline.click();
			Thread.sleep(1000);
			onlineHealthCheck.RadioBtnHealthInfo.click();
			Thread.sleep(1000);
			onlineHealthCheck.RadioBtnlocal.click();
			Thread.sleep(1000);
			onlineHealthCheck.ChkboxReferral.click();
			Thread.sleep(2000);
			onlineHealthCheck.backToHealthCheckLaunchPageBtn.click();
			Thread.sleep(2000);
			onlineHealthCheck.finalizeBtn.click();
			Thread.sleep(2000);
			onlineHealthCheck.modalDialogYesbtn.click();
			Thread.sleep(1000);
			Assert.assertEquals("Create Health Check Booking", driver.getTitle());
			Log.info("******** :::: End the spHealthOnline :::::*********");
		}

		catch (Exception e)

		{
			Log.error("Exception Error in spHealthOffline Method" + e);
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
