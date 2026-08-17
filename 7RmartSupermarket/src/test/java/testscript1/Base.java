package testscript1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;
import java.time.Duration;

public class Base {

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
		@Parameters("browser")
		public void browserInitialization(String browser) throws Exception 
		{
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("edge"))
			{
			driver=new EdgeDriver();

			}
		else
			{
			throw new Exception("invalid");
			}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	 	}

	@AfterMethod(alwaysRun = true)
	public void quitAndClose() {
		driver.quit();
	}
}
