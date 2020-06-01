package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import net.bytebuddy.asm.Advice.This;

public class ManufacturerPage {
	
	WebDriver driver;
	
	
	public ManufacturerPage(WebDriver dr){
		this.driver=dr;
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@class='pull-right']/a[@class='btn bg-blue']")
	WebElement addNewbtn;
	
	@FindBy(xpath = "//div[@class='panel-container']/child::*/child::div[1]/child::div[1]/child::div[2]/div/input[@class='form-control text-box single-line']")
	WebElement nameField;
	
	@FindBy(xpath = "//button[@type='submit' and @name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//input[@class='form-control text-box single-line']")
	WebElement manuName;
	
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-primary btn-search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement successmsg;
	
	@FindBy(xpath = "//span[text()='Please provide a name.']")
	WebElement errorTxt; 
	
	public void addNewManufe(String name) {
		
		addNewbtn.click();	
		nameField.sendKeys(name);
		saveBtn.click();
		
	}
	public boolean getSuccssMsg() {
		
		boolean b=successmsg.isDisplayed();
		return b;
	}
	
	public boolean checkManufacrereName() {
		
		boolean b=errorTxt.isDisplayed();
		return b;
	}
	
	public void search() {
		manuName.sendKeys("");
		searchBtn.click();
		
	}
	

	
	
	
}
