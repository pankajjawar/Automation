package TestNgPractice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {
	
    @Test	
	public void Login() {
		System.out.println("Loginbutton");
	}
    
    @BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest");
	}
}
