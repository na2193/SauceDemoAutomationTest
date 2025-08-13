package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.ProductPageElements;
import utils.CSVReader;

public class ProductsPage extends BasePage {
	
	@FindBy(id=ProductPageElements.add_backpack_button)
	WebElement backPackButton;
	
	@FindBy(id=ProductPageElements.add_bikelight_button)
	WebElement bikeLightButton;
	
	@FindBy(id=ProductPageElements.add_bolt_tshirt_button)
	WebElement boltShirtButton;
	
	@FindBy(id=ProductPageElements.add_fleece_jacket_button)
	WebElement fleeceJacketButton;
	
	@FindBy(id=ProductPageElements.add_onesie_button)
	WebElement onesieButton;
	
	@FindBy(id=ProductPageElements.add_testallthings_shirt)
	WebElement testAllThingsButton; 
	
	@FindBy(xpath=ProductPageElements.cart_icon)
	WebElement cartIconButton;
	
	@FindBy(xpath=ProductPageElements.sauce_labs_backback_title)
	WebElement sauceLabsBackpackTitle;
	

	public ProductsPage(WebDriver driver, CSVReader data, ExtentTest logger) {
		super(driver, data, logger);
	}
	
	public void addProductsToCart() {
		logger.log(Status.INFO, "Adding all items to cart and validating");
		backPackButton.click();
		bikeLightButton.click();
		boltShirtButton.click();
		fleeceJacketButton.click();
		onesieButton.click();
		testAllThingsButton.click();
		cartIconButton.click();
	}

	public void validateSauceLabsBackpackTitle() {
		String title_actualText = sauceLabsBackpackTitle.getText();
		String title_expectedText = data.get("sauce_labs_title");
		compareText(title_actualText, title_expectedText);
		
	}
	
	
	
}
