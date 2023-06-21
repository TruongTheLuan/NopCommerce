package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	WebDriver driver;
	WebDriverWait waitExplicit;

	public void waitForElementVisibility(WebDriver driver, By locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean isSelected(WebDriver driver, By locator) {
		if (driver.findElement(locator).isSelected()) {
			return true;
		}
		return false;
	}

	public boolean isEnabled(WebDriver driver, By locator) {
		if (driver.findElement(locator).isEnabled()) {
			return true;
		}
		return false;
	}

	public boolean isDisplayed(WebDriver driver, By locator) {
		if (driver.findElement(locator).isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getText(WebDriver driver, By locator) {
		return driver.findElement(locator).getText();
	}

	public void clickToElement(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}

	public void clearText(WebDriver driver, By locator) {
		driver.findElement(locator).clear();
	}

	public void setText(WebDriver driver, By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public void selectByVisibleTextInDropDown(WebDriver driver, By locator, String value) {
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByVisibleText(value);
	}

	public void selectByValueInDropDown(WebDriver driver, By locator, String value) {
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByValue(value);
	}

	public void selectByIndexInDropDown(WebDriver driver, By locator, int index) {
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByIndex(index);
	}

}
