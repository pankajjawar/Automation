package TestNgPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

public class TestAnnotation1 {
	
    @AfterTest	
	public void Login() {
		System.out.println("TestAnno_Loginbutton");
	}
    
    @Test
	public void GiveInput() {
		System.out.println("Giveinput");
	}
    
    @AfterSuite
	public void AddtoCart() {
		System.out.println("AfterSuite");
	}

}
