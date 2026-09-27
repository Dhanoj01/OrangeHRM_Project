package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AdminTest extends BaseTest {

	@Test
	public void verifAdminPage()
	{
		//first Login
		LoginPage loginpage = new LoginPage(driver);

		loginpage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password")
				);

		// Go to Dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed"
        );

        // Click Admin
        dashboardPage.clickAdmin();
        

        // Verify Admin page
        AdminPage adminPage = new AdminPage(driver);

        Assert.assertTrue(
                adminPage.isAdminPageDisplayed(),
                "Admin page is not displayed"
        );

     // Search Admin user
        adminPage.searchUser(
                ConfigReader.getProperty("username")
        );

//        // Verify search result
//        Assert.assertTrue(
//                adminPage.isSearchResultDisplayed(),
//                "Search result is not displayed"
//        );
	}
}
