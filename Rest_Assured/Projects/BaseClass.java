package activities;


import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	String baseURI = "https://api.github.com";
	String pubSSHKeys = "";
	int id = 0;
	String authToken = "xxxxx";
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void setUp() {
		
		 requestSpec = new RequestSpecBuilder()
				 		.setBaseUri(baseURI)
				 		.setContentType(ContentType.JSON)
				 		.addHeader("Authorization", "token " + authToken)
				 		.build();
		
	}

}
