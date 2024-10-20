package Application.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Application.AbstractComponent.AbstractComponents;

public class Confimationpage extends AbstractComponents {
	
	  WebDriver driver;
//constructor to call the driver from the tests
//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public Confimationpage(WebDriver driver) {
		
		//super keywords helps to send the variables from child class to the parent class
		super(driver);
		//intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		/*initElements method is used by page factory model to intialize 
		the driver method by FindBy annotation to construct the findby element*/
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmmessage;
	
	//Action
	public String verifyConfirmationMessage() {
	return confirmmessage.getText();
	}
}
