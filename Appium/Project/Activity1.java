package Activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

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

public class Activity1 {
	
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
	
		return new Object[][] {
		{start, end}};
	
	}
	
	@Test(dataProvider = "coordinates")
	public void performToDoActivity(Point start,Point end) throws InterruptedException {
		
		driver.get("https://training-support.net/webelements");
		// verify the page
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")).isDisplayed());
		
		ActionBase.doSwipe(driver, 2000, start, end);
		ActionBase.doSwipe(driver, 2000, start, end);
		ActionBase.doSwipe(driver, 2000, start, end);
		
		WebElement todoList =  driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List Elements get added at runtime!\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List Elements get added at runtime!\"]")));
		todoList.click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys("New Task");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();
		
		System.out.println("The number of task : "+ driver.findElements(AppiumBy.xpath("//android.widget.ListView//android.widget.CheckBox")).size());
		int noOfTask = driver.findElements(AppiumBy.xpath("//android.widget.ListView//android.widget.CheckBox")).size();
		
		Assert.assertEquals(noOfTask, 3);
		
		List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.ListView//android.widget.CheckBox"));
		
		for (WebElement e : tasks) {
			e.click();
		}
		
		List<WebElement> clearBtn = driver.findElements(AppiumBy.xpath("//android.widget.ListView//android.widget.Button"));
		
		for(int i = clearBtn.size()-1 ; i>=0 ; i--) {
			clearBtn.get(i).click();
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

		
		
}
