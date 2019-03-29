package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class CreateBusinessPage {

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
	@FindBy(id = "b1")
	public WebElement Reg_RadioButton;
	
	
	
	
	@FindBy(xpath = ".//*[@id='btnSelectBusiness']")
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
	@FindBy(id = "identifierId")
	public WebElement Gmail_UserName;
	@FindBy(className = "CwaK9")
	public WebElement Gmail_NextClick;
	@FindBy(name = "password")
	public WebElement Gmail_password;
}
