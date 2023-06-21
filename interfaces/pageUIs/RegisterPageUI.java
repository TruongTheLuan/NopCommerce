package pageUIs;

import org.openqa.selenium.By;

public class RegisterPageUI {
	public static final By rdoMale = By.xpath("//input[@value='M']");
	public static final By rdoFemale = By.xpath("//input[@value='F']");
	public static final By txtFirstName = By.id("FirstName");
	public static final By txtLastName = By.id("LastName");
	public static final By drpDateOfBirthDay = By.name("DateOfBirthDay");
	public static final By drpDateOfBirthMonth = By.name("DateOfBirthMonth");
	public static final By drpDateOfBirthYear = By.name("DateOfBirthYear");
	public static final By txtEmail = By.id("Email");
	public static final By txtCompany = By.id("Company");
	public static final By cbNewsletter = By.id("Newsletter");
	public static final By txtPwd = By.id("Password");
	public static final By txtConfirmPwd = By.id("ConfirmPassword");
	public static final By btnRegister = By.xpath("//button[text()='Register']");
	public static final By divResult = By.className("result");

	public static final By firstName_Error = By.id("FirstName-error");
	public static final By lastName_Error = By.id("LastName-error");
	public static final By email_Error = By.id("Email-error");
	public static final By password_Error = By.id("Password-error");
	public static final By confirmPassword_Error = By.id("ConfirmPassword-error");
}
