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
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SignUpTests {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private SignUpPOM signUpPOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		signUpPOM = new SignUpPOM(driver);	
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
	
	// Test for Sign Up
	@Test
	public void SignUpTest() {
		// Clicking on signUp
		signUpPOM.clickonSignUp();
		// entering First name
		signUpPOM.sendFirstname("Saranya");
		// entering lastname
		signUpPOM.sendLastname("Parvathaneni");
		// entering email
		signUpPOM.sendEmail("parchowd@in.ibm.com");
		// entering username
		signUpPOM.sendUsername("SaranyaP");
		// entering password
		signUpPOM.sendPassword("sarath");
		// confirming password
		signUpPOM.sendConfirmPassword("sarath");
		// enetering phone number
		signUpPOM.sendPhone("1122334455");
		// seslecting language
		signUpPOM.selectLanguage("English");
		// selecting option student
		signUpPOM.selectStudentOption();
		// clicking on register
		signUpPOM.clickonRegister();	
		// checking the confirmation message
		signUpPOM.checkConfirmationMessage();	
		// Capturing screenshot
		screenShot.captureScreenShot("First");
	}

}
