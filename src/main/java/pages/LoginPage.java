package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import pageObjects.LoginPageElements;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login() {
		//BaseTest.driver.findElement(By.id(LoginPageElements.input_username)).sendKeys("ABC");
		driver.findElement(By.id(LoginPageElements.input_username)).sendKeys("ABC");
	}
}
