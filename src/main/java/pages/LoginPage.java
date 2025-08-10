package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageElements;
import utils.CSVReader;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver, CSVReader data) {
		super(driver, data);
	}

	public void login() {
		driver.findElement(By.id(LoginPageElements.input_username)).sendKeys(data.get("standard_user_name"));
		driver.findElement(By.id(LoginPageElements.input_password)).sendKeys(data.get("login_password"));
		
	}
}
