package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	
	//Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
		//options.noReset();
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	}
	

	
	@Test(priority=0)
	public void sendMessage() throws InterruptedException {
		
		//locate and tap start chat button
		driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
		
		//type the number to where you send the message //android.widget.TextView[@text='Rakhi Das']
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Type name, phone number, or email']")).click();
		driver.switchTo().activeElement().sendKeys("9432820941");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Rakhi Das']")));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Rakhi Das']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
		driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id='Compose:Draft:Send']/android.widget.Button")));
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='Compose:Draft:Send']/android.widget.Button")).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'You said')]"))));
		String messageTextSent = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'You said')]")).getText();
		Assert.assertTrue(messageTextSent.contains("Hello from Appium"));
		
		
	}
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
