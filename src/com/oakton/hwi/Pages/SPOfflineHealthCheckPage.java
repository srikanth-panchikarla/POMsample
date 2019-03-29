package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class SPOfflineHealthCheckPage {
	WebDriver driver;
	BrowserFactory browser = new BrowserFactory();
	ReadConfigFile rcf = new ReadConfigFile();

	@BeforeMethod
	public WebDriver Setup() {

		System.out.println("=====InSide Setup method======");
		driver = browser.openBrowser(rcf.getBrowser());
		PageFactory.initElements(driver, this);
		return driver;
	}

	@FindBy(linkText = "Login")
	public WebElement loginLinkClick;
	@FindBy(id = "UserName")
	public WebElement emailtxt;
	@FindBy(id = "Password")
	public WebElement passwordtxt;
	@FindBy(xpath = ".//*[@id='loginForm']/div[3]/div/button")
	public WebElement loginButton;
	@FindBy(linkText = "My Businesses")
	public WebElement myBusinessLink;
	@FindBy(xpath = "//input[@id='search-table']")
	public WebElement quickSearch;
	@FindBy(xpath = "//*[@id='table-my-business']/tbody/tr/td[5]/a")
	public WebElement healthCheckManageLink;
	@FindBy(xpath = "//label/span")
	public WebElement radiobtnWorkSiteName;
	@FindBy(id = "bookingDate-0")
	public WebElement serviceDatepicker;
	@FindBy(xpath = ".//*[@id='bookingNPractitioners-0']")
	public WebElement noOfPractitioners;
	@FindBy(xpath = "//td[3]/select")
	public WebElement startTime;
	@FindBy(xpath = "//td[4]/select")
	public WebElement endTime;
	@FindBy(xpath = "//input[@value='Save and Submit Booking']")
	public WebElement saveAndSubmitButton;

	@FindBy(id = "identifierId")
	public WebElement Gmail_UserName;
	@FindBy(className = "CwaK9")
	public WebElement Gmail_NextClick;
	@FindBy(className = "WaidBe")
	public WebElement GmailLogo_Click;
	@FindBy(name = "password")
	public WebElement Gmail_password;

	@FindBy(name = "q")
	public WebElement Gmail_Searchbar;
	@FindBy(xpath = ".//*[@id='gbqfb']/span")
	public WebElement Gmail_SearchBtn;
	@FindBy(xpath = "//div[2]/span[2]")
	public WebElement Gmail_ClickMail;
	@FindBy(xpath = "//div[2]/a/strong")
	public WebElement logout;
	// business login
	@FindBy(xpath = ("//a[contains(@href, '#')])[3]"))
	public WebElement healthCheckTab;

	@FindBy(xpath = "//li[3]/div/ul/li/a")
	public WebElement facetofaceHealthCheckLink;
	@FindBy(linkText = "Manage face-to-face health checks")
	public WebElement facetofaceHealthCheckLink2;

	@FindBy(xpath = ".//*[@id='bookingFriendlyId']")
	public WebElement ddlselectBooking;
	@FindBy(xpath = "//div[2]/input")
	public WebElement viewBtn;
	@FindBy(xpath = "//td[2]/input")
	public WebElement enterFullNamerow1txt;
	@FindBy(xpath = "//tr[2]/td[2]/input")
	public WebElement enterFullNamerow2txt;
	@FindBy(xpath = "//tr[3]/td[2]/input")
	public WebElement enterFullNamerow3txt;
	@FindBy(xpath = "//tr[4]/td[2]/input")
	public WebElement enterFullNamerow4txt;
	@FindBy(xpath = "//tr[5]/td[2]/input")
	public WebElement enterFullNamerow5txt;
	@FindBy(xpath = "//input[9]")
	public WebElement saveBtn;
	@FindBy(xpath = "//img[@alt='Collapse all']")
	public WebElement gmailCollapsebtn;
	// SP Srikanth_SP gets email Modified Booking Attendance Sheet
	// @FindBy(xpath = "//p[3]") public WebElement BookIDCaptureInEmail;
	@FindBy(xpath = ".//div[1]/table/tbody/tr[2]/td/p")
	public WebElement BookIDCaptureInEmail;

	// Login as SP
	@FindBy(linkText = "Health Program")
	public WebElement SPHealthProgramLink;

	@FindBy(xpath = "//li[3]/div/ul/li/a")
	public WebElement finaliseHealthCheckbookingLink;
	@FindBy(id = "bookingFriendlyId")
	public WebElement SpBookingIDtxt;
	@FindBy(xpath = "//div[2]/input")
	public WebElement btnSearch;
	@FindBy(id = "NumberOfHealthChecksPerformed")
	public WebElement NumbofHealthPerformedtxt;

	@FindBy(xpath = ".//*[@id='complete-booking-form']/p/input[2]")
	public WebElement btnUpdate;
	@FindBy(xpath = ".//*[@id='complete-booking-form']/p/input[3]")
	public WebElement btnFinalise;
	@FindBy(xpath = ".//*[@id='complete-booking-form']/p/input[4]")
	public WebElement btnLodgeReq;
	@FindBy(xpath = ".//*[@id='modal-title']")
	public WebElement modalSuccess;
	@FindBy(xpath = ".//*[@id='modal-sp-reimbursement']/div/div/div[2]/input")
	public WebElement modalSuccessCloseBtn;

	// Admin login and Alert search for the Entity name
	@FindBy(xpath = "//input[7]")
	public WebElement viewAttendance;
	@FindBy(xpath = "//h2")
	public WebElement titleAttendancePage;

	@FindBy(xpath = ".//*[@id='approve-reimbursement']")
	public WebElement approveBtn;
	@FindBy(xpath = "//*[@id='cb_btn_close']")
	public WebElement dialogApprovedClose;
	@FindBy(xpath = ".//*[@id='decline-reimbursement']")
	public WebElement declineBtn;

}
