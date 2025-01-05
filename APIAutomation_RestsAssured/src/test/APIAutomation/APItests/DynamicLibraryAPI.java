package APItests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payload.Payloads;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DynamicLibraryAPI {
  
	
	@DataProvider(name="booksname")
	public Object[][] booksData(){
		//2 dimensional array
		return new Object[][] {{"abaz2","19927"},{"abca","1999"},{"azcz","9916"}};
	}
		
	@Test(priority=0,dataProvider="booksname")
	public void DynamicApi(String ibsn,String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response = given().log().all().header("Content-Type","text/plain").body(Payloads.addBook(ibsn,aisle)).
		when().post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
	

	@Test(priority=1,dataProvider="booksname")
	public void deleteBooks(String ibsn,String aisle) {
		String Response =  given().log().all().header("Content-Type","text/plain").body(Payloads.deleteBook(ibsn,aisle)).when().delete("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
	
	
}
