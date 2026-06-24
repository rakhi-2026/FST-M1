package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity5 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/dynamic-controls");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement chkBox = driver.findElement(By.xpath("//input[@id = 'checkbox']"));
			System.out.println("Is the checkbox visible on the page ? : " + chkBox.isDisplayed());
			
			WebElement btnToggle =  driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']"));
			
			if(chkBox.isDisplayed()) {
				btnToggle.click();
				System.out.println("If the checkbox is visible : " +chkBox.isDisplayed());
				
			}
			
			driver.quit();

	}

}
