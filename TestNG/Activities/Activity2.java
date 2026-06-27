package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
		
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/target-practice/");
			
		}
		
		
		@Test(priority = 0)
		public void testMethod1() {
			
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		}
		
		@Test(priority = 1)
		
		public void testMethod2() {
			//This test case will fail
			WebElement btnBlack = driver.findElement(By.cssSelector("button.bg-black-200"));
			Assert.assertTrue(btnBlack.isDisplayed());
			Assert.assertTrue(btnBlack.getText()== "Black");
		}
		
		@Test(priority = 2, enabled = false)
		public void testMethod3() {
			//This method will not be shown in the test report
			System.out.println("This test case needs to be skipped");
			
		}
		
		@Test(priority = 3)
		
		public void testMethod4() throws SkipException {
			
			throw new SkipException("Skipping - This is not ready for testing ");
		}
		
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}
}
