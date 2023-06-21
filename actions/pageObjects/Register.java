package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class Register extends AbstractPage {
	private WebDriver driver;
	AbstractTest abstractTest = new AbstractTest();

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	public void openRegisterPage() {
		waitForElementVisibility(driver, HomePageUI.RegisterPage);
		clickToElement(driver, HomePageUI.RegisterPage);
		abstractTest.verifyTitleIsCorrect(driver, "nopCommerce demo store. Register");
	}

	public void inputFirstName(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtFirstName);
		clearText(driver, RegisterPageUI.txtFirstName);
		setText(driver, RegisterPageUI.txtFirstName, value);
	}

	public void inputLastName(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtLastName);
		clearText(driver, RegisterPageUI.txtLastName);
		setText(driver, RegisterPageUI.txtLastName, value);
	}

	public void inputEmail(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtEmail);
		clearText(driver, RegisterPageUI.txtEmail);
		setText(driver, RegisterPageUI.txtEmail, value);
	}

	public void selectDoBDay(String value) {
		selectByVisibleTextInDropDown(driver, RegisterPageUI.drpDateOfBirthDay, value);
	}

	public void selectDoBMonth(String value) {
		selectByVisibleTextInDropDown(driver, RegisterPageUI.drpDateOfBirthMonth, value);
	}

	public void selectDoBYear(String value) {
		selectByVisibleTextInDropDown(driver, RegisterPageUI.drpDateOfBirthYear, value);
	}

	public void inputCompany(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtCompany);
		clearText(driver, RegisterPageUI.txtCompany);
		setText(driver, RegisterPageUI.txtCompany, value);
	}

	public void inputPassword(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtPwd);
		clearText(driver, RegisterPageUI.txtPwd);
		setText(driver, RegisterPageUI.txtPwd, value);
	}

	public void inputConfirmPassword(String value) {
		waitForElementVisibility(driver, RegisterPageUI.txtConfirmPwd);
		clearText(driver, RegisterPageUI.txtConfirmPwd);
		setText(driver, RegisterPageUI.txtConfirmPwd, value);
	}

	public void clickOnRegisterButton() {
		waitForElementVisibility(driver, RegisterPageUI.btnRegister);
		clickToElement(driver, RegisterPageUI.btnRegister);
	}

	public void verifyFirstNameMsg() {
		waitForElementVisibility(driver, RegisterPageUI.firstName_Error);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.firstName_Error);
	}

	public void verifyLastNameMsg() {
		waitForElementVisibility(driver, RegisterPageUI.lastName_Error);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.lastName_Error);
	}

	public void verifyEmailMsg() {
		waitForElementVisibility(driver, RegisterPageUI.email_Error);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.email_Error);
	}

	public void verifyPasswordMsg() {
		waitForElementVisibility(driver, RegisterPageUI.password_Error);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.password_Error);
	}

	public void verifyConfirmPasswordMsg() {
		waitForElementVisibility(driver, RegisterPageUI.confirmPassword_Error);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.confirmPassword_Error);
	}

	public void verifyPasswordErrorMsgDisplayed() {
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.password_Error);
	}

	public void verifyConfirmPasswordErrorMsgDisplayed() {
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.confirmPassword_Error);
	}

	public void verifyResultMsgDisplayed() {
		waitForElementVisibility(driver, RegisterPageUI.divResult);
		abstractTest.verifyMsgIsDisplayed(driver, RegisterPageUI.divResult);
	}
}
