package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity11 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/keyboard-events");
			System.out.println("The page title is : "+ driver.getTitle());
			
			
			Actions builder = new Actions(driver);
			
			builder.sendKeys("Typing from Selenium").sendKeys(Keys.RETURN).build().perform();
			WebElement txt = driver.findElement(By.xpath("//p[@id='result']/following-sibling::h1"));
			System.out.println("The confirmation text is : "+txt.getText());
			
			driver.quit();

	}

}
