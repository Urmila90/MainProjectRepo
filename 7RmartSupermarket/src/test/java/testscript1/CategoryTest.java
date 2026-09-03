package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	HomePage homepage;
	CategoryPage categorypage;

	@Test(retryAnalyzer = retry.Retry.class, groups = "regression", description = "Load Category Creation page when More Info is clicked and create a new Caterogy")
	public void CategoriesCreation() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.clickSignin();

		// CategoryPage categorypage = new CategoryPage(driver);
		categorypage = homepage.clickCategoryMoreInfoToNavigateToListCategories();

		// boolean listCategoryTitle = categorypage.listCategoriesTitleIsDisplayed();
		// Assert.assertTrue(listCategoryTitle);

		categorypage.listCategoriesNewButton();

		String categoryName = ExcelUtility.getStringData(1, 0, "Category");
		categorypage.enterCategory(categoryName).clickGoodness().clickOrganic().chooseImage().showOnTopMenu()
				.showOnLeftMenu().clickSave();

		boolean CategoryCreatedMessage = categorypage
				.isCategoryCreatedSuccessfullyMessageDisplayedOnSuccessfulCategoryAddition();
		Assert.assertTrue(CategoryCreatedMessage, Constant.CATEGORYNOTCREATED);

		/*
		 * categorypage.clickGoodness(); categorypage.clickOrganic();
		 * categorypage.chooseImage(); categorypage.showOnTopMenu();
		 * categorypage.showOnLeftMenu(); categorypage.clickSave();
		 */
	}
}