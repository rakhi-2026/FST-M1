package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity8 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/dynamic-controls");
			WebDriverWait explicitwait  =  new WebDriverWait(driver,Duration.ofSeconds(10));
			
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement chkBox = driver.findElement(By.xpath("//input[@id = 'checkbox']"));
			System.out.println("Is the checkbox visible on the page ? : " + chkBox.isDisplayed());
			WebElement btnToggle =  driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']"));
			btnToggle.click();
			
			explicitwait.until(ExpectedConditions.invisibilityOf(chkBox));
			System.out.println("Is the checkbox visible on the page ? After clicking on toggle button : " + chkBox.isDisplayed());
			
			btnToggle.click();
			explicitwait.until(ExpectedConditions.elementToBeClickable(chkBox)).click();
			
			System.out.println("Toggle button is clicked again to make the Checkbox is visible . Checkbox is selected : " + chkBox.isSelected());
			
			driver.quit();

	}

}
