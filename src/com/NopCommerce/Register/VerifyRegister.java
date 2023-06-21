package com.NopCommerce.Register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.Register;

public class VerifyRegister {
	WebDriver driver;
	public AbstractTest abstractTest;
	public Register register;
	String geckodriver = "/Users/geotech/Downloads/Setup-Mac/chromedriver_mac_arm64/chromedriver";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", geckodriver);
		driver = new ChromeDriver();
		abstractTest = new AbstractTest();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		register = new Register(driver);
	}

	@Test
	public void TC01_VerifyNavigateToRegisterPage() {
		register.openRegisterPage();
	}

	@Test
	public void TC02_VerifyRegisterWithEmptyData() {
		register.clickOnRegisterButton();
		register.verifyFirstNameMsg();
		register.verifyLastNameMsg();
		register.verifyEmailMsg();
		register.verifyPasswordMsg();
		register.verifyConfirmPasswordMsg();
	}

	@Test
	public void TC03_VerifyRegisterWithWrongEmail() {
		register.inputEmail("");
		register.verifyEmailMsg();
	}

	@Test
	public void TC04_VerifyRegisterWithPasswordLessThan6Chars() {
		register.inputFirstName("");
		register.inputLastName("");
		register.inputEmail("");
		register.inputPassword("");
		register.inputConfirmPassword("");
		register.clickOnRegisterButton();
		register.verifyPasswordErrorMsgDisplayed();
	}

	@Test
	public void TC05_VerifyRegisterWithIncorrectConfirmPassword() {
		register.inputFirstName("");
		register.inputLastName("");
		register.inputEmail("");
		register.inputPassword("");
		register.inputConfirmPassword("");
		register.clickOnRegisterButton();
		register.verifyConfirmPasswordErrorMsgDisplayed();
	}

	@Test
	public void TC06_VerifyRegisterSuccess() {
		register.inputFirstName("");
		register.inputLastName("");
		register.inputEmail("");
		register.inputPassword("");
		register.inputConfirmPassword("");
		register.clickOnRegisterButton();
		register.verifyResultMsgDisplayed();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
