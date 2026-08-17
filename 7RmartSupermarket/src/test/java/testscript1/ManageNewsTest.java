package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, groups = "regression")

	public void ManageNewsPageIsLoadedWhenMoreInfoClicked() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsMoreInfo();
		managenewspage.clickNewButton();
		String news = ExcelUtility.getStringData(1, 0, "news");
		managenewspage.enterNews(news);

		// Save button in Enter News Informations page
		managenewspage.SaveNews();
		// Assertion to verify successmessage after news creation
		boolean successmessage = managenewspage.newCreatedSuccessfullyAlertIsDisplayed();
		Assert.assertTrue(successmessage);
	}
}
