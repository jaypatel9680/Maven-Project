package testcases;

import static org.testng.Assert.assertTrue;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.DashboradPage;
import pages.LoginPage;
import testbase.TestBase;
@Listeners(utilities.listnerClass.class)
public class loginTest {
	
	WebDriver driver;
	LoginPage loginPage;
	DashboradPage dashboardpage;
	 
	@BeforeClass(alwaysRun = true)
	public void startBrowser() throws IOException {
	
		driver=TestBase.getInstance();
		loginPage=new LoginPage(driver);
		
	}
	@Test(priority = 3,description = "TestPage.LoginToApplication")
	public void loginToApplication() {
		
	dashboardpage =	loginPage.loginToApplication("admin@yourstore.com", "admin");
		

	}
	@Test(priority = 1,description = "TestPage.verifyValidUserName")
	public void userNameErrormsg() throws InterruptedException {
		
		loginPage.enterUserName("admin");
		Thread.sleep(4000);
		assertTrue(loginPage.getEmailErrorCheck());
		
	}
	@Test(priority = 2,description = "TestPage.verifyValidCredantial")
	
	public void checkValidCredantial() throws InterruptedException {
		
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPass("fbhdsbif");
		Thread.sleep(4000);
		loginPage.loginBtnClick();
		TestBase.logger.info("verifying Error message");
		assertTrue(loginPage.getpassErrorTxt());
		
		 }
	@Test(description = "TestPage.verifyTitleOfHomepage")
	public void varifyTitleOfLoginPage() {
		
		String title = loginPage.checkTitleTest();
		TestBase.logger.info("verifying title of login page");
		
		Assert.assertEquals(title, "Dashboard / nopCommerce administration","title not matched");
	}

	 
	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
	

		

	

}
