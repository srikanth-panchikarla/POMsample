package com.oakton.hwi.Testsuite;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used to check SP not match alert is created when there are no Service Providers to Allocate 
* @author Sri Ram Kovvuri
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
* 01/06/2017                                1.0                          Sri Ram Kovvuri                           This Class is used to check SP 
* 																													not match alert is created when there are no Service Providers to Allocate
                                                                                                                                                                   
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
import com.oakton.hwi.Pages.AutoAllocateSPNotMatchAlertPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestAutoAllocateSPNotMatchAlertPage {

	WebDriver driver;

	AutoAllocateSPNotMatchAlertPage spnotMatchAlert = new AutoAllocateSPNotMatchAlertPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "AutoSPNotAlert";
	String retrieveServiceProviderFullName;
	String email;
	String businessLocation;

	/*
	 * This method is to initialize the page elements and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = spnotMatchAlert.Setup();
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
	 * This method is to check when business is assigned to SP Automatically and
	 * Alert is triggered to the HWI Admin Saying SP is not matched
	 */
	@Test(dataProvider = "Data")
	public void spNotMatchAlert(String AbnName, String FirstName, String MailId, String LastName, String LandlineNumber,
			String MobileNumber, String NoofWorkers, String NoofWorkSites, String TextWork, String TextAddress,
			String Textnumb, String GmailUsername, String GmailPassword, String newPassword, String ConfirmPassword,
			String Adminusername, String AdminPass) throws Exception {
		try {
			spnotMatchAlert.Reg_TextABNName.sendKeys(AbnName);
			spnotMatchAlert.Reg_TextFirstName1.sendKeys(FirstName);
			String bFirstName = spnotMatchAlert.Reg_TextFirstName1.getAttribute("value");
			spnotMatchAlert.Reg_TextEmail.sendKeys(MailId + "@gmail.com");
			spnotMatchAlert.Reg_ButtonClick1.click();
			String ABNValue = spnotMatchAlert.Reg_RadioButton.getAttribute("value");
			String Businessname = spnotMatchAlert.RegBussiness_text.getText();

			Thread.sleep(5000);
			assertEquals("http://test.gethealthyatwork.com.au:7001/BusinessRegistration/RegisterStep2",
					driver.getCurrentUrl());

			spnotMatchAlert.Reg_RadioButton.click();
			Thread.sleep(2000);
			businessLocation = spnotMatchAlert.businessEntityLocationCaputure.getText().replaceAll(".*,", "");
			spnotMatchAlert.Reg_Buttonclick2.click();
			spnotMatchAlert.Reg_TextLastName.sendKeys(LastName);
			spnotMatchAlert.Reg_TextPhone.sendKeys(LandlineNumber);
			spnotMatchAlert.Reg_TextMobile1.sendKeys(MobileNumber);
			spnotMatchAlert.Reg_ButtonClick3.click();
			Thread.sleep(3000);
			spnotMatchAlert.Reg_TextEmp.sendKeys(NoofWorkers);
			spnotMatchAlert.Reg_TextSites.sendKeys(NoofWorkSites);
			Thread.sleep(2000);
			spnotMatchAlert.Reg_TextWork.sendKeys(TextWork);
			spnotMatchAlert.Reg_TextAddrs.sendKeys(TextAddress);
			Thread.sleep(2000);
			spnotMatchAlert.Reg_TextAddrs.sendKeys(Keys.ARROW_DOWN);
			spnotMatchAlert.Reg_TextAddrs.sendKeys(Keys.ENTER);
			spnotMatchAlert.Reg_TextAddrs.sendKeys(Keys.ENTER);
			spnotMatchAlert.Reg_TextNumb.sendKeys(Textnumb);
			spnotMatchAlert.Reg_SubmitRegbtn.click();
			Thread.sleep(2000);

			Boolean confirmDialog = spnotMatchAlert.dialogConfirm_click.isDisplayed();
			if (confirmDialog == true) {
				spnotMatchAlert.yesConfirmbtn_click.click();
			}

			driver.get("https://accounts.google.com/signin");
			spnotMatchAlert.Gmail_UserName.sendKeys(GmailUsername);
			spnotMatchAlert.Gmail_NextClick.click();
			spnotMatchAlert.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			spnotMatchAlert.Gmail_NextClick.click();
			Thread.sleep(2000);
			spnotMatchAlert.GmailLogo_Click.click();
			spnotMatchAlert.Gmail_Searchbar.sendKeys(bFirstName);
			Thread.sleep(2000);
			spnotMatchAlert.Gmail_SearchBtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(spnotMatchAlert.Gmail_ClickMail));
			spnotMatchAlert.Gmail_ClickMail.click();
			spnotMatchAlert.Gmail_ClickActivationLink.click();
			Thread.sleep(2000);
			//String windowHandle = driver.getWindowHandle();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			spnotMatchAlert.newpwd.sendKeys(newPassword);
			spnotMatchAlert.Conf_newpwd.sendKeys(ConfirmPassword);
			spnotMatchAlert.next_btn.click();
			Thread.sleep(2000);

			if (!businessLocation.contains("NSW")) {
				spnotMatchAlert.RadioWorkbtn.click();
				spnotMatchAlert.Submitbtn.click();
			}

			Thread.sleep(2000);
			spnotMatchAlert.ServiceProviderRadio_btn.click();
			spnotMatchAlert.ServiceProviderRadio_btn1.click();
			spnotMatchAlert.Autosrvcprov_radbtn.click();
			Thread.sleep(2000);
			spnotMatchAlert.nextbtn.click();
			Thread.sleep(2000);
			spnotMatchAlert.CGURadio_btn.click();
			spnotMatchAlert.TVRadio_btn.click();
			spnotMatchAlert.NoRadio_btn.click();
			spnotMatchAlert.Acctivation_nextbtn.click();
			Assert.assertEquals(
					"http://test.gethealthyatwork.com.au:7001/Account%20Activation/Business/AccountActivationConfirmation",
					driver.getCurrentUrl());
			spnotMatchAlert.FinalizeDetails_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.FinalizeDetails_btn1.click();
			Thread.sleep(2000);
			spnotMatchAlert.Proceed_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.OK_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.Logout_btn.click();
			spnotMatchAlert.AdminUsername.sendKeys(Adminusername);
			spnotMatchAlert.AdminPassword.sendKeys(AdminPass);
			spnotMatchAlert.AdminLogin_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.AdminSearchBox.sendKeys(Businessname);
			spnotMatchAlert.View_btn.click();
			String Allocation = spnotMatchAlert.AllocatioFailed_Text.getText();
			Assert.assertEquals("Please note that auto allocation failed for the following business.", Allocation);
			String AdminABN = spnotMatchAlert.AdminAbnnum.getText();
			Assert.assertEquals(ABNValue, AdminABN);
		} catch (Exception e) {
			Assert.assertEquals(true, false);
			Log.error("Exception Error in autoAllocationSPApproves Method" + e);
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
