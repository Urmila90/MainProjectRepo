package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class CategoryPage {

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement categoryMoreInfo;
	public WebDriver driver;

	@FindBy(xpath = "//h1[text()='List Categories']")
	WebElement listCategoriestitle;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement listCategoriesNewButton;

	@FindBy(xpath = "//input[@id='category']")
	WebElement category;

	@FindBy(xpath = "//li[@id='1-selectable']")
	WebElement GoodnessGroup;

	@FindBy(xpath = "//li[@id='4-selectable']")
	WebElement organicGroup;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement categoryImage;

	// @FindBy(xpath="//input[@name='top_menu' and @checked='checked']")
	@FindBy(xpath = "//input[@value='no' and @name='top_menu']")
	WebElement showOnTopMenu;

	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	WebElement showOnLeftMenu;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveCategory;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCategoryMoreInfoToNavigateToListCategories() {
		categoryMoreInfo.click();
	}

	public void listCategoriesNewButton() {
		listCategoriesNewButton.click();
	}

	public void enterCategory(String categoryName) {
		category.sendKeys(categoryName);
	}

	public boolean listCategoriesTitleIsDisplayed() {
		return listCategoriestitle.isDisplayed();
	}

	public void clickGoodness() {
		GoodnessGroup.click();
	}

	public void clickOrganic() {
		organicGroup.click();
	}

	public void chooseImage() {
		FileUploadUtility fileuplaodutility = new FileUploadUtility();
		fileuplaodutility.fileUploadUsingSendKeys(categoryImage, Constant.IMAGEPATH1);
		// categoryImage.click();
	}

	public void showOnTopMenu() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(driver, showOnTopMenu);
	}

	public void showOnLeftMenu() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(driver, showOnLeftMenu);
		// showOnLeftMenu.click();
	}

	public void clickSave() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(driver, saveCategory);
		// saveCategory.click();
	}

}
