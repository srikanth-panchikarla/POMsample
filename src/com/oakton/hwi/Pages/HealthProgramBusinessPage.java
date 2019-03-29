package com.oakton.hwi.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.oakton.hwi.Utility.BrowserFactory;
import com.oakton.hwi.Utility.ReadConfigFile;

public class HealthProgramBusinessPage {
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
	@FindBy(linkText = "GET STARTED")
	public WebElement getStartedLink;
	@FindBy(linkText = "Creating a Health Program")
	public WebElement createHealthProgLink;
	@FindBy(xpath = "//a[contains(@href, '/Business/Health Program/Create Health Program')]")
	public WebElement createNewHealthProgLink;
	@FindBy(id = "name-health-program")
	public WebElement enterHealthNametxtbx;
	@FindBy(xpath = ".//*[@id='savehealthprogram']")
	public WebElement createHealthProgbtn;
	@FindBy(xpath = ".//*[@id='collapseOne']/div/a")
	public WebElement uploadLinkChk1;
	@FindBy(xpath = ".//*[@id='file']")
	public WebElement browserBtn;
	@FindBy(id = "uploadHealthProgramFile")
	public WebElement uploadBtn;
	@FindBy(xpath = ".//*[@id='collapseOne']/div/div/table/tbody/tr/td[1]")
	public WebElement uploadeddocumentNameStep1;
	@FindBy(linkText = "Mark As Final")
	public WebElement step1MarkAsFinalLink;
	@FindBy(xpath = "//*[@id='collapseOne']/div/input")
	public WebElement completedStepchkbox;
	@FindBy(xpath = ".//*[@id='accordion']/div[2]/div[1]/h4/a")
	public WebElement checkpoint2WorkplaceReview;
	@FindBy(xpath = ".//*[@id='collapseTwo']/div/div/div/div/a")
	public WebElement uploadLinkChk2;
	@FindBy(xpath = "html/body/section/div[2]/div/div/div/div/div/form/h2")
	public WebElement headingUploadWorkReview;
	@FindBy(xpath = ".//*[@id='collapseTwo']/div/div/div/div/table/tbody/tr/td[1]")
	public WebElement uploadeddocumentNamestep2;
	@FindBy(xpath = ".//*[@id='collapseTwo']/div/div/div/div/table/tbody/tr/td[6]/a[2]")
	public WebElement step2MarkAsFinalLink;
	@FindBy(xpath = ".//*[@id='collapseTwo']/div/input")
	public WebElement chkboxcompletedStep2;
	@FindBy(xpath = ".//*[@id='accordion']/div[3]/div[1]/h4/a")
	public WebElement checkpoint3ActionPlan;
	@FindBy(xpath = ".//*[@id='goals']/button")
	public WebElement addGoalBtn;

	@FindBy(id = "GoalName")
	public WebElement goalNametxtbx;
	@FindBy(id = "GoalDescription")
	public WebElement goalDescriptiontxtbx;
	@FindBy(id = "HealthArea")
	public WebElement ddlHealthArea;
	@FindBy(id = "addGoal")
	public WebElement saveGoalbtn;
	@FindBy(id = "actionTitle")
	public WebElement actionTitletxt;
	@FindBy(id = "actionDescription")
	public WebElement actionDescriptiontxt;
	@FindBy(id = "actionType")
	public WebElement actionTypetxt;
	@FindBy(linkText = "Add")
	public WebElement addLink;
	@FindBy(xpath = ".//*[@id='actionsForm']/table/tbody/tr[2]/td[1]/input[3]")
	public WebElement actionTitle2txt;
	@FindBy(xpath = ".//*[@id='actionsForm']/table/tbody/tr[2]/td[2]/input")
	public WebElement actionDescription2txt;
	@FindBy(xpath = ".//*[@id='actionsForm']/table/tbody/tr[2]/td[3]/select")
	public WebElement actionType2txt;

	@FindBy(xpath = ".//*[@id='collapseThree']/div/div[2]/div/div[1]/a")
	public WebElement uploadActionPlan;
	// next step Browse and click upload
	@FindBy(xpath = ".//*[@id='collapseThree']/div/div[2]/div/div[1]/table/tbody/tr/td[6]/a[2]")
	public WebElement step3markAsFinalLink;
	@FindBy(xpath = ".//*[@id='collapseThree']/div/input")
	public WebElement chkboxcompletedStep3;
	@FindBy(xpath = "//*[@id='accordion']/div[3]/div[1]/div/div[3]")
	public WebElement step3CompletedLabel;
	@FindBy(xpath = ".//*[@id='collapseThree']/div/div[2]/div/div[2]/a")
	public WebElement uploadServiceprovideruseOnly;

}
