package Application.pageobjectmodel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Application.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	  WebDriver driver;
//constructor to call the driver from the tests
//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public LandingPage(WebDriver driver) {
		
		//super keywords helps to send the variables from child class to the parent class
		super(driver);
		//intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		/*initElements method is used by page factory model to intialize 
		the driver method by FindBy annotation to construct the findby element*/
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pagefactory : design pattern
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordElem;
	
	@FindBy(id="login")
	WebElement submit;
	
	
    @FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	//Actions
	public ProductCatalog loginApplication(String email,String password) {
	userEmail.sendKeys(email);
	passwordElem.sendKeys(password);
	submit.click();
	ProductCatalog productcatalog = new ProductCatalog(driver);
	return productcatalog;
	}
	//Actions
	public void goTo(String URL) {
		driver.get(URL);
	}
	
	//Actions
		public String getErrorMessage() {
			waitForWebElementtoappear(errorMessage);
			String loginfailure = errorMessage.getText();
			return loginfailure;
		}
}


