package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.CSVReader;

public abstract class BasePage {
	protected WebDriver driver;
	protected CSVReader data;
	
	public BasePage(WebDriver driver, CSVReader data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }
}
