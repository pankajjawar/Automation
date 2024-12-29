import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\Chrome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000);
	    int i;
	    for(i=1;i<5;i++) {
	    	driver.findElement(By.id("hrefIncAdt")).click();
	    }
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@class='buttonN']")).click();
	    driver.close();
}
}
