package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class CreateGovPage {

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
	@FindBy(xpath = "//a[contains(@href,'/en/HWI-Admin/Government-Agency')]")
	public WebElement govAgencyLink;
	@FindBy(id = "btnAddGovernmentAgency")
	public WebElement btnAddGovAgency;
	@FindBy(id = "clusterName")
	public WebElement inputClusterName;
	@FindBy(id = "agencyName")
	public WebElement inputAgencyName;
	@FindBy(id = "agencyABN")
	public WebElement inputAgencyABN;
	@FindBy(id = "agencyFirstName")
	public WebElement inputAgencyFirstName;
	@FindBy(id = "agencyLastname")
	public WebElement inputAgencyLastName;
	@FindBy(id = "agencyEmail")
	public WebElement inputAgencyEmail;
	@FindBy(id = "agencyPhone")
	public WebElement inputAgencyPhone;
	@FindBy(id = "agencyNoOfFTE")
	public WebElement inputAgencyNoOfFTE;
	@FindBy(id = "agencyNoOfWorksites")
	public WebElement inputAgencyNoOfWorksites;
	@FindBy(id = "workSiteName")
	public WebElement inputWorkSiteName;
	@FindBy(id = "workSiteAddressline1")
	public WebElement inputWorkSiteAddressline1;
	@FindBy(id = "suburd")
	public WebElement inputSuburd;
	@FindBy(id = "postcode")
	public WebElement inputPostcode;
	@FindBy(id = "NumberOfWorkers")
	public WebElement inputNumberOfWorkers;
	@FindBy(id = "totalNoOfHCsrequire")
	public WebElement inputTotalNoOfHCsrequire;
	@FindBy(id = "liketoaHP")
	public WebElement inputLiketoaHP;
	@FindBy(id = "spFrinedlyId")
	public WebElement inputSpFrinedlyId;
	@FindBy(xpath = ".//*[@id='formGovAgencyWorksite']/div[2]/div/div[18]/div/button[1]")
	public WebElement btnSave;
	@FindBy(xpath = ".//*[@id='formGovAgencyWorksite']/div[2]/div/div[18]/div/button[2]")
	public WebElement btnCancel;
	@FindBy(xpath = ".//*[@id='search-table']")
	public WebElement txtQuickSearch;
	@FindBy(xpath = ".//*[@id='table-hwi-admin-govAgency']/tbody/tr[1]/td[6]")
	public WebElement emailSearch;
	@FindBy(xpath = ".//*[@id='table-hwi-admin-govAgency']/tbody/tr/td[3]")
	public WebElement abnValueTbl;
	@FindBy(xpath = ".//*[@id='table-hwi-admin-govAgency']/thead/tr/th[6]")
	public WebElement emailHeader;
	@FindBy(xpath = "html/body/header/div[2]/div[1]/div/div[2]/div[1]/a/strong")
	public WebElement logoutLink;
	@FindBy(xpath = ".//*[@id='table-hwi-admin-govAgency']/tbody/tr/td")
	public WebElement msgNoData;
	@FindBy(xpath = "html/body/header/div[2]/div[1]/div/div[1]/a/img")
	public WebElement imgHome;

	@FindBy(id = "abntxt")
	public WebElement Reg_TextABNName;
	@FindBy(id = "firstnametxt")
	public WebElement Reg_TextFirstName1;
	@FindBy(id = "emailaddresstxt")
	public WebElement Reg_TextEmail;
}
