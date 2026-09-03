package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	/*
	 * public WebDriver driver; public PageUtility(WebDriver driver) { this.driver =
	 * driver; }
	 */
	public void SelectByIndexDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleTextDropdown(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	public void selectByValueDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void dragAndDropAction(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void click(WebDriver driver, WebElement element) {
		// click method in Action class is used when normal click method does not work

		// showmessage.click();
		Actions obj2 = new Actions(driver);
		obj2.click(element).perform();

	}

}
