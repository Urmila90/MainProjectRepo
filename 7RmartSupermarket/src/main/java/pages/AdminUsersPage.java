package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreInfo;

	// Locate "Admin Users" text -to ensure correct page is loaded on login
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement adminUsersTestOnPageLoad;

	// New button in Admin Users page
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement New;

	// Admin Users page
	//Username field
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	// Password field
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	// User Type dropdown
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;

	// Admin users save button
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement SaveAdminUser;

	// Alert message-User created successfully
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AdminUserSuccessAlertMessage;

	// Alert message-Admin user already exists
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement AdminUserFailureAlertMessage;

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
	}
	// To verify if "Admin Users" text is displayed on clicking Admin users option
	// from Dashboard

	public boolean IsAdminUsersTextDisplayedOnClickingAdminUsersFromDashboard() {
		return adminUsersTestOnPageLoad.isDisplayed();

	}

	public void clickNewButton() {
		New.click();
	}

	// Admin Users page
	// username field
	public void enterUsername(String adminUsername) {
		username.sendKeys(adminUsername);
	}

	public void enterPassword(String adminPassword) {
		password.sendKeys(adminPassword);
	}

	public void userTypeIndex() {
		PageUtility pageutility = new PageUtility();
		pageutility.SelectByIndexDropdown(userTypeDropdown, 2);

	}

	public void saveAdminUser() {
		SaveAdminUser.click();
	}

	public boolean IsAdminUserSuccessAlertMessageDisplayed() {
		return AdminUserSuccessAlertMessage.isDisplayed();

	}

	public boolean isAdminUserAlreadyExistsRedMessageDisplayed() {
		return AdminUserFailureAlertMessage.isDisplayed();
	}

}
