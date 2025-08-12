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
	
	@FindBy(xpath=LoginPageElements.products_page)
	WebElement validLogin_productsPage;
	
	public LoginPage(WebDriver driver, CSVReader data, ExtentTest logger) {
		super(driver, data, logger);
	}

	public void validateNoCredentialsError() {
		waitForElementVisible(userName);
		login.click();
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = data.get("username_required_err_msg");
		compareText(errmsg_actualText, errmsg_expectedText);
	}

	public void validatePswdErrMsg() {
		userName.sendKeys(data.get("invalid_username"));
		login.click();
		
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = data.get("password_required_err_msg");
		compareText(errmsg_actualText, errmsg_expectedText);
		
		userName.clear();
		password.clear();
	}

	
	public void validateUserAndPswdErrMsg() {
		userName.sendKeys(data.get("invalid_username"));
		password.sendKeys(data.get("invalid_password"));
		login.click();
		
		String errmsg_actualText = noCredentialsErrMsg.getText();
		String errmsg_expectedText = data.get("invalid_username_pass_err_msg");
		compareText(errmsg_actualText, errmsg_expectedText);
		
		userName.clear();
		password.clear();
		
	}
	
	public void validateSuccessLogin_StandardUser() {
		refreshPage();
		waitForElementVisible(userName);
		userName.sendKeys(data.get("standard_user_name"));
		password.sendKeys(data.get("login_password"));
		login.click();
		wait(2);
		
		if(isElementPresent(validLogin_productsPage)) {
			logger.log(Status.PASS, "Successfully logged in!");
		}
		else {
			logger.log(Status.FAIL, "Failed to log in!");
		}
	}
	
	// Add couple more function to login with different usernames and password
	// Will need to have a function to log out

}
