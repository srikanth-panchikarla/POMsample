package com.oakton.hwi.Testsuite;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used for create business,Manually allocates the Service Provider.Service Provider accepts the Business allocated to it 
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
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used for create business,Manually allocates the Service Provider.
*                                                                                                                        Service Provider accepts the Business allocated to it                                                      
*
*/
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
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
import com.oakton.hwi.Pages.ActivateBusinessPage;
import com.oakton.hwi.Pages.CreateServicePage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestBusinessSPManualAllocationApprove {

	WebDriver driver;

	ActivateBusinessPage activatebusinesspage = new ActivateBusinessPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "BusinessSPManualApprove";
	String retrieveServiceProviderFullName;
	String email;
	String businessName;
	String businessEmailInService;
	String entityName;
	String businessLocation;

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = activatebusinesspage.Setup();
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
	 * This Method is used for create business and Auto allocating of Service Provider
	 *  SP logins and Approves the Business. 
	 */
	@Test(dataProvider = "Data")
	public void registerBusinessSPApprove(String Testcase, String AbnName, String FirstName, String MailId,
			String LastName, String LandlineNumber, String MobileNumber, String NoofWorkers, String NoofWorkSites,
			String TextWork, String TextAddress, String Textnumb, String GmailUsername, String GmailPassword,
			String newPassword, String ConfirmPassword, String ServProvText, String SPusername, String SPpassword)
			throws Exception {

		try {
			Log.info("******** :::: Inside the registerBusinessSPApprove :::::*********");
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);

			activatebusinesspage.Reg_TextABNName.sendKeys(AbnName);
			activatebusinesspage.Reg_TextFirstName1.sendKeys(FirstName + randomInt);
			String bFirstName = activatebusinesspage.Reg_TextFirstName1.getAttribute("value");
			activatebusinesspage.Reg_TextEmail.sendKeys(MailId + randomInt + "@gmail.com");
			String businessMailID = activatebusinesspage.Reg_TextEmail.getAttribute("value");
			activatebusinesspage.Reg_ButtonClick1.click();
			Thread.sleep(5000);
			assertEquals("http://test.gethealthyatwork.com.au:7001/BusinessRegistration/RegisterStep2",
					driver.getCurrentUrl());
			activatebusinesspage.Reg_RadioButton.click();
			businessLocation = activatebusinesspage.businessEntityLocationCaputure.getText().replaceAll(".*,", "");
			Thread.sleep(4000);
			activatebusinesspage.Reg_ButtonNext.click();
			activatebusinesspage.Reg_TextLastName.sendKeys(LastName);
			activatebusinesspage.Reg_TextPhone.sendKeys(LandlineNumber);
			activatebusinesspage.Reg_TextMobile1.sendKeys(MobileNumber);
			activatebusinesspage.Reg_confirmChkbtn.click();
			Thread.sleep(3000);
			activatebusinesspage.Reg_TextEmp.sendKeys(NoofWorkers);
			activatebusinesspage.Reg_TextSites.sendKeys(NoofWorkSites);
			Thread.sleep(2000);
			activatebusinesspage.Reg_TextWork.sendKeys(TextWork);
			activatebusinesspage.Reg_TextAddrs.sendKeys(TextAddress);
			Thread.sleep(2000);
			activatebusinesspage.Reg_TextAddrs.sendKeys(Keys.ARROW_DOWN);
			activatebusinesspage.Reg_TextAddrs.sendKeys(Keys.ENTER);
			activatebusinesspage.Reg_TextAddrs.sendKeys(Keys.ENTER);
			activatebusinesspage.Reg_TextNumb.sendKeys(Textnumb);
			activatebusinesspage.Reg_SubmitRegbtn.click();
			Thread.sleep(2000);

			Boolean confirmDialog = activatebusinesspage.dialogConfirm_click.isDisplayed();
			if (confirmDialog == true) {
				activatebusinesspage.yesConfirmbtn_click.click();
			}

			driver.get("https://accounts.google.com/signin");
			activatebusinesspage.Gmail_UserName.sendKeys(GmailUsername);
			activatebusinesspage.Gmail_NextClick.click();
			activatebusinesspage.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			activatebusinesspage.Gmail_NextClick.click();
			Thread.sleep(2000);
			activatebusinesspage.GmailLogo_Click.click();
			activatebusinesspage.Gmail_Searchbar.sendKeys(bFirstName);
			Thread.sleep(2000);
			activatebusinesspage.Gmail_SearchBtn.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(activatebusinesspage.Gmail_ClickMail));
			activatebusinesspage.Gmail_ClickMail.click();
			activatebusinesspage.Gmail_ClickActivationLink.click();
			Thread.sleep(2000);
			//String windowHandle = driver.getWindowHandle();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			activatebusinesspage.newpwd.sendKeys(newPassword);
			activatebusinesspage.Conf_newpwd.sendKeys(ConfirmPassword);
			activatebusinesspage.next_btn.click();
			Thread.sleep(2000);

			if (!businessLocation.contains("NSW")) {
				activatebusinesspage.RadioWorkbtn.click();
				activatebusinesspage.Submitbtn.click();
			}

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(activatebusinesspage.ServiceProviderRadio_btn));
			activatebusinesspage.ServiceProviderRadio_btn.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(activatebusinesspage.ServiceProviderRadio_btn1));
			Thread.sleep(3000);
			activatebusinesspage.ServiceProviderRadio_btn1.click();
			Thread.sleep(3000);
			activatebusinesspage.preferredServprovRadio_btn.click();
			Thread.sleep(3000);
			activatebusinesspage.preferredServprovtxt.sendKeys(ServProvText);
			Thread.sleep(3000);
			activatebusinesspage.nextbtn.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(activatebusinesspage.CGURadio_btn));
			activatebusinesspage.CGURadio_btn.click();
			activatebusinesspage.TVRadio_btn.click();
			activatebusinesspage.NoRadio_btn.click();
			activatebusinesspage.Acctivation_nextbtn.click();
			Assert.assertEquals(
					"http://test.gethealthyatwork.com.au:7001/Account%20Activation/Business/AccountActivationConfirmation",
					driver.getCurrentUrl());

			String businessEntityName = activatebusinesspage.entityNameAccountActconfirmPage.getText();
			String businessEntityNameSplit = businessEntityName.replace("ENTITY NAME", "");
			System.out.println("Entity Name" + businessEntityNameSplit);
			// Service Provider

			driver.get("https://accounts.google.com/signin");
			activatebusinesspage.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			activatebusinesspage.Gmail_NextClick.click();
			Thread.sleep(2000);
			activatebusinesspage.GmailLogo_Click.click();
			activatebusinesspage.Gmail_Searchbar.sendKeys("New work allocation request " + bFirstName);
			Thread.sleep(2000);
			activatebusinesspage.Gmail_SearchBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(activatebusinesspage.Gmail_ClickMail));
			activatebusinesspage.Gmail_ClickMail.click();
			Thread.sleep(2000);
			// businessName=activatebusinesspage.mailBusinessNameLabel.getText();
			driver.get("http://test.gethealthyatwork.com.au:7001/");
			activatebusinesspage.logout.click();
			activatebusinesspage.emailtxt.sendKeys(SPusername);
			activatebusinesspage.passwordtxt.sendKeys(SPpassword);
			activatebusinesspage.loginButton.click();
			Thread.sleep(2000);
			activatebusinesspage.serviceRequestLink.click();
			Thread.sleep(3000);
			activatebusinesspage.quickSearch.sendKeys(businessEntityNameSplit);
			Thread.sleep(3000);
			activatebusinesspage.serviceViewDetails.click();
			Thread.sleep(3000);
			businessEmailInService = activatebusinesspage.businessEmailCapture.getText();
			entityName = activatebusinesspage.entityNameCapture.getText().trim();
			// Assert.assertEquals(entityName, businessEntityNameSplit);
			Thread.sleep(2000);
			activatebusinesspage.acceptButton.click();
			Thread.sleep(2000);
			if (activatebusinesspage.modalProceed.isDisplayed() == true) {
				Thread.sleep(2000);
				activatebusinesspage.proceedButton.click();
			}
			Thread.sleep(2000);
			if (activatebusinesspage.modalSuccess.isDisplayed() == true) {
				activatebusinesspage.closModaldialoSuccessUserAdded.click();
			}
			Thread.sleep(2000);
			activatebusinesspage.myBusinessLink.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-table']")));
			Thread.sleep(2000);
			activatebusinesspage.quickSearch.sendKeys(businessMailID);
			Thread.sleep(3000);
			Assert.assertEquals(activatebusinesspage.emailInMyBusiness.getText(), businessMailID);
			Log.info("******** :::: End the registerBusinessSPApprove :::::*********");
		} catch (Exception ex)

		{
			Assert.assertEquals(GmailUsername, GmailPassword);
		    Log.error("Error message from Exception is :" + ex.getMessage());
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
		}

	}

	/*
	 * This method will save the Passed or Failed
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
