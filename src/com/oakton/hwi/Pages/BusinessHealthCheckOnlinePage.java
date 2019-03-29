package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class BusinessHealthCheckOnlinePage {
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
	@FindBy(xpath = "//div/input")
	public WebElement BusineesUsername_Txt;
	@FindBy(xpath = "//div[2]/div/input")
	public WebElement BusinessPassword_Txt;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement BusineesLogin_btn;
	@FindBy(xpath = "(//a[contains(text(),'Manage online health checks')])[2]")
	public WebElement manageHealthcheck_Link;
	@FindBy(xpath = "//div[3]/a")
	public WebElement BusinessUsernameText;
	@FindBy(xpath = "//select")
	public WebElement Worksite_dropdown;
	@FindBy(id = "generateHealthCheckEmail")
	public WebElement GenerateHealthcheckEmail_btn;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement Confirmation_btn;
	@FindBy(xpath = "//div[3]/button")
	public WebElement Close_btn;
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
	@FindBy(xpath = "//td/a")
	public WebElement Gmail_HealthCheckActivation_Link;
	@FindBy(id = "consent-agree")
	public WebElement Agree_checkbox;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Submit_btn;
	@FindBy(xpath = "//form[@id='fidHealthCheckQuestionsSection2Page4']/ol/li/div[2]/div/label")
	public WebElement Agegroup_sel;
	@FindBy(xpath = "//li[2]/div[2]/div/label")
	public WebElement gender_Sel;
	@FindBy(xpath = "//ul/li/div[2]/div[6]/label")
	public WebElement Ethnicity_sel;
	@FindBy(xpath = "//ul/li[2]/div[2]/div/label")
	public WebElement AsianDescent_sel;
	@FindBy(xpath = "//li[3]/div[2]/div[2]/label")
	public WebElement Born_sel;
	@FindBy(xpath = "//li[4]/div[2]/div/label[2]")
	public WebElement ParentsDiabetic_sel;
	@FindBy(xpath = "//ol[2]/li/div[2]/div/label[2]")
	public WebElement Bloodpressure_sel;
	@FindBy(xpath = "//ol[2]/li[2]/div[2]/div/label[2]")
	public WebElement Medication_sel;
	@FindBy(xpath = "//li[3]/div[2]/div/label[2]")
	public WebElement Smokecigarettes_sel;
	@FindBy(xpath = "//ol[2]/li[4]/div[2]/div/label")
	public WebElement veggie_sel;
	@FindBy(xpath = "//li[5]/div[2]/div[2]/label")
	public WebElement physicalexercise_sel;
	@FindBy(id = "quiz-waist-measurement")
	public WebElement Waist_Txt;
	@FindBy(xpath = "//div[2]/div/div/a")
	public WebElement okbutton_sel;
	@FindBy(xpath = "//ol[3]/li/div[2]/div/label")
	public WebElement SmokingCigareetes_sel;
	@FindBy(xpath = "//ol[3]/li[2]/div[2]/div/label")
	public WebElement Smokecigar;
	@FindBy(xpath = "//ol[3]/li[3]/div[2]/div[3]/label")
	public WebElement Firstcigar_sel;
	@FindBy(xpath = "//ol[3]/li[4]/div[2]/div/label")
	public WebElement Cigareete_sel;
	@FindBy(xpath = "//ol[4]/li/div[2]/div[4]/label")
	public WebElement vegetable_sel;
	@FindBy(xpath = "//ol[4]/li[2]/div[2]/div[3]/label")
	public WebElement Servingfruits_sel;
	@FindBy(xpath = "//li[3]/ol/li/div[2]/div[2]/label")
	public WebElement Fishandchips_sel;
	@FindBy(xpath = "//li[3]/ol/li[2]/div[2]/div[2]/label")
	public WebElement chocandBis_Sel;
	@FindBy(xpath = "//li[3]/ol/li[3]/div[2]/div[2]/label")
	public WebElement softdrinks_sel;
	@FindBy(xpath = "//ol[4]/li[4]/div[2]/div[4]/label")
	public WebElement plainwater_sel;
	@FindBy(xpath = "//ol[5]/li/div[2]/div[2]/label")
	public WebElement Alcoholoften_sel;
	@FindBy(xpath = "//ol[5]/li[2]/div[2]/div[3]/label")
	public WebElement DrinkSize_sel;
	@FindBy(xpath = "//label/span[2]")
	public WebElement WalkbyOffice_sel;
	@FindBy(xpath = "//ol[7]/li/div[2]/div/label")
	public WebElement JobAct_sel;
	@FindBy(xpath = "//ol[8]/li/div[2]/div[4]/label")
	public WebElement PhyActiv_Sel;
	@FindBy(id = "healthCheckResultBtn")
	public WebElement HealthCheckresult_btn;
	@FindBy(xpath = "//a[3]/span")
	public WebElement PDF_btn;
	/// SP Online Web elements
	@FindBy(xpath = ".//*[@id='loginForm']/div[3]/div/button")
	public WebElement loginButton;
	@FindBy(linkText = "My Businesses")
	public WebElement myBusinessLink;
	@FindBy(xpath = "//input[@id='search-table']")
	public WebElement quickSearch;
	@FindBy(xpath = "//*[@id='table-my-business']/tbody/tr/td[5]/a")
	public WebElement healthProgramManageLink;
	@FindBy(xpath = ".//*[@id='create-booking-tabs']/li[2]/a")
	public WebElement launchHealthCheckTab;
	@FindBy(id = "onlineHealthCheckSeats")
	public WebElement totalNoOfHealthCheckTxt;
	@FindBy(id = "create-online-healthcheck-entries")
	public WebElement createOnlineHealthCheckBtn;
	@FindBy(xpath = "//td[4]/a/i")
	public WebElement launchBtn;
	@FindBy(xpath = ".//*[@id='office-use-only-next-button']")
	public WebElement nextButton;
	@FindBy(xpath = ".//*[@id='intervention-Smoking']")
	public WebElement ChkboxSmoking;
	@FindBy(xpath = ".//*[@id='Quitline-a1']")
	public WebElement RadioBtnQuitline;
	@FindBy(xpath = ".//*[@id='Get healthy info and coaching service-a1']")
	public WebElement RadioBtnHealthInfo;
	@FindBy(xpath = ".//*[@id='Other e.g. local program-a1']")
	public WebElement RadioBtnlocal;
	@FindBy(xpath = ".//*[@id='gp-referral-1']")
	public WebElement ChkboxReferral;
	@FindBy(xpath = ".//*[@id='backToHealthCheckLaunchPage']")
	public WebElement backToHealthCheckLaunchPageBtn;
	@FindBy(xpath = ".//*[@id='finalizeList']/i")
	public WebElement finalizeBtn;
	@FindBy(xpath = " .//*[@id='step2confirmationModal']")
	public WebElement modalDialogFinalise;
	@FindBy(xpath = " .//*[@id='btnYes']")
	public WebElement modalDialogYesbtn;
}
