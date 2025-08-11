package pages;

import java.time.Duration;

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
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	public BasePage(WebDriver driver, CSVReader data, ExtentTest logger) {
        this.driver = driver;
        this.data = data;
        this.logger= logger;
        PageFactory.initElements(driver, this);
    }
	
	public void compareText(String actualText, String expectedText) {
		if (actualText.equals(expectedText)) {
			logger.log(Status.PASS, "Expected Text -> " + expectedText + " matches Actual Text - > " + actualText);
		}
		else {
			logger.log(Status.FAIL, "Expected Text -> " + expectedText + " DOES NOT match Actual Text - > " + actualText);
		}
	}
	
	public WebElement waitForElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
