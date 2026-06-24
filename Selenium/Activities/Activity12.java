package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity12 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/drag-drop");
			System.out.println("The page title is : "+ driver.getTitle());
			Actions builder = new Actions(driver);
			
			WebElement ball = driver.findElement(By.xpath("//img[@id='ball']"));
			WebElement dropZone1 = driver.findElement(By.xpath("//div[@id='dropzone1']"));
			WebElement dropZone2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));
			
			builder.click(ball).dragAndDrop(ball, dropZone1).build().perform();
			WebElement txtVerifyDropZone1 = driver.findElement(By.xpath("//div[@id='dropzone1']/span"));
			System.out.println("The confirmation text from dropzone 1 is : "+txtVerifyDropZone1.getText());
			
			builder.click(ball).dragAndDrop(ball, dropZone2).build().perform();
			WebElement txtVerifyDropZone2 = driver.findElement(By.xpath("//div[@id='dropzone2']/span"));
			System.out.println("The confirmation text from dropzone 2 is : "+txtVerifyDropZone2.getText());
			
			driver.quit();

	}

}
