package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class validateNavigationBar extends base {
	public static Logger log = LogManager.getLogger(validateNavigationBar.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		String baseURL = prop.getProperty("url");
		driver.get(baseURL);
		log.info("Navigated to homepage");
	}
	
	@Test()
	public void validateNavBar() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigated Successfully");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
}