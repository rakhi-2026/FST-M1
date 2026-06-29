package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
	
	@Given("The user is on the login page")
	public void openTSHomePage() {
		
		driver.get("https://training-support.net/webelements/login-form");
		Assertions.assertEquals(driver.getTitle(), "Selenium: Login Form");
	}
	
	@When("the user enters username and password")
	public void enterCredentials() {
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		
	}
	
	
	@When("the user enters {string} and {string}")
	public void enterCredentialsFromInput(String usernameVal , String passwordVal) {
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		
		username.sendKeys(usernameVal);
		password.sendKeys(passwordVal);
		
	}
	
	@And("clicks the submit button")
	public void clickButton() {
		
		WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
		btnSubmit.click();
		
	}
	
	@Then("get the confirmation message and verify it")
	public void validateConfirmationMsg() {
		
		wait.until(ExpectedConditions.titleContains("Login Success"));
		WebElement message1 = driver.findElement(By.cssSelector("h1.text-center"));
		WebElement message2 = driver.findElement(By.cssSelector("h2.mt-5"));
		
		Assertions.assertEquals(message1.getText(), "Login Success!");
		Assertions.assertEquals(message2.getText(), "Welcome Back, Admin!");
	}
	
	@Then("get the confirmation text and verify message as {string}")
	public void validateConfirmationMsgFromInput(String expectedMessage) {
		
		String actualMessage = "";
		if(expectedMessage.contains("Welcome Back")) {
			wait.until(ExpectedConditions.titleContains("Login Success"));
			 actualMessage = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		}else {
			wait.until(ExpectedConditions.titleContains("Login Form"));
			actualMessage = driver.findElement(By.cssSelector("h2#subheading")).getText();
		}
			
		Assertions.assertEquals(actualMessage, expectedMessage);
	}

}
