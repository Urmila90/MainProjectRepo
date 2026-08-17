package testscript1;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority = 1, retryAnalyzer = retry.Retry.class, groups = "regression")
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "loginpage");
		String password1 = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username1);
		loginpage.enterPassword(password1);
		loginpage.clickSignin();

		boolean homepage = loginpage.isDashboardDisplayedOnLogin();
		Assert.assertTrue(homepage);

	}

	@Test(priority = 2)
	public void verifyUserIsAbleToLoginWithvalidUserNameAndInvalidPassword() throws IOException {
		String username2 = ExcelUtility.getStringData(2, 0, "loginpage");
		String password2 = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username2);
		loginpage.enterPassword(password2);
		loginpage.clickSignin();

		// for validation 2 - to check if validation message is displayed for valid
		// username and invalid password

		boolean ValidUserNameInvalidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		Assert.assertTrue(ValidUserNameInvalidPasswordValidation);

	}

	@Test(priority = 3)
	public void verifyUserIsAbleToLoginWithInvalidUserNameAndValidPassword() throws IOException {
		String username3 = ExcelUtility.getStringData(3, 0, "loginpage");
		String password3 = ExcelUtility.getStringData(3, 0, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username3);
		loginpage.enterPassword(password3);
		loginpage.clickSignin();

		// for validation 2 - to check if validation message is displayed for invalid
		// username and valid password
		boolean InvalidUserNameValidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		Assert.assertTrue(InvalidUserNameValidPasswordValidation);
	}

	@Test(priority = 4)
	public void verifyUserIsAbleToLoginWithInvalidUserNameAndInvalidPassword() throws IOException {
		String username4 = ExcelUtility.getStringData(4, 0, "loginpage");
		String password4 = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username4);
		loginpage.enterPassword(password4);
		loginpage.clickSignin();

		// for validation 2 - to check if validation message is displayed for invalid
		// username and invalid password
		boolean InvalidUserNameInvalidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		Assert.assertTrue(InvalidUserNameInvalidPasswordValidation);
	}
}
