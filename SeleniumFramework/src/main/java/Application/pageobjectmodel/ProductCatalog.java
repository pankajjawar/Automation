package Application.pageobjectmodel;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Application.AbstractComponent.AbstractComponents;

public class ProductCatalog extends AbstractComponents {
	
	  WebDriver driver;
//constructor to call the driver from the tests
//Landing page gets the driver variable from the test > transfers to local instance variable using this operator thus can be utilized locally
	public ProductCatalog(WebDriver driver) {
		super(driver);
		//intialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		/*initElements method is used by page factory model to intialize 
		the driver method by FindBy annotation to construct the findby element*/
	}
	
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//pagefactory : design pattern
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addproductBy=By.cssSelector(".card-body button:last-of-type");
	By toastcontainerBy = By.cssSelector("#toast-container");
	//Actions
	public List<WebElement> getProductlist() {
		waitForElementtoappear(productsBy);
		return products;
	}
	//Action
	public WebElement getProductByName(String productName) {
	    WebElement prod = getProductlist().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
}
	//Action
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod=getProductByName(productName);
		prod.findElement(addproductBy).click();
		waitForElementtoappear(toastcontainerBy);
		waitForElementtodisappear(spinner);
	}
	
}


