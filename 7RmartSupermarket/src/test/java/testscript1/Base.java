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
		@BeforeMethod
		public void browserInitialization() 
		{
		
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
		
	 	}
		@AfterMethod
		public void quitAndClose()
		{
			driver.quit();
		}
		
		}
		

	


