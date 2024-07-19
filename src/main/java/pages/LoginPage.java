package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementutils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id = "admin_user_email")
	private WebElement loginEmailInput;
	
	@FindBy(id = "admin_user_password")
	private WebElement loginPasswordInput;
	
	@FindBy(xpath = "//input[@name='commit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='flash flash_notice']")
	private WebElement loginSuccessMessage;
	
	
	public void enterEmailAddress(String emailText)
	{
		elementutils.typeTextIntoElement(loginEmailInput, emailText, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText)
	{
		elementutils.typeTextIntoElement(loginPasswordInput, passwordText, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickLoginButton() {
		elementutils.clickOnElement(loginButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String verifyLoginSuccessMessage() {
		return elementutils.waitForVisibilityOfElement(loginSuccessMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME).getText();
	}
	
}
