
package Application.Tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Application.BaseTestComponents.BaseTest;

public class ErrorValidationTests extends BaseTest  {

 @Test
 public void submitOrder() throws IOException, InterruptedException
 {
		// TODO Auto-generated method stub
		landingPage.loginApplication("pankajjawar2024@gmail.com","Pankajjawar224@gmail.com");
	 	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

}