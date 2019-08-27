package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPOM {
	private WebDriver driver; 

	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[@class='normal-message']")
	private WebElement ConfirmationMessageAfterLogin;
	
	@FindBy(xpath="//div[@class='normal-message']/p[2]")
	private WebElement Actual;
	

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void checkConfirmationMessageAfterLogin() {
		String check=ConfirmationMessageAfterLogin.getText();
		System.out.println("Confirmation message is : "+check);
		String strActual = Actual.getText();
		Assert.assertEquals("As you can see, your courses list is still empty. That's because you are not registered to any course yet!", strActual, "Confirmation message exists");		
	}

}
