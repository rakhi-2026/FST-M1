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
import org.testng.annotations.DataProvider;
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
	}
	
	@DataProvider(name = "tasks")
	public Object[][] inputValues() {
		

		// Create the task details
		
		String Task = "Complete Activity 2 with priority 2 and the due date set for Wednesday";
		String Category = "New Category";
		
		return new Object[][] {
		{Task,Category}
		};
	
	}
	
	@Test(dataProvider = "tasks")
	public void addTask(String Task,String Category) throws InterruptedException {
		
		//click on the dropdown
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[contains(@text,\"Edit categories\")]")));
		//click on Edit categories
		driver.findElement(AppiumBy.xpath("//*[contains(@text,\"Edit categories\")]")).click();
		
		//click on New button
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonNew")));
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonNew")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListItemID")).sendKeys(Category);
		
		
		//click on OK button
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonOK")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Category+"\"]")).isDisplayed());
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"All\"]")).click();
		
		Thread.sleep(2000);
		System.out.println("Task found");
		
		//Assert the task
		List<WebElement> tasks =  driver.findElements(AppiumBy.id("ToDoEditDescription"));
		for(WebElement e : tasks) {
			if(e.getText().contentEquals(Task)) {
				if(e.getText().contentEquals(Task)) {
					System.out.println("Task found");
					Assert.assertEquals(e.getText(), Task);
					ActionBase.doLongPress(driver, e);
					break;
				}
				
			}
		}
		
		//Add the category
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailSpinnerCategory")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Category+"\"]")).click();
		
		//Click on OK
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Category+"\"]")).click();
		//Assert the task
		for(WebElement e : tasks) {
			if(e.getText().contentEquals(Task)) {
				if(e.getText().contentEquals(Task)) {
					System.out.println("Task found");
					Assert.assertEquals(e.getText(), Task);
					break;
				}
				
			}
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

		
		
}
