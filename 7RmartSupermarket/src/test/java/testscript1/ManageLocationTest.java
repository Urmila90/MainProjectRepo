package testscript1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	HomePage homepage;
	ManageLocationPage managelocation;

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load List Locations page when More Info is clicked and and add a new location")
	public void manageLocationSPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();

		// for chaining
		// ManageLocationPage managelocation = new ManageLocationPage(driver);
		// //declared globally and use chaining
		managelocation = homepage.clickManageLocationMoreInfoToNavigateToListLocations();

		// boolean
		// listlocationtitle=managelocation.listLocationsTitleDisplayedWhenManageLocationsMoreInfoClicked();
		// Assert.assertTrue(listlocationtitle);
		managelocation.listLocationsNewButton();

		String countryvalue = ExcelUtility.getStringData(2, 0, "countryAndState");
		managelocation.countryDropdown(countryvalue);
		String stateValue = ExcelUtility.getStringData(6, 1, "countryAndState");
		managelocation.statedropdown(stateValue);

		String location = ExcelUtility.getStringData(2, 0, "locationAndDeliveryCharge");
		int deliveryCharge = ExcelUtility.getIntegerData(2, 1, "locationAndDeliveryCharge");
		// chaining
		managelocation.enterLocation(location).enterDeliveryCharge(deliveryCharge).SaveLocationInfo();
		// managelocation.enterDeliveryCharge(deliveryCharge);

		// managelocation.SaveLocationInfo();

		boolean locationSuccessAlert = managelocation.successAlertDisplayedOnSuccessfulLocationAddition();
		Assert.assertTrue(locationSuccessAlert, Constant.LOCATIONNOTSAVED);
	}

}
