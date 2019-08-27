package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class SignUpPOM {
	private WebDriver driver; 

	public SignUpPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement link_Signup;

	@FindBy(id="registration_firstname")
	private WebElement Firstname;

	@FindBy(id="registration_lastname")
	private WebElement Lastname;

	@FindBy(id="registration_email")
	private WebElement Email;

	@FindBy(id="username")
	private WebElement Username;

	@FindBy(id="pass1")
	private WebElement Password;

	@FindBy(id="pass2")
	private WebElement ConfirmPassword;

	@FindBy(id="registration_phone")
	private WebElement Phone;

	@FindBy(id="registration_language")
	private WebElement Language;

	@FindBy(xpath="//input[@class='register-profile'][@checked='checked']")
	private WebElement StudentOption;

	@FindBy(id="registration_submit")
	private WebElement Register;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']")
	private WebElement ConfirmationMessage;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']/p[2]")
	private WebElement ActualMessage;
	
	

	public void clickonSignUp() {
		link_Signup.click();
	}
	public void sendFirstname(String Firstname) {
		this.Firstname.clear();
		this.Firstname.sendKeys(Firstname);
	}
	public void sendLastname(String Lastname) {
		this.Lastname.clear();
		this.Lastname.sendKeys(Lastname);
	}
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	public void sendUsername(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);
	}
	public void sendPassword(String Password) {
		this.Password.clear();
		this.Password.sendKeys(Password);
	}
	public void sendConfirmPassword(String ConfirmPassword) {
		this.ConfirmPassword.clear();
		this.ConfirmPassword.sendKeys(ConfirmPassword);
	}
	public void sendPhone(String Phone) {
		this.Phone.clear();
		this.Phone.sendKeys(Phone);
	}
	public void selectLanguage(String Lang) {
		new Select(Language).selectByVisibleText(Lang);
	}
	public void selectStudentOption() {
		//String strcheck=StudentOption.getAttribute("checked");
		//if (!strcheck.contains("checked")){StudentOption.click();}
		StudentOption.click();
	}
	public void clickonRegister() {
		this.Register.click();
	}
	
	public void checkConfirmationMessage() {
		String check=ConfirmationMessage.getText();
		System.out.println("Confirmation message is : "+check);
		String strActual=ActualMessage.getText();
		Assert.assertEquals("An e-mail has been sent to remind you of your login and password.", strActual, "Confirmation message exists");		
	}
	
}

