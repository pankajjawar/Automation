package Application.Tests;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Application.BaseTestComponents.BaseTest;
import Application.pageobjectmodel.CartPage;
import Application.pageobjectmodel.CheckoutPage;
import Application.pageobjectmodel.Confimationpage;
import Application.pageobjectmodel.OrderPage;
import Application.pageobjectmodel.ProductCatalog;

public class SubmitOrderTest extends BaseTest  {
	
	String productName = "ADIDAS ORIGINAL";

 @Test
 public void submitOrder() throws IOException, InterruptedException
 {
		// TODO Auto-generated method stub
		
		String CountryName = "India";
		ProductCatalog productcatalog =landingPage.loginApplication("pankajjawar2024@gmail.com","Pankajjawar2024@gmail.com");
		List<WebElement> products = productcatalog.getProductlist();
		productcatalog.addProductToCart(productName);
		CartPage cartpage =productcatalog.goToCartPage();//Inheritance childclass has access to parent class methods
		Boolean match = cartpage.verifyProductDisplay(productName);
	    Assert.assertTrue(match);
	    CheckoutPage checkoutpage = cartpage.checkOut();
	    checkoutpage.selectCountry(CountryName);
	    Confimationpage confimationpage = checkoutpage.SubmitOrder();
	    String confirmMessage = confimationpage.verifyConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    System.out.println(confirmMessage);
	}

 
 @Test(dependsOnMethods= {"submitOrder"})
 public void validateOrderPage() throws IOException, InterruptedException
 {
		landingPage.loginApplication("pankajjawar2024@gmail.com","Pankajjawar2024@gmail.com");
		OrderPage orderpage = landingPage.goToOrderPage();
		System.out.println(orderpage.verifyOrderDisplay(productName));
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
	}
}
