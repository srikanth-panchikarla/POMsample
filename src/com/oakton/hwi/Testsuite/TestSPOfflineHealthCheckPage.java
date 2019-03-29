package com.oakton.hwi.Testsuite;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is to create offline Health Check for Business via Service Provider   
* @author Srikanth Panchikarla
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is to create offline Health Check for Business via Service   
*                                                                                                                                                                                
*
*/
import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;
import com.oakton.hwi.Pages.BusinessHealthCheckOnlinePage;
import com.oakton.hwi.Pages.SPOfflineHealthCheckPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestSPOfflineHealthCheckPage {

	WebDriver driver;
	SPOfflineHealthCheckPage offlineHealthCheck = new SPOfflineHealthCheckPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "SPOfflineHealthCheck";
	String windowHandle;
	WebDriverWait wait;
	String bookingID;

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = offlineHealthCheck.Setup();
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
	 * This method is to create offline Health Check for Business via Service
	 * Provider
	 * 
	 */
	@Test(dataProvider = "Data")
	public void spHealthOffline(String Testcase, String spUsernamer, String SpPassword, String quickSearch,
			String dates, String noOfPactitioners, String startTime, String endTime, String GmailUsername,
			String GmailPassword, String businessEmail, String businessPassword, String fullName1, String fullName2,
			String fullName3, String fullName4, String fullName5, String NumberOfHealthPerformed, String adminUsernamer,
			String adminPassword) throws InterruptedException, Exception {
		try {
			Log.info("******** :::: Inside the spHealthOffline :::::*********");
			offlineHealthCheck.loginLinkClick.click();
			offlineHealthCheck.emailtxt.sendKeys(spUsernamer);
			offlineHealthCheck.passwordtxt.sendKeys(SpPassword);
			offlineHealthCheck.loginButton.click();
			offlineHealthCheck.myBusinessLink.click();
			offlineHealthCheck.quickSearch.sendKeys(quickSearch);
			offlineHealthCheck.healthCheckManageLink.click();
			offlineHealthCheck.radiobtnWorkSiteName.click();
			offlineHealthCheck.serviceDatepicker.sendKeys(dates);
			offlineHealthCheck.noOfPractitioners.sendKeys(noOfPactitioners);
			offlineHealthCheck.startTime.sendKeys(startTime);
			offlineHealthCheck.endTime.sendKeys(endTime);
			offlineHealthCheck.saveAndSubmitButton.click();
			driver.get("https://accounts.google.com/signin");
			offlineHealthCheck.Gmail_UserName.sendKeys(GmailUsername);
			offlineHealthCheck.Gmail_NextClick.click();
			offlineHealthCheck.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_NextClick.click();
			Thread.sleep(2000);
			offlineHealthCheck.GmailLogo_Click.click();
			offlineHealthCheck.Gmail_Searchbar.sendKeys(businessEmail + " Health Check Booking Created");
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_SearchBtn.click();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(offlineHealthCheck.Gmail_ClickMail));
			offlineHealthCheck.Gmail_ClickMail.click();
			Thread.sleep(2000);
			driver.get("http://test.gethealthyatwork.com.au:7001/");
			offlineHealthCheck.logout.click();
			offlineHealthCheck.emailtxt.sendKeys(businessEmail);
			offlineHealthCheck.passwordtxt.sendKeys(businessPassword);
			offlineHealthCheck.loginButton.click();
			offlineHealthCheck.facetofaceHealthCheckLink2.click();
			offlineHealthCheck.ddlselectBooking.sendKeys(dates);
			offlineHealthCheck.viewBtn.click();
			offlineHealthCheck.enterFullNamerow1txt.sendKeys(fullName1);
			offlineHealthCheck.enterFullNamerow2txt.sendKeys(fullName2);
			offlineHealthCheck.enterFullNamerow3txt.sendKeys(fullName3);
			offlineHealthCheck.enterFullNamerow4txt.sendKeys(fullName4);
			offlineHealthCheck.enterFullNamerow5txt.sendKeys(fullName5);
			offlineHealthCheck.saveBtn.click();

			driver.get("https://accounts.google.com/signin");
			offlineHealthCheck.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_NextClick.click();
			Thread.sleep(2000);
			offlineHealthCheck.GmailLogo_Click.click();
			offlineHealthCheck.Gmail_Searchbar.sendKeys("Srikanth_SP Modified Booking Attendance Sheet");
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_SearchBtn.click();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(offlineHealthCheck.Gmail_ClickMail));
			offlineHealthCheck.Gmail_ClickMail.click();
			Thread.sleep(2000);
			if (offlineHealthCheck.gmailCollapsebtn.isDisplayed() == true) {
				offlineHealthCheck.gmailCollapsebtn.click();
			}
			Thread.sleep(8000);

			List<WebElement> elements = driver
					.findElements(By.cssSelector("body table div:nth-child(4) table tbody tr td p:nth-child(3)"));
			System.out.println("<<<<<<<<<<<Test1 number of elements: ???????????????????" + elements.size());

			for (WebElement ele : elements) {
				String getText = ele.getText();
				System.out.println("<<<<<<<<<<< Outside for loop" + getText);
				if (getText.length() > 0) // getText.contains("Booking Id:"))
				{
					System.out.println("<<<<<<<<<<<Test1 number of elements:In for Loop>>>> >>>" + getText);
					bookingID = ele.getText().replace("Booking Id:", "");
					break;

				}
			}

			driver.get("http://test.gethealthyatwork.com.au:7001/");
			offlineHealthCheck.logout.click();
			offlineHealthCheck.emailtxt.sendKeys(spUsernamer);
			offlineHealthCheck.passwordtxt.sendKeys(SpPassword);
			offlineHealthCheck.loginButton.click();
			Thread.sleep(2000);
			driver.get(
					"http://test.gethealthyatwork.com.au:7001/en/Service-Provider/Health-Program/Complete-Health-Check-Booking");
			Thread.sleep(2000);
			offlineHealthCheck.SpBookingIDtxt.sendKeys(bookingID);
			offlineHealthCheck.btnSearch.click();
			offlineHealthCheck.NumbofHealthPerformedtxt.sendKeys(NumberOfHealthPerformed);
			offlineHealthCheck.btnUpdate.click();
			Thread.sleep(1000);
			offlineHealthCheck.btnFinalise.click();
			Thread.sleep(1000);
			offlineHealthCheck.btnLodgeReq.click();
			Thread.sleep(2000);
			offlineHealthCheck.modalSuccessCloseBtn.click();
			Thread.sleep(2000);
			offlineHealthCheck.logout.click();
			offlineHealthCheck.emailtxt.sendKeys(adminUsernamer);
			offlineHealthCheck.passwordtxt.sendKeys(adminPassword);
			offlineHealthCheck.loginButton.click();
			Assert.assertEquals("http://test.gethealthyatwork.com.au:7001/HWI%20Admin/My%20Alerts.aspx",
					driver.getCurrentUrl());
			offlineHealthCheck.quickSearch.sendKeys(quickSearch);
			offlineHealthCheck.viewAttendance.click();
			Assert.assertEquals(offlineHealthCheck.titleAttendancePage.getText(), "Health Check Attendance Claim");
			offlineHealthCheck.approveBtn.click();
			Thread.sleep(2000);
			// offlineHealthCheck.dialogApprovedClose.click();
			Thread.sleep(2000);
			driver.get("https://accounts.google.com/signin");
			offlineHealthCheck.Gmail_password.sendKeys(GmailPassword);
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_NextClick.click();
			Thread.sleep(2000);
			offlineHealthCheck.GmailLogo_Click.click();
			offlineHealthCheck.Gmail_Searchbar.sendKeys("Srikanth_SP Your request has been accepted");
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_SearchBtn.click();
			Thread.sleep(2000);
			offlineHealthCheck.Gmail_ClickMail.click();
			if (offlineHealthCheck.gmailCollapsebtn.isDisplayed() == true) {
				offlineHealthCheck.gmailCollapsebtn.click();
			}
			Log.info("******** :::: End the spHealthOffline :::::*********");

		} catch (Exception e) {
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
