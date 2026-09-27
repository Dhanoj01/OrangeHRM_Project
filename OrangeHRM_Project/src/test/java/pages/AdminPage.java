package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class AdminPage {

	 WebDriver driver;
	    WaitUtils waitUtils;

	    public AdminPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);

	        waitUtils = new WaitUtils(driver);
	    }

	    @FindBy(xpath = "//h6[text()='Admin']")
	    WebElement adminHeading;

	    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	    WebElement usernameInput;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement searchButton;

	    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']")
	    WebElement searchResultRow;  //error in this locator
	    
	    
	    public boolean isAdminPageDisplayed() {

	        waitUtils.waitForElementVisible(adminHeading);

	        return adminHeading.isDisplayed();
	    }
	    
	    public void enterUsername(String username) {

	        waitUtils.waitForElementVisible(usernameInput);

	        usernameInput.sendKeys(username);
	    }

	    public void clickSearch() {

	        waitUtils.waitForElementClickable(searchButton);

	        searchButton.click();
	    }

	    public boolean isSearchResultDisplayed() {

	        waitUtils.waitForElementVisible(searchResultRow);

	        return searchResultRow.isDisplayed();
	    }

	    public void searchUser(String username) {

	        enterUsername(username);
	        clickSearch();
	    }
	
}
