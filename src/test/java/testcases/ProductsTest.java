package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{
  @Test
  public void test() throws InterruptedException {
	  ProductsPage productsPage = new ProductsPage(getDriver(), data, logger);
	  LoginPage loginPage = new LoginPage(getDriver(), data, logger);
	  loginPage.validateSuccessLogin(); // temp
	  productsPage.addProductsToCart();
  }
}
