package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, groups="regression")
	public void CategoriesCreation() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickSignin();

		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickCategoryMoreInfoToNavigateToListCategories();

		//boolean listCategoryTitle = categorypage.listCategoriesTitleIsDisplayed();
		//Assert.assertTrue(listCategoryTitle);

		categorypage.listCategoriesNewButton();

		String categoryName = ExcelUtility.getStringData(1, 0, "Category");
		categorypage.enterCategory(categoryName);

		categorypage.clickGoodness();
		categorypage.clickOrganic();
		categorypage.chooseImage();
		categorypage.showOnTopMenu();
		categorypage.showOnLeftMenu();
		categorypage.clickSave();

	}
}