package com.oakton.hwi.Testsuite;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used for creating business and Auto allocation of Service Provider
* SP logins and Approves the Business
* We are connecting to HWI DB to retrieve SP Friendly ID
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
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used for creating business 
*                                                                                                                        and Auto allocation of Service Provider                                                         
*
*/

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class TestAutoAllocationSPApproves {
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
	String sheetName = "AutoAllocationSPApproves";
	String retrieveServiceProviderFullName;
	String email;
	String businessLocation;
	String BusinessID;
	String SPFriendlyID;
	WebDriverWait wait;
	String spEmailId;
	String entityName;

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = spnotMatchAlert.Setup();
	}

	/*
	 * This method is to retrieve HWI test data from excel sheet
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
	 * This Method is used for create business and Auto allocating of Service
	 * Provider SP logins and Approves the Business. We are connecting to HWI DB
	 * to retrieve SP Friendly ID
	 */
	@Test(dataProvider = "Data")
	public void autoAllocationSPApproves(String Testcase, String AbnName, String FirstName, String MailId,
			String LastName, String LandlineNumber, String MobileNumber, String NoofWorkers, String NoofWorkSites,
			String TextWork, String TextAddress, String Textnumb, String GmailUsername, String GmailPassword,
			String newPassword, String ConfirmPassword, String Adminusername, String AdminPass) throws Exception {
		try {
			Log.info("******** :::: Inside the autoAllocationSPApproves :::::*********");
			wait = new WebDriverWait(driver, 10);
			spnotMatchAlert.Reg_TextABNName.sendKeys(AbnName);
			spnotMatchAlert.Reg_TextFirstName1.sendKeys(FirstName);
			String bFirstName = spnotMatchAlert.Reg_TextFirstName1.getAttribute("value");
			spnotMatchAlert.Reg_TextEmail.sendKeys(MailId + "@gmail.com");
			String businessMailID = spnotMatchAlert.Reg_TextEmail.getAttribute("value");
			spnotMatchAlert.Reg_ButtonClick1.click();
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
			Thread.sleep(3000);

			if (!businessLocation.contains("NSW")) {
				spnotMatchAlert.RadioWorkbtn.click();
				spnotMatchAlert.Submitbtn.click();
			}

			Thread.sleep(2000);
			spnotMatchAlert.ServiceProviderRadio_btn.click();
			spnotMatchAlert.ServiceProviderRadio_btn1.click();
			spnotMatchAlert.Autosrvcprov_radbtn.click();
			Thread.sleep(3000);
			spnotMatchAlert.nextbtn.click();
			Thread.sleep(3000);
			spnotMatchAlert.CGURadio_btn.click();
			spnotMatchAlert.TVRadio_btn.click();
			spnotMatchAlert.NoRadio_btn.click();
			spnotMatchAlert.Acctivation_nextbtn.click();
			Assert.assertEquals(
					"http://test.gethealthyatwork.com.au:7001/Account%20Activation/Business/AccountActivationConfirmation",
					driver.getCurrentUrl());
			String businessEntityName = spnotMatchAlert.entityNameAccountActconfirmPage.getText();
			String businessEntityNameSplit = businessEntityName.replace("ENTITY NAME", "");
			System.out.println("Entity Name" + businessEntityNameSplit);
			spnotMatchAlert.FinalizeDetails_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.FinalizeDetails_btn1.click();
			Thread.sleep(5000);
			spnotMatchAlert.Proceed_btn.click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.elementToBeClickable(spnotMatchAlert.OK_btn));
			spnotMatchAlert.OK_btn.click();
			Thread.sleep(2000);
			driver.get("http://test.gethealthyatwork.com.au:7001/en/Business/Dashboard");
			BusinessID = spnotMatchAlert.bussinessID.getText();
			Thread.sleep(2000);
			//calling getSPID method which retrieves SPID from DB
			getSPId(BusinessID);
			Thread.sleep(2000);
			spnotMatchAlert.Logout_btn.click();
			Thread.sleep(2000);
			spnotMatchAlert.AdminUsername.sendKeys(Adminusername);
			spnotMatchAlert.AdminPassword.sendKeys(AdminPass);
			spnotMatchAlert.AdminLogin_btn.click();
			Thread.sleep(2000);
			driver.get("http://test.gethealthyatwork.com.au:7001/en/HWI-Admin/Service-Providers");
			wait.until(ExpectedConditions.elementToBeClickable(spnotMatchAlert.AdminSearchBox));
			spnotMatchAlert.AdminSearchBox.sendKeys(SPFriendlyID);
			Thread.sleep(3000);
			String spEmailId = spnotMatchAlert.spEmailIdInAdmin.getText();
			Thread.sleep(3000);
			Thread.sleep(3000);
			driver.get("http://test.gethealthyatwork.com.au:7001/General%20Pages/Account/Logout");
			Thread.sleep(3000);
			spnotMatchAlert.AdminUsername.sendKeys(spEmailId);
			Thread.sleep(1000);
			spnotMatchAlert.AdminPassword.sendKeys(AdminPass);
			Thread.sleep(2000);
			spnotMatchAlert.AdminLogin_btn.click();
			driver.get("http://test.gethealthyatwork.com.au:7001/en/Service-Provider/Summary/Service-Requests");
			Thread.sleep(2000);
			spnotMatchAlert.AdminSearchBox.sendKeys(businessEntityNameSplit);
			Thread.sleep(1000);
			spnotMatchAlert.serviceViewDetails.click();
			Thread.sleep(2000);
			spnotMatchAlert.acceptButton.click();
			Thread.sleep(2000);

			if (spnotMatchAlert.modalProceed.isDisplayed() == true) {
				Thread.sleep(2000);
				spnotMatchAlert.proceedButton.click();
			}
			Thread.sleep(2000);
			spnotMatchAlert.closModaldialoSuccessUserAdded.click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(),
					"http://test.gethealthyatwork.com.au:7001/en/Service-Provider/Summary/Service-Requests.aspx");
			spnotMatchAlert.myBusinessLink.click();
			Thread.sleep(2000);
			spnotMatchAlert.quickSearch.sendKeys(businessMailID);
			Thread.sleep(2000);
			Assert.assertEquals(spnotMatchAlert.emailInMyBusiness.getText(), businessMailID);
			Log.info("******** :::: End  the autoAllocationSPApproves :::::*********");
		} catch (Exception e) {

			Log.error("Exception Error in autoAllocationSPApproves Method" + e);
			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			Assert.fail("Exception Error in autoAllocationSPApproves Method:::: "+e);
		}
	}

	/*
	 * @ Method Description This method will retrieve SPID from the DB
	 */
	public void getSPId(String BusinessID) throws SQLException, ClassNotFoundException {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.208.82.12;databasename=HWIS.Custom;",
					"RR", "P@ssword12");
			Statement st = conn.createStatement();
			String Sql = "select DISTINCT sp.FriendlyId from ServiceRequest sr join  Business b on b.BusinessId=sr.RequestBusinessId "
					+ "join  ServiceProvider sp on sp.ServiceProviderId =sr.RequestServiceProviderId "
					+ "where b.FriendlyId=" + "'" + BusinessID + "'"
					+ " and sr.ServiceRequestStatusId='DCB7781A-F524-41A1-A72B-DDE7084EB33D'";

			ResultSet rs = st.executeQuery(Sql);
			while (rs.next()) {

				SPFriendlyID = rs.getString("FriendlyId");
				break;
			}
		} catch (SQLException e) {
			Log.error("SQLException Error in GetSPID Method" + e);

		} catch (ClassNotFoundException e) {
			Log.error("ClassNotFoundException Error in GetSPID Method" + e);
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
