package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboradPage;
import pages.LoginPage;
import pages.productPage;
import testbase.TestBase;
public class dashboardPageTest{
	
	WebDriver driver;
	LoginPage loginPage;
	DashboradPage dashboardpage;
	productPage productPage;
	
	private static  Logger logger = Logger.getLogger(dashboardPageTest.class);
	
	@BeforeClass(alwaysRun = true)
	public void startBrowser() throws IOException {
		
		driver=TestBase.getInstance();
		loginPage=new LoginPage(driver);
		dashboardpage=loginPage.loginToApplication("admin@yourstore.com", "admin");
		dashboardpage=new DashboradPage(driver);
	
	}

	@Test(priority = 1)
	public void getsideMenu() {
		
			
		List<String> array = dashboardpage.getSideMenu();
		logger.info("List of Side menu");
		System.out.println(array);
	}
	@Test(priority = 2)
		
		public void verifyusername() {
			
		 boolean b = dashboardpage.userDisplayed();
		 assertTrue(dashboardpage.userDisplayed());
			
		 System.out.println(b);
	
	}
	
	@Test(priority = 3)
	public void varifyCatalog() throws InterruptedException {
		
		List<String> menuList=dashboardpage.getCatalogSubMenu();
		logger.info("List of catalog sub-menu");
		System.out.println(menuList);
	}
	
	@Test(priority = 4)
	public void getProductPage() throws InterruptedException {
		
	productPage = dashboardpage.clickonProduct();
		Thread.sleep(2000);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}
