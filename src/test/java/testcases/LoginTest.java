package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(getDriver(), data, logger);
		
		logger.log(Status.INFO, "Validating error message when no credentials are entered");
		loginPage.validateNoCredentialsError();
		
		logger.log(Status.INFO, "Validating error message when no password is entered");
		loginPage.validatePswdErrMsg();
		
		logger.log(Status.INFO, "Validating error message when invalid username and password are entered");
		loginPage.validateUserAndPswdErrMsg();
		
		logger.log(Status.INFO, "Validating success login with standard user");
		loginPage.validateSuccessLogin_StandardUser();
		
		// Need to first logout
		// Then login with another username and password
		// Then logout and do the same for all the other username and password
	}
}
