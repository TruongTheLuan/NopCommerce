package com.NopCommerce.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.Login;

public class VerifyLogin {

	WebDriver driver;
	public AbstractTest abstractTest;
	public Login login;
	String geckodriver = "/Users/geotech/Downloads/Setup-Mac/chromedriver_mac_arm64/chromedriver";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", geckodriver);
		driver = new ChromeDriver();
		abstractTest = new AbstractTest();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		login = new Login(driver);
	}

	@Test
	public void TC01_VerifyNavigateToLoginPage() {
		login.openLoginPage();
	}

	@Test
	public void TC02_VerifyLoginWithEmptyData() {
		login.inputEmail("");
		login.inputPassword("");
		login.clickOnLoginButton();
		login.verifyEmailMsg();
	}

	@Test
	public void TC03_VerifyWithInvalidEmail() {
		login.inputEmail("");
		login.inputPassword("");
		login.clickOnLoginButton();
		login.verifyEmailMsg();
	}

	@Test
	public void TC04_VerifyLoginWithWrongPassword() {
		login.inputEmail("");
		login.inputPassword("");
		login.clickOnLoginButton();
		login.verifyMsgError();
	}

	@Test
	public void TC05_VerifyLoginSuccess() {
		login.inputEmail("automationfc.vn+3@gmail.com");
		login.inputPassword("automationfc");
		login.clickOnLoginButton();
		login.verifyHomePageIsDisplayed();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
