package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbstractTest extends AbstractPage {
	public void verifyTitleIsCorrect(WebDriver driver, String Expected) {
		Assert.assertEquals(getTitle(driver), Expected);
	}

	public void verifyMsgIsCorrect(WebDriver driver, By locator, String Expected) {
		Assert.assertEquals(getText(driver, locator), Expected);
	}

	public void verifyMsgIsDisplayed(WebDriver driver, By locator) {
		Assert.assertEquals(isDisplayed(driver, locator), true);
	}
}
