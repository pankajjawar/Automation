package Application.AbstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Application.pageobjectmodel.CartPage;
import Application.pageobjectmodel.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;//local object
	
	//constructors used to capture the variable from other class
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement addtocart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderspage;

	public void waitForElementtoappear(By findBY) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBY));
    }
	
	public void waitForWebElementtoappear(WebElement webele) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(webele));
    }
	
	public void waitForElementtodisappear(WebElement ele) throws InterruptedException {
	//Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
    }
	
	public CartPage goToCartPage() {
		addtocart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage goToOrderPage() {
		orderspage.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
}
