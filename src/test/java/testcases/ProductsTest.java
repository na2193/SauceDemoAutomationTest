package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{
  @Test
  public void test() throws InterruptedException {
	  ProductsPage productsPage = new ProductsPage(getDriver(), data, logger);
	  LoginPage loginPage = new LoginPage(getDriver(), data, logger);
	  loginPage.validateSuccessLogin_StandardUser(); // temp
	  logger.log(Status.INFO, "Adding all products to cart");
	  productsPage.addProductsToCart();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Sauce Labs Backpack");
	  productsPage.validateSauceLabsBackpackTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Sauce Labs Bolt T-Shirt");
	  productsPage.validateSauceLabsBoltTshirtTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Sauce Labs Fleece Jacket");
	  productsPage.validateSauceLabsFleeceJacketTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Test.allTheThings() T-Shirt (Red)");
	  productsPage.validateTestAllThingsTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Sauce Labs Bike Light");
	  productsPage.validateBikeLightTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Validating title is Sauce Labs Onesie");
	  productsPage.validateOnesieTitle();
	  Thread.sleep(5000);
	  logger.log(Status.INFO, "Clicking on Continue Shopping button");
	  productsPage.clickingOnContinueShopping();
	  Thread.sleep(5000);
	  
  }
}
