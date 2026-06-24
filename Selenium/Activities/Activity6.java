package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity6 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/dynamic-controls");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement chkBox = driver.findElement(By.xpath("//input[@id = 'checkbox']"));
			System.out.println("Is the checkbox visible on the page ? : " + chkBox.isDisplayed());
			
			System.out.println("If the checkbox is selected : " +chkBox.isSelected());
			
			chkBox.click();
				
			System.out.println("If the checkbox is selected : " +chkBox.isSelected());
			
			driver.quit();

	}

}
