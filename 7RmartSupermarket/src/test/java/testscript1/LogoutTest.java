package testscript1;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import testscript1.Base;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLogout() throws IOException
	{
		//before logout, we need to login first-so add these codes to login by
		//reading valid credentials from excel file.
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();
		
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();
		
	}

}
