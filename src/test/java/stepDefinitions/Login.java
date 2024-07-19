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

	
	@When("^User enter email address (.+)$")
	public void user_enter_email_address(String emailText) {
	    loginpage.enterEmailAddress(emailText);
	}

	@When("^User enter password (.+)$")
	public void user_enter_password(String passwordText) {
	    loginpage.enterPassword(passwordText);
	}

	@When("User dont enter email address")
	public void user_dont_enter_email_address() {

	}

	@When("User dont enter password")
	public void user_dont_enter_password() {

	}
	

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   loginpage.clickLoginButton();
	}

	@Then("user navigated to admin dashboard.")
	public void user_navigated_to_admin_dashboard() {
	   Assert.assertEquals("Signed in successfully.", loginpage.verifyLoginSuccessMessage());
	}

	@Then("user should get a warning message")
	public void user_should_get_a_warning_message() {
	   Assert.assertEquals("Invalid Email or password.", loginpage.verifyInvalidLoginDetailsMessage());
	}

}
