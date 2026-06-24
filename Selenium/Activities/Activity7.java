package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity7 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/dynamic-controls");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement txtBox = driver.findElement(By.xpath("//input[@id = 'textInput']"));
			WebElement enableInputButton  =  driver.findElement(By.xpath("//button[text() = 'Enable Input']"));
			System.out.println("Is the text box visible on the page ? : " + txtBox.isDisplayed());
			
			System.out.println("If the textBox is enabled : " +txtBox.isEnabled());
			
			enableInputButton.click();
				
			System.out.println("If the textBox is enabled : " +txtBox.isEnabled());
			
			driver.quit();

	}

}
