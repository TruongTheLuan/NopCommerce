package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	WebDriver driver;
	JavascriptExecutor jE;
	Actions act;
	WebDriverWait waitExplicit;
	String geckodriver = "/Users/geotech/Downloads/Setup-Mac/geckodriver";

	public void initPage() {
		System.setProperty("webdriver.gecko.driver", geckodriver);
		driver = new ChromeDriver();
		jE = (JavascriptExecutor) driver;
		act = new Actions(driver);
		waitExplicit = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	public void waitForElementToAppear(By locator) {
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementToDisappear(By locator) {
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForTextToDisappear(By locator, String text) {
		waitExplicit.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	}

	public void waitForElementVisible(By by, int timeout) {
		try {
			WebElement element = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void waitForElementClickable(By by, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public String getURL() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public void waitForElementClickable(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickToElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setText(By by, String text) {
		try {
			WebElement element = driver.findElement(by);
			element.sendKeys(text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isDisplayed(By by) {
		try {
			WebElement element = driver.findElement(by);
			return element.isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean isElementSelected(By by) {
		boolean flag = false;
		try {
			driver.findElement(by).isSelected();
			flag = true;
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public void cleanUp() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
