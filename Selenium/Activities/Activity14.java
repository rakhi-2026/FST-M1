package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity14 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/tables");
			System.out.println("The page title is : "+ driver.getTitle());
			
			System.out.println("The number of rows and columns in the table and print them");
			List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			
			System.out.println("The number of columns in the table : "+ cols.size());
			System.out.println("The number of rows in the table : "+ rows.size());
			
			System.out.println("print the Book Name in the 5th row : " + driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
			
			System.out.println("Click the header of the Price column to sort it in ascending order");
			driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th[5]")).click();
			
			
			System.out.println("Find and print the cell value at the fifth row again ....");
			System.out.println("print the Book Name in the 5th row : " + driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
			
			driver.quit();

	}

}
