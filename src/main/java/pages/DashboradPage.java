package pages;

import java.util.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboradPage {

	WebDriver driver;
	
	private static  Logger logger = Logger.getLogger(DashboradPage.class);

		public DashboradPage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(driver, this);
}
		@FindBy(xpath = "//li[@class='account-info']")
		WebElement user;
		
		@FindBy(xpath = "//a[@href='/logout']")
		WebElement logout;
		
		@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[@class='treeview']/a/span")
		List<WebElement> sidemenu;
		
		@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li/a/i[@class='fa fa-book']")
		WebElement catalog;
		
		@FindBy(xpath = "//ul[@class='sidebar-menu tree']/child::li[2]/child::ul/child::*/child::a/span")
		List<WebElement> catalogsubmenuElements;
		
		@FindBy(xpath = "//a[@href='/Admin/EmailAccount/List']/span")
		WebElement emailAccount;
		
		@FindBy(xpath = "//a[@href='/Admin/Product/List']/span")
		WebElement productTab;
		
		@FindBy(xpath = "//a[@href='/Admin/Manufacturer/List']/span")
		WebElement manufacturerTab;
		
		@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li/a/i[@class='fa fa-gears']")
		WebElement configurationTab;

		
	
		public boolean userDisplayed() {
			
			boolean b=false;
			try {
				b=user.isDisplayed();
			} catch (Exception e) {}
			return b;
		}
		
		public boolean logoutDisplayed() {
			
			boolean b=false;
			try {
				b=logout.isDisplayed();
			} catch (Exception e) {}
			return b;
		}
		
		public List<String> getSideMenu()
		{
			
			List<String> str=new ArrayList<String>();
			
			for (WebElement e:sidemenu) {
				str.add(e.getText());
				
			}
			return str;
		}
		
		public List<String> getCatalogSubMenu() throws InterruptedException{
				
				
				catalog.click();
				
				Thread.sleep(4000);
				
				List<String> str=new ArrayList<String>();
				
				for (WebElement e:catalogsubmenuElements) {
					str.add(e.getText());
					
				}
				return str;
			}
		
		public productPage clickonProduct() {
			
				catalog.click();
		
				productTab.click();
				return new productPage(driver);		
		}
		
		public ManufacturerPage clickonManufacturer() {
			
			catalog.click();
	
			manufacturerTab.click();
			
			return new ManufacturerPage(driver);
		}
		public ConfigurationPage clickonConfiguration() {
			
			logger.info("Clicking on Configuration Tab");
			configurationTab.click();
			logger.info("Clicking on EmailAccount Tab");
			emailAccount.click();
			
			return new ConfigurationPage(driver);
		}
		
		
}