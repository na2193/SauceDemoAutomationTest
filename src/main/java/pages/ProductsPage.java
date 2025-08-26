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

	@FindBy(xpath=ProductPageElements.continue_shopping_button)
	WebElement continueShoppingButton;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_onesie)
	WebElement removeOnesie;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_bike)
	WebElement removeBikeLight;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_backpack)
	WebElement removeBackpack;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_bolt)
	WebElement removeBolt;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_fleece)
	WebElement removeFleece;
	
	@FindBy(id=ProductPageElements.remove_saucelabs_testallthings)
	WebElement removeTestAllThings;
	
	@FindBy(xpath=ProductPageElements.cart_badge)	
	WebElement cartBadge;
	
	
	
	
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
		// because the button is all the way in the bottom of the page, you need to scroll, look at the function
		scrollToElement(continueShoppingButton);
		continueShoppingButton.click();
		//removeOnesie.click();// why is this here, it's already on line 149
		//removeBikeLight.click(); // same for this, line 151 so it's double clicking
	}
	
	// this works now because line 142 and 143 is commneded out
	public void verifyOnlyFourItemsInCart() {
		// Step 1: Removed Onesie and BikeLight
		removeOnesie.click();
		removeBikeLight.click();
				
		// Step 2: Click on Cart Icon
		scrollToElement(cartIconButton);
		cartIconButton.click();
		
		// Step 3: Verify 4 items are only in the cart
		// Call the 4 function items above that are left in the cart
		// example: Sauce Lab backpack is left in the cart
		// so call the function: validateSauceLabsBackpackTitle()	
		
		validateSauceLabsBackpackTitle();
		validateSauceLabsBoltTshirtTitle();
	    validateSauceLabsFleeceJacketTitle();
	    validateTestAllThingsTitle();
	}
	
	
	public void removeAllItemsInCart() {
		removeBackpack.click();
		removeBolt.click();
		removeFleece.click();
		removeTestAllThings.click();
		scrollToElement(continueShoppingButton);
		continueShoppingButton.click();
	}
	
	// This function verifies how many items in cart by getting the text thats in the html
	public void verifyNumberOfItemsInCart(String numberOfItems) {
		String cartBadgeExpectedText = cartBadge.getText();
		compareText(numberOfItems, cartBadgeExpectedText);
	}
	
	public void verifyCartShowsOne() {
		backPackButton.click();
		// call this function and pass in how many numbers in string to verify
		verifyNumberOfItemsInCart("1");
	}
	
	// Do the same for all the button below
	public void verifyCartShowsTwo() {
		bikeLightButton.click();
	}
	
	public void verifyCartShowsThree() {
		boltShirtButton.click();
	
	}
	
	public void verifyCartShowsFour() {
		fleeceJacketButton.click();
	}
	
	public void verifyCartShowsFive() {
		onesieButton.click();
	}
	
	public void verifyCartShowsSix() {
		testAllThingsButton.click();	
	}
		
	// I don't know how to verify that the badge shows 1-6 after adding each time
	
	// when we did "validating the titles" am i supposed to do the same like actual text and expected text
	
}
