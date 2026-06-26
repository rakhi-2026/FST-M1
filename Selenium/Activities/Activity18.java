package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity18 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement btnSimple =  driver.findElement(By.cssSelector("button#simple"));
			btnSimple.click();
			
			Alert alert = driver.switchTo().alert();
			System.out.println("The text on the simple alert is : "+alert.getText());
			alert.accept();
			driver.quit();

	}

}
