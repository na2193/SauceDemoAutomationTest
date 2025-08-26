package pageObjects;

public interface ProductPageElements {

	String add_backpack_button = "add-to-cart-sauce-labs-backpack";
	String add_bikelight_button = "add-to-cart-sauce-labs-bike-light";
	String add_bolt_tshirt_button = "add-to-cart-sauce-labs-bolt-t-shirt";
	String add_fleece_jacket_button = "add-to-cart-sauce-labs-fleece-jacket";
	String add_onesie_button = "add-to-cart-sauce-labs-onesie";
	String add_testallthings_shirt = "add-to-cart-test.allthethings()-t-shirt-(red)";
	String cart_icon = "//*[@id='shopping_cart_container']/a";
	String logout_button = "logout_sidebar_link";
	String menu_button = "//button[text()='Open Menu']";
	String sauce_labs_backback_title = "//div[text()='Sauce Labs Backpack']";
	String bolt_t_shirt_title = "//div[text()='Sauce Labs Bolt T-Shirt']";
	String fleece_jacket_title = "//div[text()='Sauce Labs Fleece Jacket']";
	String test_all_things_title = "//div[text()='Test.allTheThings() T-Shirt (Red)']";
	String bike_light_title = "//div[text()='Sauce Labs Bike Light']";
	String onesie_title = "//div[text()='Sauce Labs Onesie']";
	String continue_shopping_button = "/html/body/div/div/div/div[2]/div/div[2]/button[1]";
	String remove_saucelabs_onesie = "remove-sauce-labs-onesie";
	String remove_saucelabs_bike = "remove-sauce-labs-bike-light";
	String remove_saucelabs_backpack = "remove-sauce-labs-backpack";
	String remove_saucelabs_bolt = "remove-sauce-labs-bolt-t-shirt";
	String remove_saucelabs_fleece = "remove-sauce-labs-fleece-jacket";
	String remove_saucelabs_testallthings = "remove-test.allthethings()-t-shirt-(red)";
	String cart_badge = "//a[@data-test='shopping-cart-link']/span"; // new expath
	
	
	
	// I was going to do "cart bad shows 1" all the way until 6 but when i copy 
	// the xpath its all the same so is this fine even though the badge changes numbers
	// after adding things to cart
}
