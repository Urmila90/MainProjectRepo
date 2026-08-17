package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	// dashboard for successful login validation

	// for validation 1 -login and check if Dashboard is displayed
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;

	// for validation 2 - to check if validation message is displayed for invalid
	// credentials.
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	WebElement validationMessageForInvalidLogin;

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username) {
		usernameField.sendKeys(username);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSignin() {
		signin.click();

	}

//for successful login - validation
	public boolean isDashboardDisplayedOnLogin() {
		// WaitUtility waitutility=new WaitUtility();
		// waitutility.waitForAlertToBeVisible(driver,dashboard);
		return dashboard.isDisplayed();
	}

	// for invalid login-show validation message
	public boolean validationMessageForInvalidLoginDisplayed() {
		return validationMessageForInvalidLogin.isDisplayed();
	}
}
