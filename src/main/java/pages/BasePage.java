package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CSVReader;

public abstract class BasePage {
	protected WebDriver driver;
	protected CSVReader data;
	protected ExtentTest logger;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver, CSVReader data, ExtentTest logger) {
        this.driver = driver;
        this.data = data;
        this.logger= logger;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
	
	// This functions compares the text and either passes or fails
	public void compareText(String actualText, String expectedText) {
		if (actualText.equals(expectedText)) {
			logger.log(Status.PASS, "Expected Text -> " + expectedText + " matches Actual Text - > " + actualText);
		}
		else {
			logger.log(Status.FAIL, "Expected Text -> " + expectedText + " DOES NOT match Actual Text - > " + actualText);
		}
	}
	
	// This function waits for an element to be visible
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// This function return true/false if an element is present on the page
	public boolean isElementPresent(WebElement element) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return true;
	    } 
	    catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	} 
	
	// This functions waits for a period of seconds, use this instead of Thread.sleep
	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	// This function refreshes the page
	public void refreshPage() {
		driver.navigate().refresh();
	}
}
