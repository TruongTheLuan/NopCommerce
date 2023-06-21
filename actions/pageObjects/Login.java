package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class Login extends AbstractPage {
	private WebDriver driver;
	AbstractTest abstractTest = new AbstractTest();

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPage() {
		waitForElementVisibility(driver, HomePageUI.LoginPage);
		clickToElement(driver, HomePageUI.LoginPage);
		abstractTest.verifyTitleIsCorrect(driver, "nopCommerce demo store. Login");
	}

	public void inputEmail(String value) {
		waitForElementVisibility(driver, LoginPageUI.txtEmail);
		clearText(driver, LoginPageUI.txtEmail);
		setText(driver, LoginPageUI.txtEmail, value);
	}

	public void inputPassword(String value) {
		waitForElementVisibility(driver, LoginPageUI.txtPassword);
		clearText(driver, LoginPageUI.txtPassword);
		setText(driver, LoginPageUI.txtPassword, value);
	}

	public void clickOnLoginButton() {
		waitForElementVisibility(driver, LoginPageUI.btnLogin);
		clickToElement(driver, LoginPageUI.btnLogin);
	}

	public void verifyEmailMsg() {
		waitForElementVisibility(driver, LoginPageUI.email_Error);
		abstractTest.verifyMsgIsDisplayed(driver, LoginPageUI.email_Error);
	}

	public void verifyMsgError() {
		waitForElementVisibility(driver, LoginPageUI.msg_Error);
		abstractTest.verifyMsgIsDisplayed(driver, LoginPageUI.msg_Error);
	}

	public void verifyHomePageIsDisplayed() {
		abstractTest.verifyTitleIsCorrect(driver, "nopCommerce demo store");
	}
}
