package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void validateErrorMessageForNoInput() throws InterruptedException {
		logger.log(Status.INFO, "Testing login test");
		LoginPage loginPage = new LoginPage(getDriver(), data, logger);
		//loginPage.login();
		loginPage.validateNoCredentialsError();
		loginPage.validatePswdErrMsg();
		loginPage.validateUserAndPswdErrMsg();
		loginPage.validateSuccessLogin();
		Thread.sleep(5000);
	}
}
