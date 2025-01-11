package Fullflow_Practice;

import org.testng.annotations.Test;

import java.util.List;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;

public class EndtoEndApisAutomation {
	
	@Test	
	public static void LoginAuthToken() {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginDetails LD = new LoginDetails();	
		LD.setUserEmail("pankajjawar2024@gmail.com");
		LD.setUserPassword("Pankajjawar2024@gmail.com");
		
		RequestSpecification LoginRequest = given().log().all().spec(req).body(LD);
		Response res = LoginRequest.when().post("/api/ecom/auth/login").then().log().all().extract().response();
		String loginresponse = res.asString();
		JsonPath js = new JsonPath(loginresponse);
		String Authtoken = js.get("token");
		String userID = js.get("userId");
		
		//addProduct
		RequestSpecification addProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("Authorization", Authtoken).build();
		
		ResponseSpecification Resvalidation = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
	Response addres = given().log().all().spec(addProduct).param("productName", "qwerty").param("productAddedBy", userID).param("productCategory", "fashion").
		param("productSubCategory", "shirts").param("productPrice", "11500").param("productDescription", "Addias Original").
		param("productFor", "men").multiPart("productImage",new File("C:\\Users\\LENOVO\\Pictures\\WHA_David-Kovalenko_1_grande.jpg")).when().post("/api/ecom/product/add-product").
		then().log().all().spec(Resvalidation).extract().response();
	
	String addProductResponse = addres.asString();
	JsonPath js1 = new JsonPath(addProductResponse);
	String ProductID = js1.get("productId");
	System.out.println(ProductID);
	
	//createorder
	RequestSpecification buyProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).
			addHeader("Authorization", Authtoken).build();
	
	ResponseSpecification resval = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
	
	//Create a Json
	Orders orderdetails = new Orders();
	orderdetails.setCountry("India");
	orderdetails.setProductOrderedId(ProductID);
	//adding a Json as Array
	List<Orders> Order = new ArrayList<Orders>();
	Order.add(orderdetails);
	Product pd = new Product();
	pd.setOrders(Order);

	Response rescreateorder = given().log().all().spec(buyProduct).body(pd).when().post("/api/ecom/order/create-order").then().log().all()
			.spec(resval).extract().response();
	CreatedOrder responsecreatedorder = rescreateorder.as(CreatedOrder.class);
			
		List<String> L =responsecreatedorder.getProductOrderId();
		String OrderID = L.get(0);
	    System.out.print(OrderID);
	
	//DeleteOrder
	RequestSpecification deleteOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).
			addHeader("Authorization", Authtoken).build();
	
	String resdeleteorder = given().log().all().spec(deleteOrder).when().delete("/api/ecom/product/delete-product/"+OrderID).then().log().all()
			.assertThat().statusCode(200).extract().response().asString();
	
	System.out.print(resdeleteorder);

}

}