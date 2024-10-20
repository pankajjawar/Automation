package Application.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Application.AbstractComponent.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	  WebDriver driver;
//constructor to call the driver from the tests
//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public CartPage(WebDriver driver) {
		//super keywords helps to send the variables from child class to the parent class
		super(driver);
		//intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		/*initElements method is used by page factory model to intialize 
		the driver method by FindBy annotation to construct the findby element*/
	}
		
   @FindBy(css=".cartSection h3")
   List <WebElement> cartProducts;
   
   @FindBy(css=".totalRow button")
   WebElement checkOut;
   //Action
   public Boolean verifyProductDisplay(String productName) {
   Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
   return match;
   }
   
   //Action
   public CheckoutPage checkOut() {
	   	checkOut.click();
	   	CheckoutPage checkoutpage= new CheckoutPage(driver);
	   	return checkoutpage;
   }

}
