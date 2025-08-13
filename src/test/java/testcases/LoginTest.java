package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTest extends BaseTest {
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(getDriver(), data, logger);
		
		logger.log(Status.INFO, "Validating error message when no credentials are entered");
		loginPage.validateNoCredentialsError();
		
		logger.log(Status.INFO, "Validating error message when no password is entered");
		loginPage.validatePswdErrMsg();
		
		logger.log(Status.INFO, "Validating error message when invalid username and password are entered");
		loginPage.validateUserAndPswdErrMsg();
		
		logger.log(Status.INFO, "Validating success login with standard user");
		loginPage.validateSuccessLogin_StandardUser();
		
		logger.log(Status.INFO,"Logging out of account");
		LogoutPage logoutPage = new LogoutPage(getDriver(), data, logger);
		logoutPage.logOut();
		
		Thread.sleep(5000);
		
		logger.log(Status.INFO, "Validating success login with problem user");
		loginPage.validateSuccessLogin_ProblemUser();
		Thread.sleep(5000);
		logoutPage.logOut();
		
		
		logger.log(Status.INFO, "Validating success login with locked out user");
		loginPage.validateSuccessLogin_lockedOutUser();
		Thread.sleep(5000);
		logoutPage.logOut();
		
		logger.log(Status.INFO, "Validating success login with performance glitch user");
		loginPage.validateSuccessLogin_performance_glitch_user();
		Thread.sleep(5000);
		logoutPage.logOut();
		
		logger.log(Status.INFO, "Validating success login with error user");
		loginPage.validateSuccessLogin_error_user();
		Thread.sleep(5000);
		logoutPage.logOut();
		
		logger.log(Status.INFO, "Validating success login with visual user");
		loginPage.validateSuccessLogin_visual_user();
		Thread.sleep(5000);
		logoutPage.logOut();
		
		// Need to first logout
		// Then login with another username and password
		// Then logout and do the same for all the other username and password
	}
}
