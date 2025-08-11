package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.LoginPageElements;
import utils.CSVReader;

public class LoginPage extends BasePage{
	
	@FindBy(id=LoginPageElements.input_username)
	WebElement userName;
	
	@FindBy(id=LoginPageElements.input_password)
	WebElement password;
	
	@FindBy(xpath=LoginPageElements.input_login)
	WebElement login;
	
	@FindBy(xpath=LoginPageElements.nocredentials_errormessage)
	WebElement noCredentialsErrMsg;
	
//	@FindBy(xpath=LoginPageElements.saucelabs_backpack)
//	WebElement validLogin;
	
	public LoginPage(WebDriver driver, CSVReader data, ExtentTest logger) {
		super(driver, data, logger);
	}

	public void validateNoCredentialsError() {
		login.click();
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = "Epic sadface: Username is required";
		logger.log(Status.INFO, "Validating error message when no credentials are entered");
		compareText(errmsg_actualText, errmsg_expectedText);
	}

	public void validatePswdErrMsg() {
		userName.sendKeys("abc");
		login.click();
		
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = "Epic sadface: Password is required";
		compareText(errmsg_actualText, errmsg_expectedText);
		
		userName.clear();
		password.clear();
	}

	
	public void validateUserAndPswdErrMsg() {
		userName.sendKeys("abc");
		password.sendKeys("nn");
		login.click();
		
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = "Epic sadface: Username and password do not match any user in this service";
		compareText(errmsg_actualText, errmsg_expectedText);
		
		userName.clear();
		password.clear();
		
	}
	
	public void validateSuccessLogin() throws InterruptedException {
		Thread.sleep(5000);
		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
		Thread.sleep(3000);
		//verifyElementPrsnt(validLogin);
	}

}
