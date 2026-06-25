package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity15 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			driver.get("https://training-support.net/webelements/dynamic-attributes");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement txtFullName = driver.findElement(By.xpath("//input[@placeholder='Full name']"));
			WebElement txtEmail = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
			WebElement txtEventTime = driver.findElement(By.xpath("//input[@data-testid='event-date']"));
			WebElement txtAdditionalDetails = driver.findElement(By.xpath("//textarea[contains(@name,'additional-details')]"));
			WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
			
			WebElement btnConfirmMsg =  driver.findElement(By.xpath("//h3[@id='action-confirmation']"));
			
			txtFullName.sendKeys("Rakhi Das");
			txtEmail.sendKeys("rakhids08@gmail.com");
			txtEventTime.sendKeys("2026-08-08");
			txtAdditionalDetails.sendKeys("Home Party");
			
			btnSubmit.click();
			
			String msg = wait.until(ExpectedConditions.visibilityOf(btnConfirmMsg)).getText();
			System.out.println("Status message is : "+msg);
			driver.quit();

	}

}
