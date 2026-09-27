package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class PimPage {

	WebDriver driver;
	WaitUtils waitUtils;

	public PimPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver , this);

		waitUtils = new WaitUtils(driver);
	}

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimMenu;

	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addBtn;

	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;

	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement saveBtn;

	@FindBy(xpath = "//h6[text()='Personal Details']")
	WebElement personalDetailsHeading;
	

	
	public void clickPIM() {

        waitUtils.waitForElementClickable(pimMenu);
        pimMenu.click();
    }

	public void clickAddBtn()
	{
		waitUtils.waitForElementClickable(addBtn);
		addBtn.click();
	}

	public void enterFirstName(String fname)
	{
		waitUtils.waitForElementVisible(firstName);
		firstName.sendKeys(fname);
	}


	public void enterLastName(String lname)
	{
		waitUtils.waitForElementVisible(lastName);
		lastName.sendKeys(lname);
	}

	public void clickSave()
	{
		waitUtils.waitForElementClickable(saveBtn);
		saveBtn.click();
	}

	public boolean isPersonalDetailsDisplayed() {

		waitUtils.waitForElementVisible(personalDetailsHeading);

		return personalDetailsHeading.isDisplayed();
	}

	public void addEmployee(String fname , String lname)
	{

		enterFirstName(fname);
		enterLastName(lname);
		clickSave();
	}
	
	public String verifyEmployeeFirstName()
	{
		waitUtils.waitForElementVisible(firstName);
		
		return firstName.getAttribute("value");
	}


}
