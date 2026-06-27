package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity5 {
		
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass (alwaysRun = true)
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/target-practice/");
			
		}
		
		
		@Test(priority = 0)
		public void checkPageTitle() {
			
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		}
		
		@Test(dependsOnMethods = "checkPageTitle" ,groups = {"HeaderTests" })
		public void headerTest1() {
			
			WebElement txtHeader3 = driver.findElement(By.cssSelector("h3.text-3xl"));
			Assert.assertTrue(txtHeader3.isDisplayed());
			Assert.assertEquals(txtHeader3.getText(),"Heading #3");
		}
		
		@Test(dependsOnMethods = "checkPageTitle" ,groups = {"HeaderTests" })
		public void headerTest2() {
			WebElement txtHeader5 = driver.findElement(By.cssSelector("h5.text-purple-600"));
			String color = txtHeader5.getCssValue("color");
			Assert.assertEquals(Color.fromString(color).asHex(), "#9333ea");
		}
		
		@Test(dependsOnMethods = "checkPageTitle",groups = {"ButtonTests" })
		public void buttonTest1() {
			
			WebElement btnEmarald = driver.findElement(By.cssSelector("button.bg-emerald-200"));
			Assert.assertTrue(btnEmarald.isDisplayed());
			Assert.assertEquals(btnEmarald.getText(),"Emerald");
		}
		
		@Test(dependsOnMethods = "checkPageTitle",groups = {"ButtonTests" })
		public void buttonTest2() {
			WebElement btnPurple = driver.findElement(By.cssSelector("button.bg-purple-200"));
			String color = btnPurple.getCssValue("color");
			Assert.assertEquals(Color.fromString(color).asHex(), "#581c87");
		}
		
	
		
		@AfterClass (alwaysRun = true)
		public void teardown() {
			driver.quit();
		}
}
