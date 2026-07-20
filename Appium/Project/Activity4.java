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

public class Activity4 {
	
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
		//options.noReset();
		
		// set the appium server URL
		URL serverURL =  new URI("http://localhost:4723").toURL();
		driver= new AndroidDriver(serverURL,options);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@DataProvider(name = "tasks")
	public Object[][] inputValues() {
		

		// Create the task details
		String Task1 = "Complete Activity 1 with priority 1 and the due date set for Wednesday";
		String Priority1 = "1";
		String DueDate1 = "Wednesday";
		String Task2 = "Complete Activity 2 with priority 2 and the due date set for Wednesday";
		String Priority2 = "2";
		String DueDate2 = "Wednesday";
		String Task3 = "Complete Activity 3 with priority 3 and the due date set for Thursday";
		String Priority3 = "3";
		String DueDate3 = "Thursday";
		
		return new Object[][] {
		{Task1, Priority1,DueDate1},
		{Task2, Priority2,DueDate2},
		{Task3, Priority3,DueDate3},
		};
	
	}
	
	@Test(dataProvider = "tasks")
	public void addTask(String Task,String Priority,String DueDate) throws InterruptedException {
		
		//click on New Button
		driver.findElement(AppiumBy.id("ListButtonNew")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")));
		//click and fill the description
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")).sendKeys(Task);
		
		//fill the priority
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).clear();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).sendKeys(Priority);
		
		
		//click on Due Date and fill the date for Activity  
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		driver.findElement(AppiumBy.xpath("//*[contains(@text,\""+DueDate+"\")]")).click();
		
		//click on OK
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		
		//Assert the task
		
		List<WebElement> tasks =  driver.findElements(AppiumBy.id("ToDoEditDescription"));
		for(WebElement e : tasks) {
			if(e.getText().contentEquals(Task)) {
				Assert.assertEquals(e.getText(), Task);
				break;
			}
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

		
		
}
