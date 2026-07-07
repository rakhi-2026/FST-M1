package activities;


import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity1 {
	
	String baseURI = "https://petstore.swagger.io/v2";
	
	@Test(priority = 0)
	public void createPet() {
		
		String pet = """
									{
					  "id": 7723442,
					  "name": "Mango",
					  "status": "alive"
					}
				""";
		
		Response response =  given()
							.baseUri(baseURI)
							.header("Content-type","application/json")
							.body(pet)
							.when()
							.post("/pet");
		
		response.prettyPrint();
		response.then().statusCode(200);
		
		response.then().body("id", equalTo(7723442));
		response.then().body("name", equalTo("Mango"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 1)
	public void getPetDetails() {
		
		int petId = 7723442;
		
		Response response = given()
							.baseUri(baseURI)
							.header("Content-type", "application/json")
							.pathParam("petId", petId)
							.when()
							.get("/pet/{petId}");
		response.prettyPrint();
		
		response.then().body("id", equalTo(7723442));
		response.then().body("name", equalTo("Mango"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 2)
	public void deletePet() {
		
		int petId = 7723442;
		
		Response response = given()
				.baseUri(baseURI)
				.header("Content-type", "application/json")
				.pathParam("petId", petId)
				.when()
				.delete("/pet/{petId}");
		
		response.prettyPrint();
		response.then().body("code",equalTo(200));
		response.then().body("message",equalTo(String.valueOf(petId)));
		
	}

}
