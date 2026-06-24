package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity4 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/target-practice");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement header3 = driver.findElement(By.xpath("//h3[contains(text(),'#3')]"));
			System.out.println("The text in third header : " + header3.getText());
			
			WebElement header5 = driver.findElement(By.xpath("//h5[contains(text(),'#5')]"));
			Color color = Color.fromString(header5.getCssValue("color"));
			
			System.out.println("The colour of the fifth header : " + color.asRgb());
			
			
			WebElement purpleBtn = driver.findElement(By.xpath("//button[text() = 'Purple']"));
			System.out.println("The classes of purple button are : " + purpleBtn.getAttribute("class"));
			
			WebElement slateBtn = driver.findElement(By.xpath("//button[text() = 'Slate']"));
			System.out.println("The text of slate button is : " + slateBtn.getText());
			driver.quit();

	}

}
