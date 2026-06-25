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

public class Activity17 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			driver.get("https://training-support.net/webelements/selects");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement multiSelect = driver.findElement(By.cssSelector("select.h-80"));
			Select select = new Select(multiSelect);
			
			select.deselectByIndex(0);
			select.selectByVisibleText("HTML");
			for(int i = 3; i<6;i++) {
				select.selectByIndex(i);
			}
			
			List<WebElement> selectedOptions = select.getAllSelectedOptions();
			for(WebElement e : selectedOptions) {
				System.out.println("Selected Options : " + e.getText());
			}
			
			select.selectByValue("nodejs");
			
			select.deselectByIndex(4);
			List<WebElement> selectedOptions1 = select.getAllSelectedOptions();
			for(WebElement e : selectedOptions1) {
				System.out.println("Selected Options : " + e.getText());
			}
			
			driver.quit();

	}

}
