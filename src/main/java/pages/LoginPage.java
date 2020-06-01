package pages;


import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	
	public  static Logger logger = Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "Email")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement clickbutton;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']/ul/li")
	WebElement passErrorTxt;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	WebElement usernameErrorcheck;
	
	@FindBy(xpath = "//div[@class='title']/strong")
	WebElement welcomePage;
	
	public DashboradPage loginToApplication(String useremail,String pass) {

		username.clear();
		
		logger.info("entering username");		
		username.sendKeys(useremail);
		
		password.clear();
		logger.info("entering password");
		password.sendKeys(pass);
		clickbutton.click();
		return new DashboradPage(driver);
		
	}
	
	public boolean welcomeMsgDisplay() {
		boolean b=false;
		try {
			b=welcomePage.isDisplayed();
		}catch(Exception e) {}
		return b;
		
	} 
	public String welcomeTxt()
	{
		return welcomePage.getText();
	}
	public void enterUserName(String User) {

		username.clear();
		username.sendKeys(User);
		
	}
	public void enterPass(String Pass) {
		
		
		password.clear();
		password.sendKeys(Pass);
		
	}
	public void loginBtnClick() {
		
		
		clickbutton.click();
		
	}
	
	public boolean getEmailErrorCheck() {
		
		boolean e = false;
		try {
			e=usernameErrorcheck.isDisplayed();
			System.out.println(e);
			}
		catch (Exception e1) {}
		return e;
		
	}
	public boolean getpassErrorTxt() {
		
		boolean e = false;
		try {
			e=passErrorTxt.isDisplayed();
			System.out.println(e);
			}
		catch (Exception e1) {}
		return e;	
		}
	
	public String checkTitleTest() {
		
			String title = driver.getTitle();
			
			return title;
			
	}
	
	
}
		
		
		


