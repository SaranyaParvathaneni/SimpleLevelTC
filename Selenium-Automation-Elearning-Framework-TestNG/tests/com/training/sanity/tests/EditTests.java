package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.EditPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditPOM editPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);	
		editPOM = new EditPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		System.out.println("Navigated to "+baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("After Method");
		Thread.sleep(1000);
		driver.quit();
	}
	
	// test for editing password
	@Test
	public void EditTest() {
		// entering username
		loginPOM.sendUserName("SaranyaP");
		// entering password
		loginPOM.sendPassword("sarath");
		// clicking on login
		loginPOM.clickLoginBtn();
		//clicking on edit profile
		editPOM.clickonEditProfile();
		// entering the existing password
		editPOM.sendProfilePassword("sarath");
		// entering the new password
		editPOM.sendNewPassword("sarath6571");
		// confirming the new password
		editPOM.sendConfirmNewPassword("sarath6571");
		// clicking on save changes
		editPOM.clickonSaveChanges();
		// checking the save settings message
		editPOM.SaveSettingsMessage();
		// capturing the screenshot
		screenShot.captureScreenShot("Third");		
	}

}
