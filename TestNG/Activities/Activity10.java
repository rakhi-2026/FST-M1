package Activities;

import java.io.FileReader;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
public class Activity10 {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.get("https://training-support.net/webelements/simple-form");
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Simple Form");
			
		}
		
		@DataProvider(name = "EmpDetails")
		public static Object[][] readEmpDetails() throws Exception{
			
			CSVReader reader = new CSVReader(new FileReader("src/test/resources/EmpDetails.csv"));
			reader.skip(1);
			List<String[]> allRows =  reader.readAll();
			Object[][] data = new Object[allRows.size()][];
			for (int i = 0; i < allRows.size(); i++) {
				data[i] = allRows.get(i);
			}
			reader.close();
			return data;
			
		}
				
				
		@Test(dataProvider = "EmpDetails")
		public void submitForm(String fullName,String email,String eventDate,String details) {
			
			WebElement txtFullName = driver.findElement(By.xpath("//input[@name='full-name']"));
			WebElement txtEmail = driver.findElement(By.xpath("//input[@name = 'email']"));
			WebElement txtEventDt = driver.findElement(By.xpath("//input[@name='event-date']"));
			WebElement txtAdditionalDetails = driver.findElement(By.xpath("//textarea[@name='additional-details']"));
			WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
			
			txtFullName.sendKeys(fullName);
			txtEmail.sendKeys(email);
			txtEventDt.click();
			System.out.println("Event Date = " + eventDate);
			txtEventDt.sendKeys(eventDate);
			txtAdditionalDetails.sendKeys(details);
			
			btnSubmit.click();
			explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.text-center")));
			String successMsg = driver.findElement(By.cssSelector("h3.text-center")).getText();
			
			Assert.assertEquals(successMsg, "Your event has been scheduled!");
			
			driver.navigate().refresh();
			
		}
		
	
		
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}

}
