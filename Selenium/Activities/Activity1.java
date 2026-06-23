package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		System.out.println("Page title is : "+driver.getTitle());
		WebElement element = driver.findElement(By.linkText("About Us"));
		element.click();
		System.out.println("About Us has been clicked");
		System.out.println("New Page title is : "+driver.getTitle());
	    driver.quit();
	}

}
