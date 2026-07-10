package activities;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ActivityProject extends BaseClass {
	
	@Test (priority = 0)
	public void post() {
		
		Map<String,Object> sshs = new HashMap<>();
		sshs.put("title","TestAPIKey");
		sshs.put("key","ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOsfzkt/8oo0dkVNhP4S7Ji5L7DXQAf+VE1L4pQ9LDKI azuread\\\\rakhidas@IBM-GFYMH24");
		
		 Response response = given()
								.spec(requestSpec)
								.body(sshs)
								.when()
								.post("/user/keys");
		 
		 response.prettyPrint();
		
		 Assert.assertEquals(response.getStatusCode(), 201);
		 super.id = response.jsonPath().getInt("id");
		 
		  System.out.println("Created Key Id : " + super.id );
		
	}
	
	@Test(priority = 1)
	public void get() {
		
		Response response = given()
				.spec(requestSpec)
				.pathParam("keyId", super.id )
				.get("/user/keys/{keyId}");
		
		response.prettyPrint();
		Reporter.log(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void delete() {
		
		Response response = given()
				.spec(requestSpec)
				.pathParam("keyId", super.id )
				.delete("/user/keys/{keyId}");
		
		Reporter.log(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}

}
