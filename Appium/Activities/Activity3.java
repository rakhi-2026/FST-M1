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

public class Activity3 {
	
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
		options.noReset();
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
	}
	
	@BeforeMethod
	public void clearResults() {
		driver.findElement(AppiumBy.accessibilityId("clear")).click();;
	}
	
	@Test(priority=0)
	public void testAdditionMethod() {
		
		//locate and tap digit 5
		driver.findElement(AppiumBy.id("digit_5")).click();
		
		//locate and tap + symbol
		driver.findElement(AppiumBy.id("op_add")).click();
		
		//locate and tap digit 9
		driver.findElement(AppiumBy.id("digit_9")).click();
		
		//locate and tap = symbol
		driver.findElement(AppiumBy.id("eq")).click();
		
		
		//locate and tap result 10
		WebElement result = driver.findElement(AppiumBy.id("result_final"));
		//Assert the result
		Assert.assertEquals(result.getText(), "14");
		System.out.println("The result of addition : "+ result.getText());
	}
	
	@Test(priority =1)
	public void testSubstractionMethod() {
		
		//locate and tap digit 10
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		
		//locate and tap - symbol
		driver.findElement(AppiumBy.id("op_sub")).click();
		
		//locate and tap digit 5
		driver.findElement(AppiumBy.id("digit_5")).click();
		
		//locate and tap = symbol
		driver.findElement(AppiumBy.id("eq")).click();
		
		
		//locate and tap result 5
		WebElement result = driver.findElement(AppiumBy.id("result_final"));
		//Assert the result
		Assert.assertEquals(result.getText(), "5");
		System.out.println("The result of substraction : "+ result.getText());
	}
	
	@Test(priority =2)
	public void testMultiplicationMethod() {
		
		//locate and tap digit 5
		driver.findElement(AppiumBy.id("digit_5")).click();
		
		//locate and tap * symbol
		driver.findElement(AppiumBy.id("op_mul")).click();
		
		//locate and tap digit 100
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		
		//locate and tap = symbol
		driver.findElement(AppiumBy.id("eq")).click();
		
		
		//locate and tap result 500
		WebElement result = driver.findElement(AppiumBy.id("result_final"));
		//Assert the result
		Assert.assertEquals(result.getText(), "500");
		System.out.println("The result of multiplication : "+ result.getText());
	}
	
	@Test(priority =3)
	public void testDivisionMethod() {
		
		//locate and tap digit 50
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		
		//locate and tap * symbol
		driver.findElement(AppiumBy.id("op_div")).click();
		
		//locate and tap digit 2
		driver.findElement(AppiumBy.id("digit_2")).click();
		
		//locate and tap = symbol
		driver.findElement(AppiumBy.id("eq")).click();
		
		
		//locate and tap result 500
		WebElement result = driver.findElement(AppiumBy.id("result_final"));
		//Assert the result
		Assert.assertEquals(result.getText(), "25");
		System.out.println("The result of division : "+ result.getText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
