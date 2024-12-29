package Application.pageobjectmodel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Application.AbstractComponent.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
		
	WebDriver driver;
	//constructor to call the driver from the tests
	//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public CheckoutPage(WebDriver driver) {
			//super keywords helps to send the variables from child class to the parent class
			super(driver);
			//intialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			/*initElements method is used by page factory model to intialize 
			the driver method by FindBy annotation to construct the findby element*/
		}
		
		@FindBy(css="[placeholder='Select Country']")
		WebElement Country;
		
		@FindBy(css=".action__submit")
		WebElement submitButton;
		
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectCountry;
		
		////button[contains(@class,'ta-item')])[2]"
	     By tasresults = By.cssSelector(".ta-results");
		
		//Action
		public void selectCountry(String countryName) {
			Actions a = new Actions(driver);
			a.sendKeys(Country, countryName).build().perform();
			waitForElementtoappear(tasresults);
			selectCountry.click();
		}
		
		public Confimationpage SubmitOrder() {
			Actions actions = new Actions(driver);
			actions.moveToElement(submitButton).click().perform();
			return new Confimationpage(driver);
			
		}
		
}
