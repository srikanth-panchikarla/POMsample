package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class ActivateBusinessPage {

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

	@FindBy(name = "q")
	public WebElement Gmail_Searchbar;
	@FindBy(xpath = ".//*[@id='gbqfb']/span")
	public WebElement Gmail_SearchBtn;
	@FindBy(xpath = "//div[2]/span[2]")
	public WebElement Gmail_ClickMail;
	@FindBy(linkText = "Activate your account")
	public WebElement Gmail_ClickActivationLink;
	@FindBy(xpath = "//h1/span")
	public WebElement Gmail_mailTitle;
	@FindBy(id = "newpassword")
	public WebElement newPasswordtxt;
	@FindBy(id = "new-confirm-password")
	public WebElement newConfirmPasswordtxt;
	@FindBy(id = "reset-password")
	public WebElement resetPasswordBtn;
	@FindBy(xpath = "//td/a")
	public WebElement validationLink;

	@FindBy(id = "identifierId")
	public WebElement Gmail_UserName;
	@FindBy(className = "CwaK9")
	public WebElement Gmail_NextClick;
	@FindBy(xpath = "//div[@id='password']/div/div/div/input")
	public WebElement Gmail_password;
	@FindBy(xpath = "//div[2]/div/div/div[2]/div/content/span")
	public WebElement GmailPwdNext_Click;
	@FindBy(className = "WaidBe")
	public WebElement GmailLogo_Click;

	// Registration vAlidation data
	@FindBy(id = "User_Password")
	public WebElement newpwd;
	@FindBy(id = "User_ConfirmPassword")
	public WebElement Conf_newpwd;
	@FindBy(id = "btnSelectPasswordSubmit")
	public WebElement next_btn;
	@FindBy(name = "worksite")
	public WebElement RadioWorkbtn;
	@FindBy(id = "btnSelectHeadOfficeSubmit")
	public WebElement Submitbtn;
	@FindBy(xpath = "//label/span")
	public WebElement DoityourselfRadio_btn;
	@FindBy(xpath = "//div[2]/div/label/span")
	public WebElement DoitYourselfRadio_btn1;

	// WebElement ServiceProviderRadio_btn;
	@FindBy(xpath = "//div[2]/label/span")
	public WebElement ServiceProviderRadio_btn;

	@FindBy(xpath = "//div[2]/div[2]/label/span")
	public WebElement ServiceProviderRadio_btn1;
	@FindBy(xpath = "//div[2]/div/div/div[3]/div[2]/div/label/span")
	public WebElement ServprovRadio_btn;
	@FindBy(xpath = "//*[@id='serviceProviderInfo']/div[2]/div/label[3]/span")
	public WebElement preferredServprovRadio_btn;
	@FindBy(xpath = "//*[@id='ServiceProviderFriendlyId']")
	public WebElement preferredServprovtxt;
	@FindBy(id = "btnSaveHealthBundle")
	public WebElement nextbtn;
	@FindBy(id = "CGU")
	public WebElement CGURadio_btn;
	@FindBy(id = "TV")
	public WebElement TVRadio_btn;
	@FindBy(id = "selectlan2")
	public WebElement NoRadio_btn;
	@FindBy(id = "accActivation5")
	public WebElement Acctivation_nextbtn;
	@FindBy(xpath = "/html/body/section/div[2]/div/div/div[2]/div[1]/a")
	public WebElement takeMeToYourAccountBtn;

	// Create
	@FindBy(id = "abntxt")
	public WebElement Reg_TextABNName;
	@FindBy(id = "firstnametxt")
	public WebElement Reg_TextFirstName1;
	@FindBy(id = "emailaddresstxt")
	public WebElement Reg_TextEmail;
	@FindBy(xpath = "//*[@id='businessRegForm']/fieldset/p[4]/button")
	public WebElement Reg_ButtonClick1;

	@FindBy(xpath = "//*[@id='b5']")
	public WebElement Reg_RadioButton;
	@FindBy(xpath = "//tr[6]/td[2]")
	public WebElement businessEntityNameCaputure;
	@FindBy(xpath = "//tr[6]/td[8]")
	public WebElement businessEntityLocationCaputure;

	@FindBy(id = "btnSelectBusiness")
	public WebElement Reg_ButtonNext;
	@FindBy(id = "RegisterUser_FirstName")
	public WebElement Reg_TextFirstName2;
	@FindBy(id = "RegisterUser_LastName")
	public WebElement Reg_TextLastName;
	@FindBy(id = "RegisterUser_PhoneNumber")
	public WebElement Reg_TextPhone;
	@FindBy(id = "RegisterUser_MobileNumber")
	public WebElement Reg_TextMobile1;
	@FindBy(id = "confirmAuthorisedRepresentative")
	public WebElement Reg_confirmChkbtn;
	@FindBy(id = "RegisterUser_NumberOfEmployees")
	public WebElement Reg_TextEmp;
	@FindBy(id = "RegisterUser_NumberOfWorksites")
	public WebElement Reg_TextSites;
	@FindBy(id = "businessRegostep3")
	public WebElement Reg_SubmitRegbtn;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement Reg_ButtonClick5;
	@FindBy(name = "Worksites[0].TradingName")
	public WebElement Reg_TextWork;
	@FindBy(id = "Worksites_0_AddressLine")
	public WebElement Reg_TextAddrs;
	@FindBy(id = "Worksites_0_NumberOfWorkers")
	public WebElement Reg_TextNumb;
	@FindBy(xpath = "//*[@id='step2confirmationModal']/div[3]")
	public WebElement dialogConfirm_click;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement yesConfirmbtn_click;
	@FindBy(xpath = "//td/table/tbody/tr/td[2]")
	public WebElement mailBusinessNameLabel;
	@FindBy(linkText = "Login")
	public WebElement loginLinkClick;
	@FindBy(id = "UserName")
	public WebElement emailtxt;
	@FindBy(id = "Password")
	public WebElement passwordtxt;
	@FindBy(xpath = ".//*[@id='loginForm']/div[3]/div/button")
	public WebElement loginButton;
	@FindBy(linkText = "Service Requests")
	public WebElement serviceRequestLink;
	@FindBy(xpath = "//*[@id='table-service-requests']/tbody/tr[1]/td[5]/a")
	public WebElement serviceViewDetails;
	@FindBy(xpath = "//em/a")
	public WebElement businessEmailCapture;
	@FindBy(xpath = "//div[2]/div[2]/span")
	public WebElement entityNameCapture;

	@FindBy(xpath = "//a[contains(text(),'Accept')]")
	public WebElement acceptButton;
	@FindBy(xpath = " //a[contains(text(),'Reject')]")
	public WebElement rejectButton;
	@FindBy(xpath = " //div[@id='modal-rejected']/div/div/div")
	public WebElement modalReject;
	@FindBy(xpath = ".//*[@id='reject-reason']")
	public WebElement modalRejectReason;
	@FindBy(xpath = " //div[@id='modal-accepted']/div/div/div[2]")
	public WebElement modalProceed;
	@FindBy(xpath = " .//*[@id='modal-accepted']/div/div/div[2]/a[2]")
	public WebElement proceedButton;
	@FindBy(xpath = "//*[@id='modal-success']/div/div/div[1]")
	public WebElement modalSuccess;
	@FindBy(xpath = ".//*[@id='modal-rejected']/div/div/div[2]/a[1]")
	public WebElement modalRejectProceedButton;
	@FindBy(xpath = ".//*[@id='modal-proceed-rejected']/div/div/div[1]")
	public WebElement modalRejectcloseButton;

	@FindBy(xpath = "//*[@id='modal-success']/div/div/div[1]/button")
	public WebElement closModaldialoSuccessUserAdded;
	@FindBy(linkText = "My Businesses")
	public WebElement myBusinessLink;
	@FindBy(xpath = "//input[@id='search-table']")
	public WebElement quickSearch;
	@FindBy(xpath = "//table[@id='table-my-business']/tbody/tr/td[2]/em/a")
	public WebElement emailInMyBusiness;
	@FindBy(xpath = "//div[2]/a/strong")
	public WebElement logout;

	@FindBy(xpath = "/html/body/section/div[2]/div/div/div[2]/div[2]/aside/div/ul/li[2]")
	public WebElement entityNameAccountActconfirmPage;
	@FindBy(xpath = ".//*[@id='table-notifications']/tbody/tr/td[3]")
	public WebElement myAlertDescription;

	@FindBy(xpath = "//div[2]/div/a")
	public WebElement FinalizeDetails_btn;
	@FindBy(id = "finalisedworksites")
	public WebElement FinalizeDetails_btn1;
	@FindBy(id = "proceedtofinaliseworksites")
	public WebElement Proceed_btn;

}
