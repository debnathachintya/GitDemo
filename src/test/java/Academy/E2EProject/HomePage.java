package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void validateHomepage(String username, String password) throws IOException {
		String baseURL = prop.getProperty("url");
		driver.get(baseURL);
		log.info("Navigated to Homepage");
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage l = new LoginPage(driver);
		l.inputEmail().sendKeys(username);
		l.inputPassword().sendKeys(password);
		
		log.info("User Validation Success");
		l.clickLogin().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		
		// 0th Row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		
		// 1st Row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "12345678";
		
		return data;
	}
}