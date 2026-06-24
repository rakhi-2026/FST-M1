package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity10 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/mouse-events");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement confirmTxtElement = driver.findElement(By.xpath("//p[@id = 'result']"));
			WebElement lockBtn= driver.findElement(By.xpath("//h1[text() = 'Cargo.lock']/ancestor::div[@role = 'button']"));
			WebElement tomlBtn = driver.findElement(By.xpath("//h1[text() = 'Cargo.toml']/ancestor::div[@role = 'button']"));
			WebElement srcBtn = driver.findElement(By.xpath("//h1[text() = 'src']/ancestor::div[@role = 'button']"));
			WebElement targetBtn = driver.findElement(By.xpath("//h1[text() = 'target']/ancestor::div[@role = 'button']"));
			
			Actions builder = new Actions(driver);
			
			builder.click(lockBtn).pause(5000).moveToElement(tomlBtn).click(tomlBtn).build().perform();
			System.out.println("The confirmation text is : "+confirmTxtElement.getText());
			
			builder.doubleClick(srcBtn).pause(2000).moveToElement(targetBtn).contextClick(targetBtn).build().perform();
			System.out.println("The confirmation text is : "+confirmTxtElement.getText());
			driver.quit();

	}

}
