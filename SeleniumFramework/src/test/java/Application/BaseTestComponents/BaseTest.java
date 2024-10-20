package Application.BaseTestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Application.pageobjectmodel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage ;
	public String browserName;
	public Properties properties;
	public String URLlink;
	//properties is a class in java used to read the Globalproperties

	
	public WebDriver intializeDriver() throws IOException {
		
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Application\\resources\\Gobaldata.properties");
		properties.load(fis);
		browserName = properties.getProperty("browser");
		URLlink = properties.getProperty("URL");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = intializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo(URLlink);
		return landingPage;
	}
	
   @AfterMethod
	public void closeApplication() throws IOException {
	    driver.close();
	}
}
