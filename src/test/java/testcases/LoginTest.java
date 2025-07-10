package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void validateErrorMessageForNoInput() {
		logger.log(Status.INFO, "Testing login test");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login();
	}
}
