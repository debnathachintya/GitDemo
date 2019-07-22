package stepDefinations;

import org.testng.Assert;

import Academy.E2EProject.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;

public class stepDefination extends base {
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link on homepage to land on secure sign in page$")
	public void click_on_Login_link_on_homepage_to_land_on_secure_sign_in_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		if (lp.getPopUpSize() > 0) {
			lp.getPopup().click();
		}

		lp.getLogin().click();
	}
	
	 @When("^user enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPage l = new LoginPage(driver);
			l.inputEmail().sendKeys(username);
			l.inputPassword().sendKeys(password);

			l.clickLogin().click();
	    }

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		portalHomePage p = new portalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());
	}
	
	 @And("^Close Browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }
}