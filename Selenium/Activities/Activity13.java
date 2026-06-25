package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity13 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/tables");
			System.out.println("The page title is : "+ driver.getTitle());
			
			System.out.println("The number of rows and columns in the table and print them");
			List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			
			System.out.println("The number of columns in the table : "+ cols.size());
			System.out.println("The number of rows in the table : "+ rows.size());
			
			System.out.println("Find and print all the cell values in the third row of the table....");
			
			List<WebElement> thirdRow =  driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
			for (WebElement cell : thirdRow){
				System.out.println(cell.getText());
				
			}
			
			System.out.println("Find and print the cell value at the second row second column....");
			System.out.println("Second row second column value is : " + driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
			driver.quit();

	}

}
