package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateTitle extends base {
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		String baseURL = prop.getProperty("url");
		driver.get(baseURL);
		log.info("Navigated to Homepage");
	}
	
	@Test()
	public void validatePageTitle() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Page Title Validated Successfully");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
}