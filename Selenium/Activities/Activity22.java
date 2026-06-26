package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity22 {

	public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();
			WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			driver.get("https://training-support.net/webelements/popups");
			System.out.println("The page title is : "+ driver.getTitle());
			
			WebElement btnPopUp =  driver.findElement(By.cssSelector("button#launcher"));
			btnPopUp.click();
			
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#popup")));
			
			WebElement txtUsername = driver.findElement(By.cssSelector("[name='username']"));
			WebElement txtPassword = driver.findElement(By.cssSelector("[name='password']"));
			WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
			
			txtUsername.sendKeys("admin");
			txtPassword.sendKeys("password");
			btnSubmit.click();
			
			explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome Back, Admin!"));
			
			System.out.println("The message is : "+(driver.findElement(By.cssSelector("h2.mt-5")).getText()));
			
			
			driver.quit();

	}

}
