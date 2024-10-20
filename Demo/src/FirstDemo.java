import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstDemo {

	public static void main(String[] args) {
		//webdriver is interface provides methods without implementation
		//its the class which implements the webdriver methods(ex classes : chromedriver.firefoxdriver)
		//System.setProperty("webdriver.gecko.driver","C:\\browserdriver\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\browserdriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//+FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		
	}

}
