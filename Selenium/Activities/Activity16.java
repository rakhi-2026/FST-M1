package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity16 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			driver.get("https://training-support.net/webelements/selects");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement singleSelect = driver.findElement(By.cssSelector("select.h-10"));
			Select select = new Select(singleSelect);
			
			select.selectByVisibleText("Two");
			select.selectByIndex(3);
			select.selectByValue("four");
			
			List<WebElement> options = select.getOptions();
			
			for(WebElement e : options) {
				System.out.println(e.getText());
			}
			
			driver.quit();

	}

}
