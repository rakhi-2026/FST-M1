package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass {
	
	Alert alert;
	
	@Given("User is on the page")
	public void openTSHomePage() {
		
		driver.get("https://training-support.net/webelements/alerts");
		Assertions.assertEquals(driver.getTitle(), "Selenium: Alerts");
		wait.until(ExpectedConditions.titleContains("Selenium: Alerts"));
	}
	
	@When("User clicks the Simple Alert button")
	public void clickSimpleButton() {
		
		
		WebElement btnSimple = driver.findElement(By.xpath("//button[@id='simple']"));
		btnSimple.click();
		
	}
	
	@When("User clicks the Confirm Alert button")
	public void clickConfirmButton() {
		
		WebElement btnConfirm = driver.findElement(By.xpath("//button[@id='confirmation']"));
		btnConfirm.click();
		
	}
	
	@When("User clicks the Prompt Alert button")
	public void clickPromptButton() {
		
		WebElement btnPrompt = driver.findElement(By.xpath("//button[@id='prompt']"));
		btnPrompt.click();
		
	}
	
	@And("Alert opens")
	public void validateAlertisOpened() {
		
		alert = driver.switchTo().alert();
		
	}
	
	@And("Read the text from it and print it")
	public void readAlertText() {
		
		System.out.println("Alert Message : "+ alert.getText());
		
	}
	
	
	@And("Write a custom message in it")
	public void writecustomMsg() {
		
		alert.sendKeys("Awesome!");
		
	}
	
	
	@And("Close the alert")
	public void closeAlert() {
		
		alert.accept();
		
	}
	
	@And("Close the alert with Cancel")
	public void closeAlertCancel() {
		
		alert.dismiss();
		
	}
	@Then("Read the result text")
	public void validateConfirmationMsg() {
		
		
		WebElement message = driver.findElement(By.cssSelector("p#result"));
		System.out.println("The result message is : "+message);
	}

}
