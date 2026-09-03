package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserspage;

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load Admin user page when More Info is clicked")
	public void AdminUsersPageIsLoadedWhenMoreInfoIsClicked() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();

		// AdminUsersPage adminuserspage = new AdminUsersPage(driver); //will apply
		// chaining-so no need of this line
		adminuserspage = homepage.clickAdminUsersMoreInfo(); // moreinfo is now in Homepage, after clicking more info we
																// move to adminusers page-so assign the line to
																// adminuserspage object.
		/*
		 * //Verify if "Admin Users" text is displayed on clicking Admin users option
		 * from Dashboard //boolean adminuserstext=adminuserspage.
		 * IsAdminUsersTextDisplayedOnClickingAdminUsersFromDashboard();
		 * //Assert.assertTrue(adminuserstext); //if needed do it as a separate
		 * testcases //validationa should be done at the end of tc-if we want to add
		 * validation in between a tc, add it as a separate tc and then add validation
		 */
		adminuserspage.clickNewButton();

		// String adminUsername = ExcelUtility.getStringData(1, 0, "usernamepage");
		// String adminPassword = ExcelUtility.getStringData(1, 1, "usernamepage");
		FakerUtility faker = new FakerUtility();
		String adminUsername = faker.creatARandomFirstName();
		String adminPassword = faker.creatARandomFirstName();

		adminuserspage.enterUsername(adminUsername).enterPassword(adminPassword).userTypeIndex().saveAdminUser();
		// adminuserspage.enterPassword(adminPassword);
		// adminuserspage.userTypeIndex();
		// adminuserspage.saveAdminUser();

		// check if "User created successfully" alert message is displayed when Admin
		// user is created
		boolean successmesage = adminuserspage.IsAdminUserSuccessAlertMessageDisplayed();
		// //Assert.assertTrue(successmesage, "Admin users page is not loaded when More
		// info is clicked");
		// So the above line becomes,
		Assert.assertTrue(successmesage, Constant.ADMINUSERNOTCREATED);// don't give the error message directly in the
																		// testcase, instead add it in Constnat.java
																		// class and access it here.

		// Check if Username aleady exists" message is displayed for duplicate username
		// boolean errormessage =
		// adminuserspage.isAdminUserAlreadyExistsRedMessageDisplayed();
		// Assert.assertTrue(errormessage);
		// doubt: if success message is displayed failure assertion is failed
		// or already exist assertion pass, success failed
	}
}
