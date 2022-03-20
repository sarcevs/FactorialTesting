package kriptomatDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	public WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void init(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\selenium-java-4.1.0\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\selenium-java-4.1.0\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "F:\\Selenium\\selenium-java-4.1.0\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
