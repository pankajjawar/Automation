package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAnnotations4 {


	@Test(groups={"smoke"},timeOut=4000,enabled=true)
	public void Pay(){
		System.out.println("smoke");
	}
   
 //Parameter({"URL"})
    @Test(timeOut=400)
	public void Home(String urlname){
		System.out.println("Homepage");
  		System.out.println(urlname);
	} 
    
    @Test(dependsOnMethods={"Home"})
  	public void Logout(){
  		System.out.println("LogOut");
  	}
    
    @Test(dataProvider="InputValue")
  	public void Login1(String username,String password) {
    	
  		System.out.println(username);
  		System.out.println(password);
  	}
    //depends
    //parameters
    //Timeout
    //enabled
    //dataprovider
    
    @DataProvider
  	public Object[][] InputValue(){
  	Object[][] inputvalue = new Object[3][2];
  	inputvalue[0][0] = "pankaj00";inputvalue[0][1] = "pankaj01";
  	inputvalue[1][0] = "pankaj10";inputvalue[1][1] = "pankaj11";
  	inputvalue[2][0] = "pankaj20";inputvalue[2][1] = "pankaj21";
  	return inputvalue;
    }		
    
}
  		
