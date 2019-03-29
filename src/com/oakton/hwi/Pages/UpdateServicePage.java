package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class UpdateServicePage {
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
	@FindBy(xpath = "html/body/header/div[2]/div[2]/div/div/ul/li[2]/a")
	public WebElement serviceProviderLink;
	@FindBy(xpath = ".//*[@id='search-table']")
	public WebElement quickSerachTxtbx;
	@FindBy(xpath = ".//*[@id='table-service-providers']/tbody/tr[1]/td[6]/form[2]/button")
	public WebElement modifyAddresslink;
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
	@FindBy(xpath = ".//*[@id='form-service-provider']/div[8]/div/button[2]")
	public WebElement savechangesBtn;
	@FindBy(xpath = ".//*[@id='finish-sp']")
	public WebElement completeAccountSetupBtn;
	@FindBy(xpath = "//*[@id='modal-sp-finish']/div/div/div[1]")
	public WebElement dialogboxSuccessCreated;
	@FindBy(xpath = "//*[@id='modal-sp-finish']/div/div/div[1]/button")
	public WebElement closeDialogboxSuccessCreated;
}
