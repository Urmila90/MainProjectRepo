package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
@Test(retryAnalyzer = retry.Retry.class)
public void AdminUSersPageIsLoadedWhenMoreInfoIsClicked() throws IOException
{
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		//Verify if "Admin Users" text is displayed on clicking Admin users option from Dashboard
		boolean adminuserstext=adminuserspage.IsAdminUsersTextDisplayedOnClickingAdminUsersFromDashboard();
		Assert.assertTrue(adminuserstext);
		
		
		adminuserspage.clickNewButton();
		
		String adminUsername = ExcelUtility.getStringData(1, 0, "usernamepage");
		String adminPassword = ExcelUtility.getStringData(1, 1, "usernamepage");
		adminuserspage.enterUsername(adminUsername);
		adminuserspage.enterPassword(adminPassword);
		adminuserspage.userTypeIndex();
		adminuserspage.saveAdminUser();
		
		//check if "User created successfully" alert message is displayed when Admin user is created
		boolean successmesage=adminuserspage.IsAdminUserSuccessAlertMessageDisplayed();
		Assert.assertTrue(successmesage);
		
		//Check if Username aleady exists" message is displayed for duplicate username
		boolean errormessage=adminuserspage.isAdminUserAlreadyExistsRedMessageDisplayed();
		Assert.assertTrue(errormessage);
		//doubt: if success message is displayed failure assertion is failed
		//or already exist assertion pass, success failed
}
}
