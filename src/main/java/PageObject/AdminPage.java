package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	public AdminPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	//Maven Project
	@FindBy (xpath = "//input[@id ='Email']")
	WebElement txtEmail;
	
	@FindBy (xpath = "//input[@id ='Password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//button[text()='Log in']")
	WebElement btnLogin;
	
	//User define method to perform operation on above web element
	
	public void SetUsername(String uname) {
		txtEmail.sendKeys(uname);
		
	}
	
	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void ClickOnLogin() {
		btnLogin.click();
		
	}
	
}
