package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity9 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/dynamic-content");
			WebDriverWait explicitwait  =  new WebDriverWait(driver,Duration.ofSeconds(10));
			
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement button = driver.findElement(By.xpath("//button[@id = 'genButton']"));
			
			button.click();
			
			if (explicitwait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("word")), "release"))) {
				System.out.println("The text is visible : "+ driver.findElement(By.id("word")).getText());
			}
			
			
			driver.quit();

	}

}
