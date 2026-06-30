package OrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;



// Goal: Verify that the “Directory” menu item is visible and clickable
public class Activity6 {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void openBrowser() {
			
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://hrm.alchemy.hguy.co/");
		String title =  driver.getTitle();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divLogo']/img")));
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@DataProvider(name = "loginData")
	public static Object[][] fetchLoginData(){
		
		List<List<String>> inputData = ReadExcel.readExcelData("src/test/resources/input.xlsx","login");
		Object[][] data = new Object[inputData.size()][];
		for (int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i).toArray();
		}
		return data;
		
	}
	

	
	@Test(priority = 0 , dataProvider = "loginData")
	public void login(String userNameVal,String passwordVal) throws InterruptedException {
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement btnLogin = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		userName.sendKeys(userNameVal);
		passWord.sendKeys(passwordVal);
		btnLogin.click();
		Thread.sleep(5000);
		
	}
	
	
	@Test
	public void verifyDirectoryMenu() throws InterruptedException {
		
		WebElement directoryMenu = driver.findElement(By.xpath("//b[normalize-space()='Directory']"));
		directoryMenu.click();
		Thread.sleep(5000);
		String headerText = driver.findElement(By.xpath("//h1[normalize-space()='Search Directory']")).getText();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Search Directory']")));
		Assert.assertEquals(headerText, "Search Directory");
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
