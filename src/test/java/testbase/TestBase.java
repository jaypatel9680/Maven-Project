package testbase;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


	public class TestBase {

			
			public static WebDriver driver;
			static Properties prop;
			public static String browser;
			
			public static  Logger logger = Logger.getLogger(TestBase.class);
			
			public static  WebDriver getInstance() throws IOException {
				
			String file = "./src/main/java/confi/conf.properties";
			
			FileInputStream inStream=new FileInputStream(new File(file));
			
	
			prop=new Properties();
			prop.load(inStream);
			String browser = prop.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
				driver=getChrome();
				
			}else if(browser.equalsIgnoreCase("firefox")){
				getFireFox();
				
			}else {
				Throwable th=new Throwable();
				th.initCause(null);
				
			}
			logger.info("maximizing browser");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			logger.info("url : "+ prop.getProperty("url") );
			
			
			
			return driver;
			
		}
			
			public static WebDriver getChrome() {
				
				WebDriver dr;
				String value=prop.getProperty("chromeAgent");
				String key="webdriver.chrome.driver"; 
				
				System.setProperty(key,value);
				 dr=new ChromeDriver();
				 return dr;
		
				
			}
			public static WebDriver getFireFox() {
				String value=prop.getProperty("firefoxAgent");	
				String key="webdriver.gecko.driver";
				
				System.setProperty(key,value);
				 driver=new FirefoxDriver();
				 return driver;
				
			}

}
