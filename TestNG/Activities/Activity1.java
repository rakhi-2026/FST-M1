package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
		
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			driver.get("https://training-support.net");
			explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		}
		
		
		@Test(priority = 1)
		public void testMethod1() {
			
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Training Support");
			WebElement btnAboutUs =  driver.findElement(By.xpath("//a[@href = '/about']"));
			btnAboutUs.click();
			
		}
		
		@Test(priority = 2)
		
		public void testMethod2() {
			
			explicitWait.until(ExpectedConditions.titleContains("About Training Support"));
			System.out.println("The about page title is : " + driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "About Training Support");
		}
		
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}
}
