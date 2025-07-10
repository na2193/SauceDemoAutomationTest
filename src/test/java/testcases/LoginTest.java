package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void validateErrorMessageForNoInput() {
		logger.log(Status.INFO, "Testing login test");
		loginPage.login();
	}
}
