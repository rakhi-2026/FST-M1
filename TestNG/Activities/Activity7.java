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


public class Activity7 {
		
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass (alwaysRun = true)
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.get("https://training-support.net/webelements/login-form/");
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
			
		}
		
		
		@DataProvider(name = "Authentication")
		public static Object[][] credentials(){
			return new Object[][] {
				{ "admin", "password" },
				{ "wrongAdmin", "wrongPassword"}
			};
			
		}
		
		@Test(dataProvider = "Authentication")
		public void login(String username,String password) {
			
			WebElement txtusername = driver.findElement(By.xpath("//input[@name='username']"));
			WebElement txtpassword = driver.findElement(By.xpath("//input[@name = 'password']"));
			WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
			txtusername.sendKeys(username);
			txtpassword.sendKeys(password);
			btnSubmit.click();
			
			
			if(driver.getTitle() == "Selenium: Login Success!") {
				explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2.mt-5")));
				System.out.println("Login Success ! ");
				System.out.println("New Page title is : "+driver.getTitle());
				Assert.assertEquals((driver.findElement(By.cssSelector("h2.mt-5"))).getText(),"Welcome Back, Admin!");
				driver.navigate().back();
				
			}else {
				System.out.println("Invalid Credentials");
			}
			
			
			
		}
		
		
		
		@AfterClass (alwaysRun = true)
		public void teardown() {
			driver.quit();
		}
}
