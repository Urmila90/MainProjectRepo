package testscript1;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
import testscript1.Base;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load Home page when More Info is clicked")
	public void verifyUserIsAbleToLogout() throws IOException {
		// before logout, we need to login first-so add these codes to login by
		// reading valid credentials from excel file.
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();

		HomePage logoutpage = new HomePage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();

	}

}
