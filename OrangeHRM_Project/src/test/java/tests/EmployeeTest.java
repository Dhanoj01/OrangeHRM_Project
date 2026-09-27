package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PimPage;
import utils.ConfigReader;

public class EmployeeTest extends BaseTest{
	
	
	@Test(dataProvider="EmployeeData")
	public void verifyEmployeeTest(String firstName , String lastName)
	{
		//first Login
		LoginPage loginpage = new LoginPage(driver);

		loginpage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password")
				);
		
		//go to pim
		PimPage pimpage = new PimPage(driver);
		
		pimpage.clickPIM();
		
		pimpage.clickAddBtn();
		
		pimpage.addEmployee(firstName,lastName);
		
		 // Verify
        Assert.assertTrue(
                pimpage.isPersonalDetailsDisplayed(),
                "Personal Details page is not displayed"
        );
        
     //   String ActualfirstName = pimpage.verifyEmployeeFirstName();
    //    Assert.assertEquals(ActualfirstName,firstName,"fname is not matching");
		
	}
	
	@DataProvider(name="EmployeeData")
	public Object[][] employeeData()
	{
		return new Object[][] {
			{"Dhanoj","Singh"},
			{"Sahil","Kumar"},
			{"Kapil","Sharma"}		
		};
	}

}
