package APItests;

import org.testng.Assert;

import Payload.Payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(Payloads.GetPrice());
		
		//print the count of the courses
		int coursescount = js.getInt("courses.size()");
		System.out.println(coursescount);
		
		//print the title of the course
	     String coursetitle = js.getString("courses[0].title");
		System.out.println(coursetitle);
		
		//print the total purchase value
		int purchasevalue = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchasevalue);
		
		//print all the titles and their prices
		for(int i=0;i<coursescount;i++) {
			String coursetitles = js.get("courses["+i+"].title");
			System.out.println(coursetitles);
			System.out.println(js.get("courses["+i+"].price").toString());
		}
			
			//print all the RPA and their copies sold
		 for(int i=0;i<coursescount;i++) {
				String titles = js.get("courses["+i+"].title");
				if (titles.equalsIgnoreCase("Cypress")){
					System.out.println(js.get("courses["+i+"].copies").toString());	
					break;
				}
		}
		 
		 
	}
	
}
