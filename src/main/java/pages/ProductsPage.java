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

	@FindBy(xpath=ProductPageElements.bolt_t_shirt_title)
	WebElement boltTshirtTitle;

	@FindBy(xpath=ProductPageElements.fleece_jacket_title)
	WebElement fleeceTitle;

	@FindBy(xpath=ProductPageElements.test_all_things_title)
	WebElement testAllThingsTitle;

	@FindBy(xpath=ProductPageElements.bike_light_title)
	WebElement bikeLightTitle;

	@FindBy(xpath=ProductPageElements.onesie_title)
	WebElement onesieTitle;

	@FindBy(id=ProductPageElements.continue_shopping_button)
	WebElement continueShoppingButton;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_onesie)
	WebElement removeOnesie;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_bike)
	WebElement removeBikeLight;
	
	
	
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

	public void validateSauceLabsBoltTshirtTitle() {
		String title_actualText = boltTshirtTitle.getText();
		String title_expectedText = data.get("bolt_shirt_title");
		compareText(title_actualText, title_expectedText);
	}

	public void validateSauceLabsFleeceJacketTitle() {
		String title_actualText = fleeceTitle.getText();
		String title_expectedText = data.get("sauce_labs_fleece_title");
		compareText(title_actualText, title_expectedText);
	}
	
	
	public void validateTestAllThingsTitle() {
		String title_actualText = testAllThingsTitle.getText();
		String title_expectedText = data.get("test_all_things_title");
		compareText(title_actualText, title_expectedText);
	}
	
	
	public void validateBikeLightTitle() {
		String title_actualText = bikeLightTitle.getText();
		String title_expectedText = data.get("sauce_labs_bike_title");
		compareText(title_actualText, title_expectedText);
		
	}
	
	public void validateOnesieTitle() {
		String title_actualText = onesieTitle.getText();
		String title_expectedText = data.get("sauce_labs_onesie_title");
		compareText(title_actualText, title_expectedText);

	}
	
	public void clickingOnContinueShopping() {
		continueShoppingButton.click();
		removeOnesie.click();
		removeBikeLight.click();
	}
	
	public void verifyOnlyFourItemsInCart() {
		
	}
	
}
