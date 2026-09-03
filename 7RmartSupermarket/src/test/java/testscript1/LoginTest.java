package testscript1;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;

	@Test(priority = 1, retryAnalyzer = retry.Retry.class, groups = "regression", description = "Test case to verify if user is able to login with valid credentials")
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "loginpage");
		String password1 = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		// chaining of method
		loginpage.enterUserName(username1).enterPassword(password1);
		// loginpage.enterPassword(password1);
		homepage = loginpage.clickSignin(); // cannot be chained since it is navigating to another page-Home page
		// so create an object of the HomePage and assign method calling statement to
		// this object

		boolean homepage = loginpage.isDashboardDisplayedOnLogin();
		Assert.assertTrue(homepage, Constant.LOGINVALIDCREDENTIALS);

	}

	@Test(priority = 2, description = "Test case to verify if user is able to login with valid username and invalid password")
	public void verifyUserIsAbleToLoginWithvalidUserNameAndInvalidPassword() throws IOException {
		String username2 = ExcelUtility.getStringData(2, 0, "loginpage");
		String password2 = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username2).enterPassword(password2).clickSignin(); // chaining applied in clickSignin as
																					// well since it is a method for
																					// invalid password
		// loginpage.enterPassword(password2);
		// loginpage.clickSignin(); - can be chained since it is not navigating to any
		// other page

		// for validation 2 - to check if validation message is displayed for valid
		// username and invalid password

		boolean ValidUserNameInvalidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		// Assert.assertTrue(ValidUserNameInvalidPasswordValidation, "Home page is
		// loaded with invalid password"); //to do-call from Constant class
//Instead of hardcoding the error message directly in the code, we can add this message in Constant.java class and call it here
		Assert.assertTrue(ValidUserNameInvalidPasswordValidation, Constant.LOGININVALIDUSERNAME);
	}

	@Test(priority = 3, description = "Test case to verify if user is able to login with invalid username and valid password")
	public void verifyUserIsAbleToLoginWithInvalidUserNameAndValidPassword() throws IOException {
		String username3 = ExcelUtility.getStringData(3, 0, "loginpage");
		String password3 = ExcelUtility.getStringData(3, 0, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username3).enterPassword(password3).clickSignin();// chaining applied
		// loginpage.enterPassword(password3);
		// loginpage.clickSignin();

		// for validation 2 - to check if validation message is displayed for invalid
		// username and valid password
		boolean InvalidUserNameValidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		Assert.assertTrue(InvalidUserNameValidPasswordValidation, Constant.LOGINWITHINVALIDPASSWORD);

	}

	@Test(priority = 4, description = "Test case to verify if user is able to login with invalid username and password")
	public void verifyUserIsAbleToLoginWithInvalidUserNameAndInvalidPassword() throws IOException {
		String username4 = ExcelUtility.getStringData(4, 0, "loginpage");
		String password4 = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username4).enterPassword(password4).clickSignin();
		// loginpage.enterPassword(password4);
		// loginpage.clickSignin();

		// for validation 2 - to check if validation message is displayed for invalid
		// username and invalid password
		boolean InvalidUserNameInvalidPasswordValidation = loginpage.validationMessageForInvalidLoginDisplayed();
		Assert.assertTrue(InvalidUserNameInvalidPasswordValidation, Constant.LOGINWITHINVALIDUSERNAMEANDPASSWORD);
	}
}
