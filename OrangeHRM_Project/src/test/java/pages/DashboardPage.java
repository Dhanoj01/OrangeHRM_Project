package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class DashboardPage {

	WebDriver driver;
	WaitUtils waitUtils;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver , this);
		
		waitUtils = new WaitUtils(driver);
	}
	
	@FindBy(xpath ="//h6[text()='Dashboard']")
	WebElement dashboardHeading;
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement AdminMenu;
	
	
	public boolean isDashboardDisplayed()
	{
		waitUtils.waitForElementVisible(dashboardHeading);
		return dashboardHeading.isDisplayed();
	}
	
	public void clickAdmin()
	{
		waitUtils.waitForElementClickable(AdminMenu);
		AdminMenu.click();
	}
}
