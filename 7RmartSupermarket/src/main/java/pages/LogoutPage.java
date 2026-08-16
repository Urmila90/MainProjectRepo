package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
		@FindBy(xpath = "//a[@data-toggle='dropdown']")
		WebElement admin;
		@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
		WebElement logout;
		WebDriver driver;

		public LogoutPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void clickAdmin() {
			admin.click();
		}

		public void clickLogout() {
			logout.click();
		}

	}



