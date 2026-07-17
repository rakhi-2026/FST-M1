package activities;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	//Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		
		//set the desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		
		//In Android , to open a pre-installed app
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		// In IOS, to open a pre-installed app
		//options.setCapability("bundleId", "com.apple.AppName");
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	
	@Test
	public void homePageTest() {
		
		driver.get("https://training-support.net");
		//Locate and Tap the About Us link
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();
		
		// verify the redirect page
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[1]")).getText(),"About Us");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
