package Application.pageobjectmodel;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Application.AbstractComponent.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	  WebDriver driver;
//constructor to call the driver from the tests
//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public OrderPage(WebDriver driver) {
		//super keywords helps to send the variables from child class to the parent class
		super(driver);
		//intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		/*initElements method is used by page factory model to intialize 
		the driver method by FindBy annotation to construct the findby element*/
	}
	
	   @FindBy(css="tr td:nth-child(3)")
	   List <WebElement> orderedproducts;

   //Action
   public Boolean verifyOrderDisplay(String productName) {
   Boolean match = orderedproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
   return match;
   }
}
