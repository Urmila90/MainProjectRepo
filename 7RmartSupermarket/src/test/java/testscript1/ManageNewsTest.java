package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load Manage News page when More Info is clicked and create a new News information")

	public void ManageNewsPageIsLoadedWhenMoreInfoClicked() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();

		// ManageNewsPage managenewspage = new ManageNewsPage(driver); //removed as part
		// of chaining
		managenewspage = homepage.clickManageNewsMoreInfo(); // this is not in Home page
		managenewspage.clickNewButton();
		String news = ExcelUtility.getStringData(1, 0, "news");
		managenewspage.enterNews(news).SaveNews();

		// Save button in Enter News Informations page
		// managenewspage.SaveNews();
		// Assertion to verify successmessage after news creation
		boolean successmessage = managenewspage.newCreatedSuccessfullyAlertIsDisplayed();
		Assert.assertTrue(successmessage, Constant.NEWSNOTSAVED);
	}
}
