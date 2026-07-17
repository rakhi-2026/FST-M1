package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class Activity4 {
	
	//Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		//options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	}
	

	@BeforeMethod
	public void contactAppSetUp() throws InterruptedException {
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
	}
	@Test(priority=0)
	public void createContact() {
		
		//locate and tap create contact button
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		
		//locate and fill the first name "Aaditya"
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
		
		//locate and fill the first name "Varma"
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
		
		//locate and fill the phone number "999148292"
		/*driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']/android.view.View[2]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']/android.view.View[2]")).clear();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']/android.view.View[2]")).sendKeys("999148292");*/
		List<WebElement> edits = driver.findElements(AppiumBy.className("android.widget.EditText"));
		System.out.println(edits.size());

		for (WebElement e : edits) {
		    System.out.println(e.getText());
		    if(e.getText().equals("+1")) {
		    	e.click();
		    	driver.switchTo().activeElement().sendKeys("999148292");
		    	break;
		    }
		}
		
		//locate and tap the save button
		driver.findElement(AppiumBy.xpath("//android.view.View[3]/android.widget.Button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
		 
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
		
        Assert.assertEquals(contactName, "Aaditya Varma");
	}
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
