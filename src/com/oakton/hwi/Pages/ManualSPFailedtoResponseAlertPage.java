package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class ManualSPFailedtoResponseAlertPage {

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

	@FindBy(id = "abntxt")
	public WebElement Reg_TextABNName;
	@FindBy(id = "firstnametxt")
	public WebElement Reg_TextFirstName1;
	@FindBy(id = "emailaddresstxt")
	public WebElement Reg_TextEmail;
	@FindBy(xpath = "//p[4]/button")
	public WebElement Reg_ButtonClick1;
	@FindBy(xpath = "//tr[2]/td[2]")
	public WebElement RegBussiness_text;
	@FindBy(id = "b1")
	public WebElement Reg_RadioButton;
	@FindBy(id = "btnSelectBusiness")
	public WebElement Reg_Buttonclick2;
	@FindBy(id = "RegisterUser_FirstName")
	public WebElement Reg_TextFirstName2;
	@FindBy(id = "RegisterUser_LastName")
	public WebElement Reg_TextLastName;
	@FindBy(id = "RegisterUser_PhoneNumber")
	public WebElement Reg_TextPhone;
	@FindBy(id = "RegisterUser_MobileNumber")
	public WebElement Reg_TextMobile1;
	@FindBy(id = "confirmAuthorisedRepresentative")
	public WebElement Reg_ButtonClick3;
	@FindBy(id = "RegisterUser_NumberOfEmployees")
	public WebElement Reg_TextEmp;
	@FindBy(id = "RegisterUser_NumberOfWorksites")
	public WebElement Reg_TextSites;
	@FindBy(id = "businessRegostep3")
	public WebElement Reg_ButtonClick4;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement Reg_ButtonClick5;
	@FindBy(name = "Worksites[0].TradingName")
	public WebElement Reg_TextWork;
	@FindBy(id = "Worksites_0_AddressLine")
	public WebElement Reg_TextAddrs;
	@FindBy(id = "Worksites_0_NumberOfWorkers")
	public WebElement Reg_TextNumb;
	@FindBy(id = "businessRegostep3")
	public WebElement Reg_SubmitRegbtn;
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
	@FindBy(xpath = "//*[@id='step2confirmationModal']/div[3]")
	public WebElement dialogConfirm_click;
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
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement yesConfirmbtn_click;

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
	@FindBy(xpath = "//div[3]/div/div[2]/label")
	public WebElement ServiceProviderRadio_btn;
	@FindBy(xpath = "//div[3]/div[2]/div[2]/label")
	public WebElement ServiceProviderRadio_btn1;
	@FindBy(xpath = "//div[2]/div/div/div[3]/div[2]/div/label/span")
	public WebElement ServprovRadio_btn;
	@FindBy(xpath = "//label[3]")
	public WebElement ManualAllocationRadio_btn;
	@FindBy(xpath = "//div[@id='serviceProviderInfo']/div[2]/div/label/span")
	public WebElement Autosrvcprov_radbtn;
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
	@FindBy(xpath = "//*[@id='serviceProviderInfo']/div[2]/div/label[3]/span")
	public WebElement preferredServprovRadio_btn;
	@FindBy(xpath = "//*[@id='ServiceProviderFriendlyId']")
	public WebElement preferredServprovtxt;
	@FindBy(xpath = "//div[2]/div/a")
	public WebElement FinalizeDetails_btn;
	@FindBy(id = "finalisedworksites")
	public WebElement FinalizeDetails_btn1;
	@FindBy(id = "proceedtofinaliseworksites")
	public WebElement Proceed_btn;
	@FindBy(xpath = "//a[contains(text(),'Ok')]")
	public WebElement OK_btn;
	@FindBy(xpath = "//div[2]/a/strong")
	public WebElement Logout_btn;
	@FindBy(xpath = "//input[@id='UserName']")
	public WebElement AdminUsername;
	@FindBy(xpath = "//input[@id='Password']")
	public WebElement AdminPassword;
	@FindBy(xpath = "//div[3]/div/button")
	public WebElement AdminLogin_btn;
	@FindBy(id = "search-table")
	public WebElement AdminSearchBox;
	@FindBy(xpath = "//input[7]")
	public WebElement View_btn;
	@FindBy(xpath = "//p")
	public WebElement AllocatioFailed_Text;
	@FindBy(xpath = "//div[3]/div[2]/span")
	public WebElement AdminAbnnum;
	@FindBy(xpath = "//tr[6]/td[2]")
	public WebElement businessEntityNameCaputure;
	@FindBy(xpath = "//tr[6]/td[8]")
	public WebElement businessEntityLocationCaputure;
	@FindBy(xpath = "//div[2]/div/a")
	public WebElement TakemetoYourAc_btn;
	@FindBy(xpath = "//div/input")
	public WebElement BusineesUsername_Txt;
	@FindBy(xpath = "//div[2]/div/input")
	public WebElement BusinessPassword_Txt;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement BusineesLogin_btn;
	@FindBy(xpath = "//td")
	public WebElement Requestorname;
	@FindBy(xpath = "//td[3]")
	public WebElement NoresponseText;
	@FindBy(xpath = "//p[3]")
	public WebElement BookIDCaptureInEmail;
	@FindBy(xpath = "//h2")
	public WebElement Fail_text;
	@FindBy(xpath = "//em/a")
	public WebElement mailText;

}
