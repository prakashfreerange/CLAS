package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webelement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	
	public void clickOnElement(WebElement element, long durationInSeconds)
	{
			WebElement webelement = waitForElement(element, durationInSeconds);
			webelement.click();
	}
	
	
	public void typeTextIntoElement(WebElement element,String textTobeTyped, long durationInSeconds)
	{
		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textTobeTyped);
	}
	
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webelement;
	}
	
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].click()", webelement);
	}
	
	public void javaScriptType(WebElement element,  String textToBTyped, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].value='"+textToBTyped+"';", webelement);
	}
	
}
