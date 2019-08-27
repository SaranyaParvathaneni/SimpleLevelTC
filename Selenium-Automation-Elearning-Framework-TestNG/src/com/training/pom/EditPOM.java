package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditPOM {
	private WebDriver driver; 

	public EditPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Edit profile')]")
	private WebElement EditProfile;

	@FindBy(xpath="(//div[@class='col-sm-8']/input)[2]")
	private WebElement ProfilePassword;

	@FindBy(xpath="(//div[@class='col-sm-8']/input)[3]")
	private WebElement NewPassword;

	@FindBy(xpath="(//div[@class='col-sm-8']/input)[4]")
	private WebElement ConfirmNewPassword;

	@FindBy(id="profile_apply_change")
	private WebElement SaveChanges;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement SaveSettingsMessage;
	
	
	public void clickonEditProfile() {
		this.EditProfile.click();
	}
	public void sendProfilePassword(String ProfilePassword) {
		this.ProfilePassword.clear();
		this.ProfilePassword.sendKeys(ProfilePassword);
	}
	public void sendNewPassword(String NewPassword) {
		this.NewPassword.clear();
		this.NewPassword.sendKeys(NewPassword);
	}
	public void sendConfirmNewPassword(String ConfirmNewPassword) {
		this.ConfirmNewPassword.clear();
		this.ConfirmNewPassword.sendKeys(ConfirmNewPassword);
	}
	public void clickonSaveChanges() {
		this.SaveChanges.click();
	}
	public void SaveSettingsMessage() {
		String check=SaveSettingsMessage.getText();
		System.out.println("SaveSettings Message  is : "+check);
		String strActual = SaveSettingsMessage.getText();
		Assert.assertEquals("Your new profile has been saved", strActual, "Confirmation message exists");		
		
	}

}
