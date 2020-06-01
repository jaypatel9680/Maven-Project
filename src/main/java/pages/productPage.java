package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	
	WebDriver driver;
	DashboradPage dashboradPage;
	productPage productPage;
	
	public productPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement addNewBtnElement;
	
	
	
	public void clickOnAddNewBtn() {
		
		addNewBtnElement.click();
		
	}
	
	public String titleOfPage() {
		return driver.getTitle();
	}
}