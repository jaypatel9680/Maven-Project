package testcases;

import static org.testng.Assert.assertTrue;


import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ConfigurationPage;
import pages.DashboradPage;
import pages.LoginPage;
import pages.productPage;
import testbase.TestBase;
import utilities.TestUtility;

public class ConfigurationTest {

	WebDriver driver;
	LoginPage loginPage;
	DashboradPage dashboardpage;
	productPage productPage;
	ConfigurationPage configurationPage;
	
	
	@BeforeClass(alwaysRun = true)
	public void startBrowser() throws IOException, InterruptedException {
		
		driver=TestBase.getInstance();
		loginPage=new LoginPage(driver);
		dashboardpage=new DashboradPage(driver);
		productPage=new productPage(driver);
		configurationPage=new ConfigurationPage(driver);
		dashboardpage=loginPage.loginToApplication("admin@yourstore.com", "admin");
		configurationPage=dashboardpage.clickonConfiguration();
		
}
	
	@Test(priority = 1)
	public void verifyValidEmail(){
		
		configurationPage.addNewConfig("abc@gmail.com","jay");
		
}
	@Test(priority = 2)
	public void verifyErrorMsg() throws IOException {
		configurationPage.addNewConfig("abc","jay");
		TestUtility.screenShot(driver);
		assertTrue(configurationPage.getEmailErrorMsg());
		driver.navigate().back();
	}
	
	@Test(priority = 3)
	public void verifyDisplayErrorMsg() {
		configurationPage.addNewConfig("jay@gmail.com","");
		assertTrue(configurationPage.getEmailDisplayNameError());
		driver.navigate().back();

		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}