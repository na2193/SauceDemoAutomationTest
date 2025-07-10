package pages;

import org.openqa.selenium.By;

import base.BaseTest;
import pageObjects.LoginPageElements;

public class LoginPage extends BaseTest{
	
	public void login() {
		BaseTest.driver.findElement(By.id(LoginPageElements.input_username)).sendKeys("ABC");
	}
}
