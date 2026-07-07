package activities;


import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity2 {
	
	String baseURI = "https://petstore.swagger.io/v2";
	
	@Test(priority = 0)
	public void createUser() {
		
		File newFile = new File("src/test/resources/userInfo.json");
		
		Response response =  given()
							.baseUri(baseURI)
							.header("Content-type","application/json")
							.body(newFile)
							.when()
							.post("/user");
		
		response.prettyPrint();
		response.then().statusCode(200);
		
		response.then().body("message", equalTo(String.valueOf(6902)));
	}
	
	@Test(priority = 1)
	public void getUserDetails() {
		
		File file = new File("src/test/resources/userInfoResult.json");
		String user = "polarisUser";
		
		Response response = given()
							.baseUri(baseURI)
							.header("Content-type", "application/json")
							.pathParam("username", user)
							.when()
							.get("/user/{username}");
		
		
		response.prettyPrint();
		
		response.then().body("id", equalTo(6902));
		response.then().body("username", equalTo("polarisUser"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
		
		String resBody = response.asPrettyString();
		
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file.getPath());
			writer.write(resBody);
			writer.close();
		}catch (IOException excp) {
	        excp.printStackTrace();
	    }
	}
	
	@Test(priority = 2)
	public void deleteUsrer() {
		
		String user = "polarisUser";
		
		Response response = given()
				.baseUri(baseURI)
				.header("Content-type", "application/json")
				.pathParam("username", user)
				.when()
				.delete("/user/{username}");
		
		response.prettyPrint();
		response.then().body("code",equalTo(200));
		response.then().body("message",equalTo(user));
		
	}

}
