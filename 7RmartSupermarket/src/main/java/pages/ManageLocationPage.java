package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	PageUtility pageutility = new PageUtility();

	/*
	 * //move to home page
	 * 
	 * @FindBy(xpath =
	 * "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class=' nav-link']"
	 * ) WebElement manageLocationMoreInfo;
	 */
	public WebDriver driver;
	@FindBy(xpath = "//h1[text()='List Locations']")
	WebElement listLocationsTitle;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement listLocationsNewButton;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countryDropdown;

	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateDropdown;

	@FindBy(xpath = "//input[@id='location']")
	WebElement enterLocation;

	@FindBy(xpath = "//input[@id='delivery']")
	WebElement enterDeliveryCharge;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveLocationInformation;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertLocationCreatedSuccessfully;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * move to Home page public void
	 * clickManageLocationMoreInfoToNavigateToListLocations() {
	 * manageLocationMoreInfo.click(); }
	 */
	public ManageLocationPage listLocationsNewButton() {
		listLocationsNewButton.click();
		return this;
	}

	public ManageLocationPage countryDropdown(String countryvalue) {
		// PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleTextDropdown(countryDropdown, countryvalue);
		// pageutility.SelectByIndexDropdown(countryDropdown,1);
		return this;

	}

	public ManageLocationPage statedropdown(String stateValue) {
		// PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleTextDropdown(stateDropdown, stateValue);
		// pageutility.SelectByIndexDropdown(stateDropdown,5);
		return this;

	}

	/*
	 * //Verify whether List Locations title is displayed when More Info in Manage
	 * Locations is clicked. public boolean
	 * listLocationsTitleDisplayedWhenManageLocationsMoreInfoClicked() { return
	 * listLocationsTitle.isDisplayed(); }
	 */

	public ManageLocationPage enterLocation(String location) {
		enterLocation.sendKeys(location);
		return this;
	}

	public ManageLocationPage enterDeliveryCharge(int deliveryCharge) {
		// deliveryCharge is an int, but Selenium's sendKeys() accepts CharSequence
		// values such as String, not int.
		// So convert the integer to a String:
		enterDeliveryCharge.sendKeys(String.valueOf(deliveryCharge));
		return this;
	}

	public ManageLocationPage SaveLocationInfo() {
		saveLocationInformation.click();
		return this;
	}

	public boolean successAlertDisplayedOnSuccessfulLocationAddition() {
		return alertLocationCreatedSuccessfully.isDisplayed();
	}
}
