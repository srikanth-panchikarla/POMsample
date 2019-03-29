package com.oakton.hwi.Testsuite;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to create business  
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
* 01/06/2017                                1.0                          Sri Ram Kovvuri                            This Class is used to create business
                                                                                                                                                                   
*
*/
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.oakton.hwi.Pages.CreateBusinessPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestCreateBusinessPage {

	WebDriver driver;
	String sheetName = "RegisterBusiness";
	CreateBusinessPage createbusiness = new CreateBusinessPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();

	/*
	 * This method is to initialize the page elements and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = createbusiness.Setup();
	}

	/*
	 * This method is to retrieve test data from excel sheet
	 */
	@DataProvider(name = "Data")
	public Object[][] testData() throws Exception

	{
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
	 * This method is used to create business
	 */
	@Test(dataProvider = "Data")
	public void businessUserCreation(String Testcase, String AbnName, String FirstName, String MailId, String LastName,
			String LandlineNumber, String MobileNumber, String NoofWorkers, String NoofWorkSites, String TextWork,
			String TextAddress, String Textnumb) throws Exception {

		try {
			Log.info("******** :::: Inside the businessUserCreation :::::*********");
			createbusiness.Reg_TextABNName.sendKeys(AbnName);
			createbusiness.Reg_TextFirstName1.sendKeys(FirstName);
			createbusiness.Reg_TextEmail.sendKeys(MailId);
			createbusiness.Reg_ButtonClick1.click();
			Thread.sleep(5000);
			assertEquals("http://test.gethealthyatwork.com.au:7001/BusinessRegistration/RegisterStep2",
					driver.getCurrentUrl());
			createbusiness.Reg_RadioButton.click();
			createbusiness.Reg_ButtonNext.click();
			createbusiness.Reg_TextLastName.sendKeys(LastName);
			createbusiness.Reg_TextPhone.sendKeys(LandlineNumber);
			createbusiness.Reg_TextMobile1.sendKeys(MobileNumber);
			createbusiness.Reg_confirmChkbtn.click();
			Thread.sleep(3000);
			createbusiness.Reg_TextEmp.sendKeys(NoofWorkers);
			createbusiness.Reg_TextSites.sendKeys(NoofWorkSites);
			Thread.sleep(2000);
			createbusiness.Reg_TextWork.sendKeys(TextWork);
			createbusiness.Reg_TextAddrs.sendKeys(TextAddress);
			Thread.sleep(2000);
			createbusiness.Reg_TextAddrs.sendKeys(Keys.ARROW_DOWN);
			createbusiness.Reg_TextAddrs.sendKeys(Keys.ENTER);
			createbusiness.Reg_TextAddrs.sendKeys(Keys.ENTER);
			createbusiness.Reg_TextNumb.sendKeys(Textnumb);
			createbusiness.Reg_SubmitRegbtn.click();
			Assert.assertEquals(
					"http://test.gethealthyatwork.com.au:7001/Business%20Registration/Register%20Step%202%20Confirm",
					driver.getCurrentUrl());
			Log.info("******** :::: End the businessUserCreation :::::*********");
		}

		catch (Exception e)

		{
			Log.error("Exception Error in businessUserCreation Method" + e);
			capturescreen.getFailuerScreenShot(driver, screenshotpath, sheetName);
			Assert.fail("Exception Error in businessUserCreation Method" + e);
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
