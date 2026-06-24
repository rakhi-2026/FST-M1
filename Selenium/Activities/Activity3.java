package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println("Page title is : "+driver.getTitle());
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
		WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("admin");
		password.sendKeys("password");
		btnSubmit.click();
		Thread.sleep(2000);
		System.out.println("Login Success ! ");
		System.out.println("New Page title is : "+driver.getTitle());
	    driver.quit();
	}
}
