package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
public class myhooks {

	WebDriver driver;
	DriverFactory driverfactory;
	
	Properties prop = ConfigReader.intializeProperties();
	
	
	@Before
	public void setUp() {
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeBrowser("CHROME");
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
//		commonUtils.takeScreenShot(scenario);
		driver.quit();
	}
	
	
}
