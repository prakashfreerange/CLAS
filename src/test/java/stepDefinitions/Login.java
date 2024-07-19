package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;


public class Login {
	
	

	WebDriver driver;
	DriverFactory driverfactory = new DriverFactory();
	LoginPage loginpage;


	@Given("user has navigated to login page.")
	public void user_has_navigated_to_login_page() {
		driver = driverfactory.getDriver();
	    loginpage = new LoginPage(driver);
	}

	@When("^User enter valid email address (.+)$")
	public void user_enter_valid_email_address_prakash_freerange_com(String emailText) {
	   loginpage.enterEmailAddress(emailText);
	}

	@When("^User enter valid password (.+)$")
	public void user_enter_valid_password_avdi(String passwordText) {
	   loginpage.enterPassword(passwordText);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   loginpage.clickLoginButton();
	}

	@Then("user navigated to admin dashboard.")
	public void user_navigated_to_admin_dashboard() {
	   Assert.assertEquals("Signed in successfully.", loginpage.verifyLoginSuccessMessage());
	}


}
