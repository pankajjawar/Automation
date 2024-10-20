package TestNgPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAnnotations3 {
	
    @AfterClass	
	public void Login() {
		System.out.println("Afterclass_Loginbutton");
	}
    
    @AfterMethod
	public void Aftermethod() {
		System.out.println("AftermethodTest");
	}
    
    @Test	
	public void Submit() {
		System.out.println("Submit");
	}
    
    @Test	
	public void LoggedIn() {
		System.out.println("Loggedin");
	}
    
    @Test	
	public void AddtoCart() {
		System.out.println("Added to cart");
	}

}
