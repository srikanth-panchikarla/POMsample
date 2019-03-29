package com.oakton.hwi.Testsuite;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is to create Government Agency via HWI Admin and check details are populated in Home page when ABN number is entered  
* @author Srikanth Panchikarla
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is to create Government Agency via HWI Admin and 
* 																														 check details are populated in Home page when ABN number is entered   
*                                                                                                                                                                                
*
*/
import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oakton.hwi.Pages.CreateBusinessPage;
import com.oakton.hwi.Pages.CreateGovPage;
import com.oakton.hwi.Pages.PopulateGovDetailsPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestPopulateGovDetailsPage {

	WebDriver driver;

	CreateGovPage creategovpage = new CreateGovPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	PopulateGovDetailsPage businesspage = new PopulateGovDetailsPage();

	String path = rcf.getExcelPath();
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "CreateGovAgency";
	String emailValuetbl;
	String SearchValue;
	String emailValue;
	String getAbnValue;
	String abnValueInTable;
	String retrieveFirstName;
	String retrieveEmail;

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = creategovpage.Setup();
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
	 * This Method is to create Government Agency via HWI Admin
	 * 
	 */
	@Test(dataProvider = "Data")
	public void createGovAgencyAndPopulate(String TestCase, String Username, String Password, String ClusterName,
			String AgencyName, String AgencyABN, String AgencyContactFirstName, String AgencyContactLastName,
			String AgencyContactEmail, String AgencyContactPhoneorMobile, String TotalNoofFTE,
			String TotalNoofWorksites, String WorksiteName, String AddressLine, String Suburb, String Postcode,
			String Numberofworkers, String TotaloffacetofaceHCrequired, String SPsupportedHP, String SPFriendlyId)
			throws Exception

	{
		try {
			Log.info("******** :::: Inside the createGovAgencyAndPopulate :::::*********");
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			System.out.println("In FillData method");
			creategovpage.loginLinkClick.click();
			creategovpage.emailtxt.sendKeys(Username);
			creategovpage.passwordtxt.sendKeys(Password);
			creategovpage.loginButton.click();
			creategovpage.govAgencyLink.click();
			// Validating when clicked on Gov Agency tab page and is navigated to Gov page
			assertEquals("http://test.gethealthyatwork.com.au:7001/en/HWI-Admin/Government-Agency",
					driver.getCurrentUrl());
			creategovpage.btnAddGovAgency.click();
			creategovpage.inputClusterName.sendKeys(ClusterName + randomInt);
			creategovpage.inputAgencyName.sendKeys(AgencyName + randomInt);
			creategovpage.inputAgencyABN.sendKeys(AgencyABN + randomInt);
			getAbnValue = creategovpage.inputAgencyABN.getAttribute("value");
			creategovpage.inputAgencyFirstName.sendKeys(AgencyContactFirstName);
			creategovpage.inputAgencyLastName.sendKeys(AgencyContactLastName);
			creategovpage.inputAgencyEmail.sendKeys(AgencyContactEmail + randomInt + "@gmail.com");
			emailValue = creategovpage.inputAgencyEmail.getAttribute("value");
			creategovpage.inputAgencyPhone.sendKeys(AgencyContactPhoneorMobile);
			creategovpage.inputAgencyNoOfFTE.sendKeys(TotalNoofFTE);
			creategovpage.inputAgencyNoOfWorksites.sendKeys(TotalNoofWorksites);
			creategovpage.inputWorkSiteName.sendKeys(WorksiteName);
			creategovpage.inputWorkSiteAddressline1.sendKeys(AddressLine);
			creategovpage.inputSuburd.sendKeys(Suburb);
			creategovpage.inputPostcode.sendKeys(Postcode);
			creategovpage.inputNumberOfWorkers.sendKeys(Numberofworkers);
			creategovpage.inputTotalNoOfHCsrequire.sendKeys(TotaloffacetofaceHCrequired);
			creategovpage.inputLiketoaHP.sendKeys(SPsupportedHP);
			creategovpage.inputSpFrinedlyId.sendKeys(SPFriendlyId + randomInt);
			creategovpage.btnSave.click();
			Thread.sleep(5000);
			creategovpage.logoutLink.click();
			Thread.sleep(2000);
			creategovpage.imgHome.click();
			Thread.sleep(2000);
			creategovpage.Reg_TextABNName.sendKeys(getAbnValue);
			creategovpage.Reg_TextFirstName1.click();
			Thread.sleep(3000);
			retrieveFirstName = creategovpage.Reg_TextFirstName1.getAttribute("value");
			retrieveEmail = creategovpage.Reg_TextEmail.getAttribute("value");
			// Assert.assertEquals(retrieveFirstName, AgencyContactFirstName);
			Assert.assertEquals(retrieveEmail, emailValue);
			Log.info("******** :::: End the createGovAgencyAndPopulate :::::*********");
		} catch (Exception e)

		{
			Log.error("Exception Error in autoAllocationSPApproves Method" + e);
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
