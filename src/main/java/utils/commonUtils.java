package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class commonUtils {
	
	static WebDriver driver;
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static final int PAGE_LOAD_TIME = 15;
	
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
	
	
	public static void takeScreenShot(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] sourceScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceScreenshot, "image/png", scenarioName);
		}
	}

}
