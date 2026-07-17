package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	
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
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	}
	
	
	@DataProvider(name = "coordinates")
	public Object[][] inputValues() {
		//// Calculate the phone screen dimensions
		//Dimension dims = driver.manage().window().getSize();
		//
		//// Calculate the start and end points
		//Point start = new Point(
		//(int) (Float.valueOf(startX)  * dims.getWidth()), 
		//(int) (Float.valueOf(startY) * dims.getHeight())
		//);
		//Point end = new Point(
		//(int) (Float.valueOf(endX) * dims.getWidth()), 
		//(int) (Float.valueOf(endY) * dims.getHeight())
		//);

		// Create the start and end points
		Point start = new Point(536, 1640);
		Point end_25 = new Point(363, 1640);
		Point end_75 = new Point(721, 1640);
	
		return new Object[][] {
		{start, end_25, "25%"},
		{start, end_75, "75%"}};
	
	}
	
	@BeforeMethod
	public void homePageTest() {
		
		driver.get("https://training-support.net/webelements/sliders");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id='volume']")));
		// verify the redirect page
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sliders']")).isDisplayed());
		
		
	}
	

	
	@Test(dataProvider = "coordinates")
	public void testVolumeSlider(Point start,Point end,String expectedVolume) throws InterruptedException {
		
	
		ActionBase.doSwipe(driver, 2000, start, end);
		
		// Get the volume level
		String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]")).getText();
		 
				// Assertions
		Assert.assertTrue(volumeText.contains(expectedVolume));
	}
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
