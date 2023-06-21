package pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static final By txtEmail = By.id("Email");
	public static final By txtPassword = By.id("Password");
	public static final By btnLogin = By.xpath("//button[text()='Log in']");
	public static final By email_Error = By.id("Email-error");
	public static final By msg_Error = By.cssSelector(".message-error");
}
