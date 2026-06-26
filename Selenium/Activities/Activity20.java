package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity20 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement btnPrompt =  driver.findElement(By.cssSelector("button#prompt"));
			WebElement result = driver.findElement(By.cssSelector("p#result"));
			
			btnPrompt.click();
			
			Alert alert = driver.switchTo().alert();
			System.out.println("The text on the simple alert is : "+alert.getText());
			alert.sendKeys("Awesome");
			alert.accept();
			System.out.println("Result message is : " + result.getText());
				driver.quit();

	}

}
