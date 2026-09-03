package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	/*
	 * @FindBy(xpath =
	 * "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']"
	 * ) WebElement manageDeliveryBoyMoreInfo;
	 */

	@FindBy(xpath = "//h1[text()='List Delivery Boy']")
	WebElement listDeliveryBoyText;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add' and @onclick='click_button(1)']")
	WebElement newButton;

	@FindBy(xpath = "//input[@name='name']")
	WebElement deliveryBoyName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement deliveryBoyEmail;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement deliveryBoyPhone;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement deliveryBoyAddress;

	@FindBy(xpath = "//input[@id='username']")
	WebElement deliveryBoyUsername;

	@FindBy(xpath = "//input[@id='password']")
	WebElement deliveryBoyPassword;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveDeliveryBoy;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertDeliveryBoyCreatedSuccessfully;

	public WebDriver driver;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * //move to Home page public ManageDeliveryBoyPage
	 * clickManageDeliveryBoyMoreInfo() { manageDeliveryBoyMoreInfo.click(); return
	 * new ManageDeliveryBoyPage(driver) }
	 */

	/*
	 * public boolean verifyListDeliveryBoyPageIsDisplayed() { return
	 * listDeliveryBoyText.isDisplayed(); }
	 */
	public ManageDeliveryBoyPage clickNewButton() {
		newButton.click();
		return this;
	}

	public ManageDeliveryBoyPage enterDeliveryBoyName(String name) {
		deliveryBoyName.sendKeys(name);
		return this;
	}

	public ManageDeliveryBoyPage enterDeliveryBoyEmail(String email) {
		deliveryBoyEmail.sendKeys(email);
		return this;

	}

	public ManageDeliveryBoyPage enterDeliveryBoyPhone(int phone) {
		deliveryBoyPhone.sendKeys(String.valueOf(phone));
		return this;

	}

	public ManageDeliveryBoyPage enterDeliveryBoyAddress(String address) {
		deliveryBoyAddress.sendKeys(address);
		return this;
	}

	public ManageDeliveryBoyPage enterDeliveryBoyUsername(String username) {
		deliveryBoyUsername.sendKeys(username);
		return this;
	}

	public ManageDeliveryBoyPage enterDeliveryBoyPassword(String password) {
		deliveryBoyPassword.sendKeys(password);
		return this;

	}

	public ManageDeliveryBoyPage saveDeliveryBoyDetails() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(driver, saveDeliveryBoy);
		// saveDeliveryBoy.click();
		return this;
	}

	public boolean isSuccessAlertDisplayedOnSuccessfulDeliveryBoyAddition() {
		return alertDeliveryBoyCreatedSuccessfully.isDisplayed();
	}

}
