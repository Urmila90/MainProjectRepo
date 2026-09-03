package utilities;

import java.security.KeyStore.Entry.Attribute;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final int IMPLICIT_WAIT = 5;
	public static final int EXPLICIT_WAIT = 5;

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Eg: login page-sign in button's attribute class="btn btn-dark btn-block"
	// wait.until(ExpectedConditions.attributeContains(element, "class",
	// "btn-block"));
	// It checks whether an attribute contains a particular value.
	public void waitForAttributeContains(WebDriver driver, WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		// attributeContains(WebElement element, String attribute, String value)
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

	// It checks whether an attribute's value is exactly equal to the value we
	// specify.
	// Eg: for my understanding -
	// wait.until(ExpectedConditions.attributeToBe(element, "class", "btn btn-dark
	// btn-block"));

	public void waitForAttributeToBe(WebDriver driver, WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));

	}

	// It waits until a particular element is selected.
	// Mainly used for elements such as:Checkbox,Radio button and <option> in a
	// dropdown
	public void waitForelementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

}
