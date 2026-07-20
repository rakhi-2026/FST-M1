package Activities;

import java.io.File;
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
		
		//File object for the application
		
		File testApp = new File("src/test/resources/ToDo.apk");
		//set the desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.noReset();
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[contains(@text,\"All\")]")));
		driver.findElement(AppiumBy.xpath("//*[contains(@text,\"All\")]")).click();
				
	}
	
	
	
	@Test
	public void addTask() throws InterruptedException {
		
		
		
		//Assert the task
		List<WebElement> tasks =  driver.findElements(AppiumBy.id("ToDoEditDescription"));
		int taskCount = tasks.size();
		
		for(int i=0;i<taskCount-1;i++) {
			
			driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"])["+(i+1)+"]")).click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Toggle Show Completed\"]"))));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Toggle Show Completed\"]")).click();
		
		List<WebElement> notCompletedTasks =  driver.findElements(AppiumBy.id("ToDoEditDescription"));
		Assert.assertEquals(notCompletedTasks.size(),1);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

		
		
}
