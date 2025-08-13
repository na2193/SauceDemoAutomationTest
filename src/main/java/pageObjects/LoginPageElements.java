package pageObjects;

public interface LoginPageElements {
	String input_username = "user-name";
	String input_password = "password";
	String input_login = "//*[@id='login-button']";
	String nocredentials_errormessage = "//*[@id='login_button_container']/div/form/div[3]/h3";
	String products_page = "//span[text()='Products']";
	
}
