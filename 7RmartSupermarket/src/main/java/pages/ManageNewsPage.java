package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	// moved to Homepage-since all the more info are in home page

	/*
	 * @FindBy(xpath =
	 * "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"
	 * ) WebElement manageNewsMoreInfo;
	 */

	public WebDriver driver;

	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement NewButton;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveNews;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement NewsCreatedSuccessfullyAlert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// moved to Homepage-since all the more info are in home page
	/*
	 * public void clickManageNewsMoreInfo() {
	 * 
	 * // used to click on Manage news-More info PageUtility pageutility = new
	 * PageUtility(); pageutility.clickUsingJavaScriptExecutor(driver,
	 * manageNewsMoreInfo);
	 * 
	 * }
	 */

	public ManageNewsPage clickNewButton() {
		NewButton.click();
		return this;
	}

	public ManageNewsPage enterNews(String news) {
		enterNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage SaveNews() {
		saveNews.click();
		return this;
	}

	public boolean newCreatedSuccessfullyAlertIsDisplayed() {
		return NewsCreatedSuccessfullyAlert.isDisplayed();
	}

}
