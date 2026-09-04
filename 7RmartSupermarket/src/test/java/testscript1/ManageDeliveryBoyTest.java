package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage homepage; // added for chaining
	ManageDeliveryBoyPage deliveryboypage; // added for chaining

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load List Delivery Boy page when More Info is clicked and create a new Delivery boy")
	public void DeliveryBoyCreation() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();

		// loginpage.enterPassword(passwordvalue);

		// for chaining
		// ManageDeliveryBoyPage deliveryboypage = new ManageDeliveryBoyPage(driver);
		deliveryboypage = homepage.clickManageDeliveryBoyMoreInfo();

		// boolean
		// listDeliveryBoy=deliveryboypage.verifyListDeliveryBoyPageIsDisplayed();
		// Assert.assertTrue(listDeliveryBoy);

		deliveryboypage.clickNewButton();

		// Enter delivery boy info
		String name = ExcelUtility.getStringData(1, 0, "DeliveryBoyInfo");
		String email = ExcelUtility.getStringData(1, 1, "DeliveryBoyInfo");
		int phone = ExcelUtility.getIntegerData(1, 2, "DeliveryBoyInfo");
		String address = ExcelUtility.getStringData(1, 3, "DeliveryBoyInfo");
		String username = ExcelUtility.getStringData(1, 4, "DeliveryBoyInfo");
		String password = ExcelUtility.getStringData(1, 5, "DeliveryBoyInfo");

		// chaining
		deliveryboypage.enterDeliveryBoyName(name).enterDeliveryBoyEmail(email).enterDeliveryBoyPhone(phone)
				.enterDeliveryBoyAddress(address).enterDeliveryBoyUsername(username).enterDeliveryBoyPassword(password)
				.saveDeliveryBoyDetails();
		/*
		 * deliveryboypage.enterDeliveryBoyEmail(email);
		 * deliveryboypage.enterDeliveryBoyPhone(phone);
		 * deliveryboypage.enterDeliveryBoyAddress(address);
		 * deliveryboypage.enterDeliveryBoyUsername(username);
		 * deliveryboypage.enterDeliveryBoyPassword(password);
		 * deliveryboypage.saveDeliveryBoyDetails();
		 */

		boolean deliveryboyCreatedSuccessMessage = deliveryboypage
				.isSuccessAlertDisplayedOnSuccessfulDeliveryBoyAddition();
		Assert.assertTrue(deliveryboyCreatedSuccessMessage, Constant.DELIVERYBOYNOTCREATED);

	}
}
