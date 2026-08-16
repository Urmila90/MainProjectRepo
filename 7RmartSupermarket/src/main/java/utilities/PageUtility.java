package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	/*
	 * public WebDriver driver; public PageUtility(WebDriver driver) { this.driver =
	 * driver; }
	 */
	public void SelectByIndexDropdown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByVisibleTextDropdown(WebElement element, String visibletext)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	public void selectByValueDropdown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	

}

