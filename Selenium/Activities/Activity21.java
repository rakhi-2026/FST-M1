package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity21 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			driver.get("https://training-support.net/webelements/tabs");
			System.out.println("The page title is : "+ driver.getTitle());
			String parentWindow = driver.getWindowHandle();
			System.out.println("Parent Window handle is : "+parentWindow);
			
			WebElement btnNewTab =  driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
			btnNewTab.click();
			
			explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));
			System.out.println("Number of tabs opened : " + driver.getWindowHandles().size());
			
			for(String handle : driver.getWindowHandles()) {
				System.out.println("Window handle is : "+handle);
				driver.switchTo().window(handle);
			}
			
			explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open Another One']")));
			
			System.out.println("The new Tab Title : " + driver.getTitle());
			System.out.println("The message is : "+(driver.findElement(By.cssSelector("h2.mt-5")).getText()));
			
			String secondParentWindow = driver.getWindowHandle();
			System.out.println("Second Parent Window handle is : "+secondParentWindow);
			WebElement btnAnotherOne = driver.findElement(By.xpath("//button[text()='Open Another One']"));
			btnAnotherOne.click();
			
			explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));
			
			for(String handle : driver.getWindowHandles()) {
				System.out.println("Window handle is : "+handle);
				driver.switchTo().window(handle);
			}
			
			explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open Another One']")));
			
			System.out.println("The second new Tab Title : " + driver.getTitle());
			System.out.println("The message in second new tab is : "+(driver.findElement(By.cssSelector("h2.mt-5")).getText()));
			
			driver.quit();

	}

}
