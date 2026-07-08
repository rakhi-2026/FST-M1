package activities;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Activity3 {
	
	String baseURI = "https://petstore.swagger.io/v2/pet";
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		
		 requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri(baseURI)
				.build();
		 
		 responseSpec = new  ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.expectBody("status", equalTo("alive"))
				.build();
	}
	
	@DataProvider(name = "petDetails")
	public Object[][] providePetDetails(){
		
		return new Object[][] {
			{ 97232, "Riley", "alive" }, 
			{ 98233, "Hansel", "alive" } 
		};
	
		
	}
	
	@Test(priority = 0 , dataProvider = "petDetails" )
	public void createPet(int id,String name,String status) {
		
		Map<String,Object> pets = new HashMap<>();
		pets.put("id",id);
		pets.put("name",name);
		pets.put("status",status);
		
		given()
		.spec(requestSpec)
		.body(pets)
		.when()
		.post().then().spec(responseSpec).body("name", equalTo(name));
		
	
		
	}
	
	@Test(priority = 1 , dataProvider = "petDetails" )
	public void getPet(int id,String name,String status) {
		
		Map<String,Object> pets = new HashMap<>();
		pets.put("id",id);
		pets.put("name",name);
		pets.put("status",status);
		
		given()
		.spec(requestSpec).log().all().pathParam("petId", id)
		.when()
		.get("/{petId}").then().spec(responseSpec).log().all().body("name", equalTo(name));
		
	
		
	}
	
	
	@Test(priority = 2 , dataProvider = "petDetails" )
	public void deletePet(int id,String name,String status) {
		
		Map<String,Object> pets = new HashMap<>();
		pets.put("id",id);
		pets.put("name",name);
		pets.put("status",status);
		
		given()
		.spec(requestSpec).log().all().pathParam("petId", id)
		.when()
		.delete("/{petId}").then().body("code", equalTo(200))
		.body("message", equalTo(String.valueOf(id)));
		
	
		
	}
	
	

}
