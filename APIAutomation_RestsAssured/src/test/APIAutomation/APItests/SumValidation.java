package APItests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Payload.Payloads;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public static void sumValidation() {
		//validate the purchase amount is reflected correctly
		 JsonPath js = new JsonPath(Payloads.GetPrice());
		 
		 int totalpurchaseamount = 0;
		 int coursescount = js.getInt("courses.size()");
		 int purchasevalue = js.getInt("dashboard.purchaseAmount");
		 for(int i=0;i<coursescount;i++) {
				int price = js.get("courses["+i+"].price");
				int copies = js.get("courses["+i+"].copies");
				int Amount = price * copies;
				totalpurchaseamount = totalpurchaseamount+Amount;
	}
		 Assert.assertEquals(totalpurchaseamount, purchasevalue);
	}

}
