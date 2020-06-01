package utilities;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


import testbase.TestBase;



public class TestUtility extends TestBase{
	
	
		
	public static void scrollFunc(WebElement e,WebDriver driver) { 
		
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();" ,e);
		je.executeScript("Windows.scrollBy(0,400);","");
		
		
	}
	public static void clickFunc(WebElement a,WebDriver driver) {
		
	JavascriptExecutor je=(JavascriptExecutor) driver;
	je.executeScript("arguments[0].click();",a);
}
	public static  void screenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/Users/jay/eclipse-workspace/MavenProjects/ScreenShots/FailScreenShot.jpg"));
		
	}
}