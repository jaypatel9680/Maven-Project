package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboradPage;
import pages.LoginPage;
import pages.ManufacturerPage;
import pages.productPage;
import testbase.TestBase;

public class ManufacturerTest {
	
	WebDriver driver;
	LoginPage loginPage;
	DashboradPage dashboardpage;
	productPage productPage;
	ManufacturerPage manufacturerPage;
	
	
	@BeforeClass(alwaysRun = true)
	public void startBrowser() throws IOException, InterruptedException {
		
		driver=TestBase.getInstance();
		loginPage=new LoginPage(driver);
		dashboardpage=loginPage.loginToApplication("admin@yourstore.com", "admin");
		dashboardpage=new DashboradPage(driver);
		manufacturerPage=dashboardpage.clickonManufacturer();
		manufacturerPage=new ManufacturerPage(driver);
		}
	
	@Test(priority = 1)
	public void varifyNewManufacturer() {
		
		TestBase.logger.info("adding new Manufacturer");
				
		manufacturerPage.addNewManufe("abc");
		assertTrue(manufacturerPage.getSuccssMsg());
		
		driver.navigate().refresh();
		
	}
	
	@Test(priority = 2)
	public void verifySearch() {
		
		manufacturerPage.search();	
		
	}
	
	@Test(priority = 3)
	public void verifyValidManufName() {
		
		manufacturerPage.addNewManufe("");
		assertTrue(manufacturerPage.checkManufacrereName());
		
	}
		
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
