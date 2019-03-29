package com.oakton.hwi.Testsuite;

import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.oakton.hwi.Pages.CreateServicePage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestCreateServicePage {

	WebDriver driver;

	CreateServicePage login = new CreateServicePage(driver);
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "CreateServiceProvider";
	String retrieveServiceProviderFullName;
	String email;

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = login.Setup();
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
	 * This Method is used for create Service Provider
	 */
	@Test(dataProvider = "Data")

	public void CreateServiceProviderTest(String TestCase, String user, String password, String serviceProviderName,
			String serviceProviderAddress1, String ServiceProviderAddress2, String ServiceProviderSuburb,
			String ServiceProviderState, String ServiceProviderPostCode, String ServiceProviderAdminFullName,
			String ServiceProviderAdminUserName, String ServiceProviderContractName, String ContractStartDate,
			String ContractEndDate, String ServiceArea, String SmallKPI, String MediumKPIKPI, String LargeKPI,
			String Incentiveclaim, String Preapproval, String GmailURL, String Gusername, String Gpassword,
			String Newpassword, String Confirmpassword) throws Exception {
		try {
			Log.info("******** :::: Inside the CreateServiceProviderTest :::::*********");
			WebDriverWait wait = new WebDriverWait(driver, 100);
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			System.out.println("In FillData method");
			// driver.findElement(By.linkText("Login")).click();
			login.loginLinkClick.click();
			login.emailtxt.sendKeys(user);
			login.passwordtxt.sendKeys(password);
			login.loginButton.click();
			System.out.println("FillData");
			// Thread.sleep(2000);
			/* Create service provider */
			login.serviceProviderLink.click();
			wait.until(ExpectedConditions.elementToBeClickable(login.addServiceProviderLink));
			login.addServiceProviderLink.click();
			// Thread.sleep(2000);
			// Create Account Details:
			login.serviceProviderNametxt.sendKeys(serviceProviderName + randomInt);
			login.serviceProviderAddrs1txt.sendKeys(serviceProviderAddress1);
			login.serviceProviderAddrs2txt.sendKeys(ServiceProviderAddress2);
			login.serviceProviderSuburbtxt.sendKeys(ServiceProviderSuburb);
			login.serviceProviderStatetxt.sendKeys(ServiceProviderState);
			login.serviceProviderPostcodetxt.sendKeys(ServiceProviderPostCode);
			login.serviceProviderAdminFullNametxt.sendKeys(ServiceProviderAdminFullName + randomInt);
			retrieveServiceProviderFullName = login.serviceProviderAdminFullNametxt.getAttribute("value");
			login.serviceProviderAdminUserNametxt.sendKeys(ServiceProviderAdminUserName + randomInt + "@gmail.com");
			String email = login.serviceProviderAdminUserNametxt.getAttribute("value");
			Thread.sleep(2000);
			login.ClickNexStepButton.click();
			// /*Add Contract*/
			login.contractNametxt.sendKeys(ServiceProviderContractName + randomInt);
			login.contractStartDatetxt.sendKeys(ContractStartDate);
			login.contractEndDatetxt.sendKeys(ContractEndDate);
			login.selectServiceareaddl.sendKeys(ServiceArea);
			login.selectRegion1.click();
			login.ClickaddKPI.click();
			login.smallKPItxt.sendKeys(SmallKPI.toString());
			login.mediumKPItxt.sendKeys(MediumKPIKPI.toString());
			login.largeKPItxt.sendKeys(LargeKPI.toString());
			login.clickSaveAndContiBtn.click();
			login.selectAutoAllocate.click();
			Thread.sleep(3000);
			boolean ModalDialog = login.dialogboxServiceUpdated.isDisplayed();
			if (ModalDialog == true) {
				login.closeDialogboxServiceUpdated.click();
			}
			Thread.sleep(3000);
			login.IncentiveClaimChcbox.sendKeys(Incentiveclaim);
			login.PreApprovalChcbox.sendKeys(Preapproval);
			Thread.sleep(3000);
			if (ModalDialog == true) {
				login.closeDialogboxServiceUpdated.click();
			}
			Thread.sleep(3000);

			login.completeAccountSetupBtn.click();
			boolean msgServiceProviderCreated = login.dialogboxSuccessCreated.isDisplayed();
			if (msgServiceProviderCreated == true) {
				login.closeDialogboxSuccessCreated.click();
			}
			Assert.assertEquals("Save Contract", driver.getTitle());
			activationMail(GmailURL, Gusername, Gpassword, Newpassword, Confirmpassword);
			login.emailtxt.sendKeys(email);
			login.passwordtxt.sendKeys(Newpassword);
			login.loginButton.click();
			Assert.assertEquals("Service Requests", driver.getTitle());
			Log.info("******** :::: End the CreateServiceProviderTest :::::*********");
		} catch (Exception e) {
			Log.error("Exception Error in autoAllocationSPApproves Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			Assert.fail("Exception Error in activationMail Method" + e);
		}
	}

	/*
	 * This method to check Service Activation mail is received and activating
	 * the SP
	 */
	public void activationMail(String Gurl, String gusername, String gpassword, String Newpassword,
			String Confirmpassword) throws Exception {
		try {
			Log.info("******** :::: Inside  the activationMail :::::*********");
			WebDriverWait waiting = new WebDriverWait(driver, 150);
			driver.get(Gurl);
			login.Gmail_UserName.sendKeys(gusername);
			login.Gmail_NextClick.click();
			login.Gmail_password.sendKeys(gpassword);
			Thread.sleep(2000);
			login.Gmail_NextClick.click();
			waiting.until(ExpectedConditions.visibilityOf(login.Gmail_Searchbar));
			login.Gmail_Searchbar.sendKeys(retrieveServiceProviderFullName);
			login.Gmail_SearchBtn.click();
			// waiting.until(ExpectedConditions.elementToBeClickable(login.Gmail_ClickMail));
			login.Gmail_ClickMail.click();
			String mailTitle = login.Gmail_mailTitle.getText().toUpperCase().replace("TO:", "").replace("\"", "");
			// String [] splitter=mailTitle.split("\"");
			Assert.assertEquals(mailTitle, retrieveServiceProviderFullName.toUpperCase());
			login.Gmail_ClickActivationLink.click();
			// String windowHandle = driver.getWindowHandle();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			login.newPasswordtxt.sendKeys(Newpassword);
			login.newConfirmPasswordtxt.sendKeys(Confirmpassword);
			login.resetPasswordBtn.click();
			Log.info("******** :::: End  the activationMail :::::*********");
		}

		catch (Exception e)

		{
			Log.error("Exception Error in activationMail Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			Assert.fail("Exception Error in activationMail Method" + e);
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
