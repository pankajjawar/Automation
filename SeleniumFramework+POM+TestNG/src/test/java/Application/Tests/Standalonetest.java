package Application.Tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Application.BaseTestComponents.BaseTest;
import Application.pageobjectmodel.CartPage;
import Application.pageobjectmodel.CheckoutPage;
import Application.pageobjectmodel.Confimationpage;
import Application.pageobjectmodel.LandingPage;
import Application.pageobjectmodel.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ADIDAS ORIGINAL";
		String countryName = "india";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10, 1));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo("https://rahulshettyacademy.com/client");
		ProductCatalog productcatalog = landingPage.loginApplication("pankajjawar2024@gmail.com", "Pankajjawar2024@gmail.com");
		List<WebElement> products = productcatalog.getProductlist();
		productcatalog.addProductToCart(productName);
		CartPage cartpage = productcatalog.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay(productName);
	    Assert.assertTrue(match);
	    CheckoutPage checkoutpage = cartpage.checkOut();
	    checkoutpage.selectCountry(countryName);
	    Confimationpage confimationpage = checkoutpage.SubmitOrder();
	    String confirmMessage = confimationpage.verifyConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    driver.close();
		
	}

}
