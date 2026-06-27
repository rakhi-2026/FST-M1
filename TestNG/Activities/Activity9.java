package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.Alert;
import org.testng.annotations.*;


public class Activity9 {
		
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass (alwaysRun = true)
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Alerts");
			Reporter.log("Opened Browser |");
			Reporter.log("Page title is " + driver.getTitle() + " |");
			
		}
		
		
		@BeforeMethod 
		public void switchtoPage() {
			driver.switchTo().defaultContent();
		}
		
		@Test(priority = 1)
		public void simpleAlertTestCase() {
			
			WebElement btnSimple = driver.findElement(By.xpath("//button[@id='simple']"));
			btnSimple.click();
			Reporter.log("Simple Alert opened |");
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Reporter.log("Switched foucs to alert |");
			Reporter.log("The Text in the alert : " +alert.getText());
			Assert.assertEquals("You've just triggered a simple alert!", alert.getText());
			alert.accept();
			Reporter.log("Alert closed");
			 
	        Reporter.log("Test case ended |");
		}
		
		@Test(priority = 2)
		public void confirmAlertTestCase() {
			
			WebElement btnConfirm = driver.findElement(By.xpath("//button[@id='confirmation']"));
			btnConfirm.click();
			Reporter.log("Confirm Alert opened |");
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Reporter.log("Switched foucs to alert |");
			Reporter.log("The Text in the alert : " +alert.getText());
			Assert.assertEquals("You've just triggered a confirmation alert!", alert.getText());
			alert.accept();
			Reporter.log("Alert closed");
			 
	        Reporter.log("Test case ended |");
		}
		
		@Test(priority = 3)
		public void promptAlertTestCase() {
			WebElement btnPrompt = driver.findElement(By.xpath("//button[@id='prompt']"));
			btnPrompt.click();
			Reporter.log("Prompt Alert opened |");
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Reporter.log("Switched foucs to alert |");
			Reporter.log("The Text in the alert : " +alert.getText());
			alert.sendKeys("Typing in the prompt alert");
			Assert.assertEquals("I'm a Prompt! Type something into me!", alert.getText());
			alert.dismiss();
			
			Reporter.log("Alert closed");
			 
	        Reporter.log("Test case ended |");
		}
		
		
		
		
		@AfterClass (alwaysRun = true)
		public void teardown() {
			driver.quit();
		}
}
