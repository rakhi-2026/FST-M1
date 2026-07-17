package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	//Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		//File object for the application
		
		File testApp = new File("src/test/resources/Calculator.apk");
		//set the desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		//options.noReset();
		
		/* For IOS:
		// File object for the application
		File iosApp = new File("src/test/resources/app.ipa");
		// Set the desired capabilities or options
		XCUITestOptions iosOptions = new XCUITestOptions();
		iosOptions.setPlatformName("ios");
		iosOptions.setAutomationName("XCUITest");
		iosOptions.setApp(iosApp.getAbsolutePath());*/
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
	}
	
	@BeforeMethod
	public void clearResults() {
		driver.findElement(AppiumBy.accessibilityId("clear")).click();;
	}
	
	@Test
	public void testMethod() {
		
		//locate and tap digit 7
		WebElement digit1  = driver.findElement(AppiumBy.id("digit_7"));
		//locate and tap + symbol
		WebElement plus =  driver.findElement(AppiumBy.id("op_add"));
		//locate and tap digit 3
		WebElement digit2  = driver.findElement(AppiumBy.id("digit_3"));
		//locate and tap = symbol
		WebElement equals  = driver.findElement(AppiumBy.id("eq"));
		
		
		digit1.click();
		plus.click();
		digit2.click();
		equals.click();
		
		//locate and tap result 10
		WebElement result = driver.findElement(AppiumBy.id("result_final"));
		//Assert the result
		Assert.assertEquals(result.getText(), "10");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
