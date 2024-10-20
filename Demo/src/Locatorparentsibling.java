import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatorparentsibling {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/");
		//Parent > child > sibling trave
		System.out.println(driver.findElement(By.xpath("//div[@data-id='72531ae']/following-sibling::div[@data-id='349606d']")).getText());
		//child-parent trave
		System.out.println(driver.findElement(By.xpath("//div[@data-id='72531ae']/parent::div/parent::section/parent::div/section[2]/div/div[1]")).getText());
	//river.findElement(By.xpath("//div[@data-id='72531ae']/following-sibling::div[@data-id='349606d']")).getText();

}

}