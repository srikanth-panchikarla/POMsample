package com.oakton.hwi.Testsuite;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to check Failed to respond alert is displayed 
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
* 01/06/2017                                1.0                          Sri Ram Kovvuri                            This Class is used to check Failed to respond alert is displayed  
                                                                                                                                                                   
*
*/
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oakton.hwi.Pages.ManualSPFailedtoResponseAlertPage;
import com.oakton.hwi.Pages.SPOfflineHealthCheckPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestManualSPFailedtoResponseAlertPage {

	WebDriver driver;
	ManualSPFailedtoResponseAlertPage NoresponseServiceProvider = new ManualSPFailedtoResponseAlertPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "ManualSPFailedtoResponseAlert";
	String windowHandle;
	WebDriverWait wait;
	String bookingID;
	String businessLocation;
	/*
	 * This method is to initialize the page elements and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = NoresponseServiceProvider.Setup();
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
				// rtd.readXcelSheet(SheetName,j,i);
				excelData[i - 1][j] = rtd.getCellData(sheetName, j, i);

			}
		}
		return excelData;
	}
	/*
	 * This method is used to check Failed to respond alert is displayed
	 */
	@Test(dataProvider = "Data")
	public void failToRespondAlert(String Testcase, String AbnName, String FirstName, String MailId, String LastName,
			String LandlineNumber, String MobileNumber, String NoofWorkers, String NoofWorkSites, String TextWork,
			String TextAddress, String Textnumb, String GmailUsername, String GmailPassword, String newPassword,
			String ConfirmPassword, String servprovtext, String Adminusername, String AdminPass) throws Exception {
		try {
			Log.info("******** :::: Inside the failToRespondAlert :::::*********");
			NoresponseServiceProvider.Reg_TextABNName.sendKeys(AbnName);
			NoresponseServiceProvider.Reg_TextFirstName1.sendKeys(FirstName);
			String bFirstName = NoresponseServiceProvider.Reg_TextFirstName1.getAttribute("value");
			NoresponseServiceProvider.Reg_TextEmail.sendKeys(MailId + "@gmail.com");
			String businessMailID = NoresponseServiceProvider.Reg_TextEmail.getAttribute("value");
			NoresponseServiceProvider.Reg_ButtonClick1.click();
			String ABNValue = NoresponseServiceProvider.Reg_RadioButton.getAttribute("value");
			String Businessname = NoresponseServiceProvider.RegBussiness_text.getText();
			System.out.println(Businessname);
			System.out.println(businessMailID);

			Thread.sleep(5000);
			assertEquals("http://test.gethealthyatwork.com.au:7001/BusinessRegistration/RegisterStep2",
					driver.getCurrentUrl());

			NoresponseServiceProvider.Reg_RadioButton.click();
			businessLocation = NoresponseServiceProvider.businessEntityLocationCaputure.getText().replaceAll(".*,", "");
			NoresponseServiceProvider.Reg_Buttonclick2.click();

			NoresponseServiceProvider.Reg_TextLastName.sendKeys(LastName);
			NoresponseServiceProvider.Reg_TextPhone.sendKeys(LandlineNumber);
			NoresponseServiceProvider.Reg_TextMobile1.sendKeys(MobileNumber);
			NoresponseServiceProvider.Reg_ButtonClick3.click();
			Thread.sleep(3000);
			NoresponseServiceProvider.Reg_TextEmp.sendKeys(NoofWorkers);
			NoresponseServiceProvider.Reg_TextSites.sendKeys(NoofWorkSites);
			Thread.sleep(2000);
			NoresponseServiceProvider.Reg_TextWork.sendKeys(TextWork);
			NoresponseServiceProvider.Reg_TextAddrs.sendKeys(TextAddress);
			Thread.sleep(2000);
			NoresponseServiceProvider.Reg_TextAddrs.sendKeys(Keys.ARROW_DOWN);
			NoresponseServiceProvider.Reg_TextAddrs.sendKeys(Keys.ENTER);
			NoresponseServiceProvider.Reg_TextAddrs.sendKeys(Keys.ENTER);
			NoresponseServiceProvider.Reg_TextNumb.sendKeys(Textnumb);
			NoresponseServiceProvider.Reg_SubmitRegbtn.click();
			Thread.sleep(2000);

			Boolean confirmDialog = NoresponseServiceProvider.dialogConfirm_click.isDisplayed();
			if (confirmDialog == true) {
				NoresponseServiceProvider.yesConfirmbtn_click.click();
			}

			driver.get("https://accounts.google.com/signin");
			NoresponseServiceProvider.Gmail_UserName.sendKeys(GmailUsername);
			NoresponseServiceProvider.Gmail_NextClick.click();
			NoresponseServiceProvider.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			NoresponseServiceProvider.Gmail_NextClick.click();
			Thread.sleep(2000);
			NoresponseServiceProvider.GmailLogo_Click.click();
			NoresponseServiceProvider.Gmail_Searchbar.sendKeys(bFirstName);
			Thread.sleep(2000);
			NoresponseServiceProvider.Gmail_SearchBtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(NoresponseServiceProvider.Gmail_ClickMail));
			NoresponseServiceProvider.Gmail_ClickMail.click();
			NoresponseServiceProvider.Gmail_ClickActivationLink.click();
			Thread.sleep(2000);
			String windowHandle = driver.getWindowHandle();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			NoresponseServiceProvider.newpwd.sendKeys(newPassword);
			NoresponseServiceProvider.Conf_newpwd.sendKeys(ConfirmPassword);
			NoresponseServiceProvider.next_btn.click();
			Thread.sleep(2000);

			if (!businessLocation.contains("NSW")) {
				NoresponseServiceProvider.RadioWorkbtn.click();
				NoresponseServiceProvider.Submitbtn.click();
			}

			Thread.sleep(4000);
			NoresponseServiceProvider.ServiceProviderRadio_btn.click();
			NoresponseServiceProvider.ServiceProviderRadio_btn1.click();
			// Autosrvcprov_radbtn.click();
			NoresponseServiceProvider.ManualAllocationRadio_btn.click();
			NoresponseServiceProvider.preferredServprovtxt.sendKeys(servprovtext);
			NoresponseServiceProvider.nextbtn.click();
			Thread.sleep(2000);
			NoresponseServiceProvider.CGURadio_btn.click();
			NoresponseServiceProvider.TVRadio_btn.click();
			NoresponseServiceProvider.NoRadio_btn.click();
			NoresponseServiceProvider.Acctivation_nextbtn.click();
			Thread.sleep(3000);
			Assert.assertEquals(
					"http://test.gethealthyatwork.com.au:7001/Account%20Activation/Business/AccountActivationConfirmation",
					driver.getCurrentUrl());
			NoresponseServiceProvider.TakemetoYourAc_btn.click();
			// FinalizeDetails_btn.click();
			Thread.sleep(2000);
			NoresponseServiceProvider.Logout_btn.click();
			Thread.sleep(2000);
			NoresponseServiceProvider.BusineesUsername_Txt.sendKeys(Adminusername);
			NoresponseServiceProvider.BusinessPassword_Txt.sendKeys(AdminPass);
			NoresponseServiceProvider.BusineesLogin_btn.click();

			Thread.sleep(15 * 60 * 1000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			NoresponseServiceProvider.View_btn.click();
			Thread.sleep(3000);
			String AlertText = NoresponseServiceProvider.Fail_text.getText();
			String mailingText = NoresponseServiceProvider.mailText.getText();

			Assert.assertEquals("Exception - Failed To Respond Notification", AlertText);
			Assert.assertEquals(businessMailID, mailingText);
			Log.info("******** :::: End the failToRespondAlert :::::*********");
		} catch (Exception e)

		{
			Log.error("Exception Error in autoAllocationSPApproves Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
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
