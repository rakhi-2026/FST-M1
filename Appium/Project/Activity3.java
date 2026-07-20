package Activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
		
		
		//set the desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		
		//In Android , to open a pre-installed app
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait =  new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	
	
	@DataProvider(name = "coordinates")
	public Object[][] inputValues() {
		

		// Create the start and end points
		Point start = new Point(483, 2129);
		Point end = new Point(483, 305);
		Point startTap = new Point(413,497);
		String username = "admin";
		String password = "password";
		
		return new Object[][] {
		{start, end,username,password,startTap}
		};
	
	}
	
	@Test(dataProvider = "coordinates")
	public void performLoginActivity(Point start,Point end,String username,String password,Point startTap) throws InterruptedException {
		
		driver.get("https://training-support.net/webelements");
		// verify the page
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")).isDisplayed());
		
		ActionBase.doSwipe(driver, 2000, start, end);
		ActionBase.doSwipe(driver, 2000, start, end);
		
		WebElement popUpForm =  driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Popups Work with popups!\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Popups Work with popups!\"]")));
		popUpForm.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")).click();
		
		ActionBase.doTap(driver,startTap);
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys(username);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys(password);
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
		
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]")).isDisplayed());
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

		
		
}
