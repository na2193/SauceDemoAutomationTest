package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.ProductPageElements;
import utils.CSVReader;

public class LogoutPage extends BasePage{

	@FindBy(xpath=ProductPageElements.menu_button)
	WebElement menuButton;
	
	@FindBy(id=ProductPageElements.logout_button)
	WebElement logoutButton;
	
	
	public LogoutPage(WebDriver driver, CSVReader data, ExtentTest logger) {
		super(driver, data, logger);
		
		
	}
	
	
	
	
	public void logOut() {
		logger.log(Status.INFO,"Logging out of account");
		waitForElementVisible(menuButton);
		menuButton.click();
		waitForElementVisible(logoutButton);
		logoutButton.click();
		
	}
	
	
	
	
}
