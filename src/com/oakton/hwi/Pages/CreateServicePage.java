package com.oakton.hwi.Pages;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class CreateServicePage {

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

	public CreateServicePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(linkText = "Login")
	public WebElement loginLinkClick;
	@FindBy(id = "UserName")
	public WebElement emailtxt;
	@FindBy(id = "Password")
	public WebElement passwordtxt;
	@FindBy(xpath = ".//*[@id='loginForm']/div[3]/div/button")
	public WebElement loginButton;
	@FindBy(xpath = "html/body/header/div[2]/div[2]/div/div/ul/li[2]/a")
	public WebElement serviceProviderLink;
	@FindBy(xpath = "//a[contains(@href,'/HWI%20Admin/Service%20Providers/Create')]")
	public WebElement addServiceProviderLink;

	@FindBy(id = "ServiceProvider_ServiceProviderName")
	public WebElement serviceProviderNametxt;
	@FindBy(id = "ServiceProvider_ServiceProviderAddressLine1")
	public WebElement serviceProviderAddrs1txt;
	@FindBy(id = "ServiceProvider_ServiceProviderAddressLine2")
	public WebElement serviceProviderAddrs2txt;
	@FindBy(id = "ServiceProvider_Suburb")
	public WebElement serviceProviderSuburbtxt;
	@FindBy(id = "ServiceProvider_State")
	public WebElement serviceProviderStatetxt;
	@FindBy(id = "ServiceProvider_PostCode")
	public WebElement serviceProviderPostcodetxt;
	@FindBy(id = "ServiceProviderAdmin_FullName")
	public WebElement serviceProviderAdminFullNametxt;
	@FindBy(id = "ServiceProviderAdmin_UserName")
	public WebElement serviceProviderAdminUserNametxt;
	@FindBy(xpath = ".//*[@id='form-service-provider']/div[9]/div/button")
	public WebElement ClickNexStepButton;

	// Add Contract Elements
	@FindBy(id = "ContractName")
	public WebElement contractNametxt;
	@FindBy(id = "dpd1")
	public WebElement contractStartDatetxt;
	@FindBy(id = "dpd2")
	public WebElement contractEndDatetxt;
	@FindBy(id = "servicearea")
	public WebElement selectServiceareaddl;
	@FindBy(xpath = ".//*[@id='region-0']")
	public WebElement selectRegion1;
	@FindBy(xpath = ".//*[@id='addcontract']/div[2]/div[4]/button")
	public WebElement ClickaddKPI;
	@FindBy(xpath = ".//*[@id='smallkpi-0']")
	public WebElement smallKPItxt;
	@FindBy(xpath = ".//*[@id='mediumkpi-0']")
	public WebElement mediumKPItxt;
	@FindBy(xpath = ".//*[@id='lgkpi-0']")
	public WebElement largeKPItxt;
	@FindBy(id = "createContract")
	public WebElement clickSaveAndContiBtn;
	@FindBy(name = "autoallocate")
	public WebElement selectAutoAllocate;
	@FindBy(xpath = ".//*[@id='modal-sp-updated-info']/div/div/div[1]")
	public WebElement dialogboxServiceUpdated;
	@FindBy(xpath = ".//*[@id='modal-sp-updated-info']/div/div/div[1]/button")
	public WebElement closeDialogboxServiceUpdated;
	@FindBy(id = "SPThresholdValueforIncentiveClaim")
	public WebElement IncentiveClaimChcbox;
	@FindBy(id = "SPThresholdValueforPreApproval")
	public WebElement PreApprovalChcbox;
	@FindBy(xpath = ".//*[@id='finish-sp']")
	public WebElement completeAccountSetupBtn;
	@FindBy(xpath = "//*[@id='modal-sp-finish']/div/div/div[1]")
	public WebElement dialogboxSuccessCreated;
	@FindBy(xpath = "//*[@id='modal-sp-finish']/div/div/div[1]/button")
	public WebElement closeDialogboxSuccessCreated;

	@FindBy(id = "identifierId")
	public WebElement Gmail_UserName;
	@FindBy(className = "CwaK9")
	public WebElement Gmail_NextClick;
	@FindBy(xpath = "//div[@id='password']/div/div/div/input")
	public WebElement Gmail_password;
	@FindBy(name = "q")
	public WebElement Gmail_Searchbar;
	@FindBy(xpath = ".//*[@id='gbqfb']/span")
	public WebElement Gmail_SearchBtn;
	@FindBy(xpath = "//div[2]/span[2]")
	public WebElement Gmail_ClickMail;
	@FindBy(xpath = "//td/a")
	public WebElement Gmail_ClickActivationLink;
	@FindBy(xpath = "//h1/span")
	public WebElement Gmail_mailTitle;
	@FindBy(id = "newpassword")
	public WebElement newPasswordtxt;
	@FindBy(id = "new-confirm-password")
	public WebElement newConfirmPasswordtxt;
	@FindBy(id = "reset-password")
	public WebElement resetPasswordBtn;
	// @FindBy(css="span.il") public WebElement Gmail_mailTitlecss;

}
