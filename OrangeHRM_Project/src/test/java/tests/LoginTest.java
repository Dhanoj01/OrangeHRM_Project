package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

  @Test(groups = {"smoke"})
  void verifyLogin()
  {
     	LoginPage loginpage = new LoginPage(driver);
     	
     	loginpage.login(
     			ConfigReader.getProperty("username"),
     			ConfigReader.getProperty("password")
     			);
     	
     	WaitUtils waitUtils = new WaitUtils(driver);
     	
     	waitUtils.waitForUrlContains("dashboard");
     	
     	String actualUrl = driver.getCurrentUrl();
     	
        Assert.assertTrue(actualUrl.contains("dashboard"));
        
        DashboardPage dashboard = new DashboardPage(driver);
        
        Assert.assertTrue(dashboard.isDashboardDisplayed(),"Dashboard is not displayed");
        
      
        
  }
}