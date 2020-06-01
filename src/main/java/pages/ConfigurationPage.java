package pages;

import org.jsoup.nodes.BooleanAttribute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationPage {
	
	WebDriver driver;
	
	public ConfigurationPage(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='pull-right']/a")
	WebElement addNewBtn;
	
	@FindBy(id = "Email")
	WebElement eamil;
	
	@FindBy(id = "DisplayName")
	WebElement displayName;
	
	@FindBy(id = "Host")
	WebElement hostName;
	
	@FindBy(xpath = "//button[@class='btn bg-blue' and @name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class='field-validation-error']/span[@id='Email-error']")
	WebElement emailErrorMsg;
	
	@FindBy(id = "DisplayName-error")
	WebElement emailDisplayNameErroMsg;
	
	@FindBy(id = "EnableSsl")
	WebElement sslTab;
	
	public void addNewConfig(String emailaddress,String name) {
		addNewBtn.click();
		eamil.sendKeys(emailaddress);
		displayName.sendKeys(name);
		sslTab.click();
		saveBtn.click();
		
	}
	
	public boolean getEmailErrorMsg() {
		
		return emailErrorMsg.isDisplayed();
		
	}
	
	public boolean getEmailDisplayNameError() {
		
		return emailDisplayNameErroMsg.isDisplayed();
		
	}
	

}
