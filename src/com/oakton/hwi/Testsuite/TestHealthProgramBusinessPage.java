package com.oakton.hwi.Testsuite;

/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used for creating Health Program for Business
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
* 01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used for creating Health Program for Business 
*                                                                                                                                                                                 
*
*/
import java.io.File;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FilenameUtils;
import com.oakton.hwi.Pages.HealthProgramBusinessPage;
import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.CaptureScreenshot;
import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;
import com.oakton.hwi.Utility.ReadTestData;

public class TestHealthProgramBusinessPage {
	WebDriver driver;
	HealthProgramBusinessPage healthprogram = new HealthProgramBusinessPage();
	ReadConfigFile rcf = new ReadConfigFile();
	ReadTestData rtd = new ReadTestData(rcf.getExcelPath());
	String passScreenshotpath = rcf.getPassScreenPath();
	String failScreenshotpath = rcf.getFailScreenPath();
	String path = rcf.getExcelPath();
	String screenshotpath = rcf.getScreenPath();
	BrowserFactory browser = new BrowserFactory();
	CaptureScreenshot capturescreen = new CaptureScreenshot();
	String sheetName = "HealthProgramBusiness";

	/*
	 * This method is to initialize the page element and the browser
	 */
	@BeforeMethod
	public void InvokeDriver() {
		driver = healthprogram.Setup();
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
	 * This Method is used to create Health Program
	 */
	@Test(dataProvider = "Data")
	public void createHealthProgramTest(String TestCase, String user, String password, String healthProgName,
			String uploadFile, String uploadFile2, String goalName, String goalDescription, String healthArea,
			String actionTitle1, String actionDesc1, String actionType1, String actionTitle2, String actionDesc2,
			String actionType2) throws Exception {

		try {
			Log.info("******** :::: Inside the createHealthProgramTest :::::*********");
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(50);
			System.out.println("=====Inside createHealthProgramTest method======");
			healthprogram.loginLinkClick.click();
			healthprogram.emailtxt.sendKeys(user);
			healthprogram.passwordtxt.sendKeys(password);
			healthprogram.loginButton.click();
			Assert.assertEquals(driver.getCurrentUrl(),
					"http://test.gethealthyatwork.com.au:7001/en/Business/Dashboard");
			// Health Program creation
			healthprogram.getStartedLink.click();
			Assert.assertEquals(driver.getTitle(), "GET STARTED");
			healthprogram.createHealthProgLink.click();
			healthprogram.createNewHealthProgLink.click();
			healthprogram.enterHealthNametxtbx.sendKeys(healthProgName + randomInt);
			Thread.sleep(3000);
			healthprogram.createHealthProgbtn.click();
			Thread.sleep(3000);

			// Checkpoint1
			healthprogram.uploadLinkChk1.click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), "UploadDeliverables");
			healthprogram.browserBtn.sendKeys(uploadFile);
			Thread.sleep(3000);
			healthprogram.uploadBtn.click();
			String verifyDocument = healthprogram.uploadeddocumentNameStep1.getText();
			File f = new File(uploadFile);
			String fileNameWithOutExt = FilenameUtils.removeExtension(f.getName());
			verifyDocument = FilenameUtils.removeExtension(verifyDocument);
			Assert.assertEquals(verifyDocument, fileNameWithOutExt);
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 4);
			healthprogram.step1MarkAsFinalLink.click();
			wait.until(ExpectedConditions.elementToBeClickable(healthprogram.completedStepchkbox));
			healthprogram.completedStepchkbox.click();
			Thread.sleep(3000);

			// Checkpoint2
			healthprogram.checkpoint2WorkplaceReview.click();
			Thread.sleep(3000);
			healthprogram.uploadLinkChk2.click();
			Thread.sleep(2000);
			Assert.assertEquals(healthprogram.headingUploadWorkReview.getText(), "Upload Workplace Review");
			healthprogram.browserBtn.sendKeys(uploadFile2);
			healthprogram.uploadBtn.click();
			String verifyDocumentStep2 = healthprogram.uploadeddocumentNamestep2.getText();
			File step2xcel = new File(uploadFile2);
			String fileNameWithOutExtStep2 = FilenameUtils.removeExtension(step2xcel.getName());
			verifyDocumentStep2 = FilenameUtils.removeExtension(verifyDocumentStep2);
			Thread.sleep(2000);
			Assert.assertEquals(verifyDocumentStep2, fileNameWithOutExtStep2);
			Thread.sleep(2000);
			healthprogram.step2MarkAsFinalLink.click();
			Thread.sleep(2000);
			healthprogram.chkboxcompletedStep2.click();
			Thread.sleep(2000);
			// Checkpoint3
			healthprogram.checkpoint3ActionPlan.click();
			Thread.sleep(2000);
			healthprogram.addGoalBtn.click();
			Thread.sleep(2000);
			healthprogram.goalNametxtbx.sendKeys(goalName);
			healthprogram.goalDescriptiontxtbx.sendKeys(goalDescription);
			Thread.sleep(2000);
			healthprogram.ddlHealthArea.sendKeys(healthArea);
			Thread.sleep(2000);
			healthprogram.saveGoalbtn.click();
			// Actions
			healthprogram.actionTitletxt.sendKeys(actionTitle1);
			healthprogram.actionDescriptiontxt.sendKeys(actionDesc1);
			healthprogram.actionTypetxt.sendKeys(actionType1);
			Thread.sleep(2000);
			healthprogram.addLink.click();
			Thread.sleep(2000);
			healthprogram.actionTitle2txt.sendKeys(actionTitle2);
			healthprogram.actionDescription2txt.sendKeys(actionDesc2);
			healthprogram.actionType2txt.sendKeys(actionType2);
			healthprogram.addLink.click();
			Thread.sleep(2000);
			healthprogram.uploadActionPlan.click();
			healthprogram.browserBtn.sendKeys(uploadFile2);
			healthprogram.uploadBtn.click();
			Thread.sleep(2000);
			healthprogram.step3markAsFinalLink.click();
			healthprogram.chkboxcompletedStep3.click();
			Thread.sleep(3000);
			String completedStep3 = healthprogram.step3CompletedLabel.getText();
			Assert.assertEquals(completedStep3, "Completed");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,450)");
			Thread.sleep(3000);
			Log.info("******** :::: End  the createHealthProgramTest :::::*********");
		} catch (Exception e) {

			capturescreen.getFailuerScreenShot(driver, failScreenshotpath, sheetName);
			Log.error("Exception Error in createHealthProgramTest Method" + e);
			Assert.fail("Exception Error in createHealthProgramTest Method" + e);
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
