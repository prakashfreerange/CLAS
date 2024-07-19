package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public WebDriver initializeBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		return driver;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
