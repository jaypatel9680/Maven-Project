package testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pages.DashboradPage;
import pages.LoginPage; 
import pages.productPage;
import testbase.TestBase;

@Listeners(utilities.listnerClass.class)
public class prodctPageTest {
	
	WebDriver driver;
	LoginPage loginPage;
	DashboradPage dashboardpage;
	productPage productPage;
	
	
	
	@BeforeClass(alwaysRun = true)
	public void startBrowser() throws IOException, InterruptedException {
		
		driver=TestBase.getInstance();
		loginPage=new LoginPage(driver);
		dashboardpage=new DashboradPage(driver);
		productPage=new productPage(driver);
		dashboardpage=loginPage.loginToApplication("admin@yourstore.com", "admin");
		productPage=dashboardpage.clickonProduct();
		
	}
	@Test
	public void getAddNew() throws InterruptedException {
		
		TestBase.logger.info("adding new product");
		productPage.clickOnAddNewBtn();
		
	}
	@Test
	public void VerifyTitleOfProductPage() {
		String title=productPage.titleOfPage();
		Assert.assertEquals(title, "Products / nopCommerce administration");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
