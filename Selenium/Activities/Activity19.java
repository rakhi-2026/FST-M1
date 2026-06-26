package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity19 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/alerts");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement btnConfirm =  driver.findElement(By.cssSelector("button#confirmation"));
			WebElement result = driver.findElement(By.cssSelector("p#result"));
			
			btnConfirm.click();
			
			Alert alert = driver.switchTo().alert();
			System.out.println("The text on the simple alert is : "+alert.getText());
			alert.accept();
			System.out.println("Result message is : " + result.getText());
			
			btnConfirm.click();
			
			driver.switchTo().alert();
			System.out.println("The text on the simple alert is : "+alert.getText());
			alert.dismiss();
			System.out.println("Result message is : " + result.getText());
			
			driver.quit();

	}

}
