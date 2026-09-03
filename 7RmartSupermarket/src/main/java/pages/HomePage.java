package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement SignInButtonInLoginPage;

	// from ManageNews page-more info
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsMoreInfo;
	WebDriver driver;
	// from category page-more info
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement categoryMoreInfo;
	// from AdminUsersPage-more info
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreInfo;
	// from DeliveyBoyPage-more info
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	WebElement manageDeliveryBoyMoreInfo;
	// from ManageLocations page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class=' nav-link']")
	WebElement manageLocationMoreInfo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public LoginPage clickLogout() { // once logged out, it will navigate to Login page. So give LoginPage as the
										// return type.
		logout.click();
		return new LoginPage(driver);
	}

	// from ManageNewsPage
	public ManageNewsPage clickManageNewsMoreInfo() {

		// used to click on Manage news-More info
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(driver, manageNewsMoreInfo);
		return new ManageNewsPage(driver);
	}

	// from CategoryPage
	public CategoryPage clickCategoryMoreInfoToNavigateToListCategories() {
		categoryMoreInfo.click();
		return new CategoryPage(driver);
	}

	// from Manage Delivery Boy Page
	public ManageDeliveryBoyPage clickManageDeliveryBoyMoreInfo() {
		manageDeliveryBoyMoreInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}

	// from AdminUsersPage
	public AdminUsersPage clickAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageLocationPage clickManageLocationMoreInfoToNavigateToListLocations() {
		manageLocationMoreInfo.click();
		return new ManageLocationPage(driver);
	}

	// Successful logout validation
	public boolean isSignInButtonDisplayedOnLogout() {
		return SignInButtonInLoginPage.isDisplayed();
	}
}
