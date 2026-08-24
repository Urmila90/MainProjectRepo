package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshotutility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot interface - convert webdriver to screenshot mode
		//Selenium Webdriver cannot take screenshots directly. So we typecaste 
		//into TakeScreenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//Capture the screenshot and store it 
		//temporarily as a file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//create date and time
		//Date is a class used to get the current date
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); 
																					
		if (!f1.exists()) {
			f1.mkdirs(); // Create a folder/directory if it does not exist
		}
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // decide final screenshot path
	}
}
