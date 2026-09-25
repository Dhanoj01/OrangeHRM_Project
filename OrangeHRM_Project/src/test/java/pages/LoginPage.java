package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class LoginPage {

	WebDriver driver;
	WaitUtils waitUtils;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitUtils = new WaitUtils(driver);
	}

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement pass;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	public void enterUsername(String user_name)
	{
		waitUtils.waitForElementVisible(username);
		username.sendKeys(user_name);
	}

	public void enterPassword(String password)
	{
		waitUtils.waitForElementVisible(pass);
		pass.sendKeys(password);
	}

	public void clickLoginBtn()
	{
	    waitUtils.waitForElementClickable(loginBtn);
		loginBtn.click();
	}

	//one single method combine all method
	public void login(String user_name, String password) {

		enterUsername(user_name);
		enterPassword(password);
		clickLoginBtn();
	}
}
