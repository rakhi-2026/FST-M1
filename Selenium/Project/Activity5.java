package OrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;



// Goal: Edit a user’s information
public class Activity5 {
	
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
	
	@DataProvider(name = "userData")
	public static Object[][] fetchEmpData(){
		
		List<List<String>> inputData = ReadExcel.readExcelData("src/test/resources/input.xlsx","userDetails");
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
	
	@Test(priority = 1 , dataProvider = "userData")
	public void editEmployeeInfo(String firstName,String lastName,String nationality,String dob) throws InterruptedException {
		
		WebElement myInfo = driver.findElement(By.xpath("//b[normalize-space()='My Info']"));
		myInfo.click();
		
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Personal Details']")));
		WebElement btnSave = driver.findElement(By.xpath("//input[@id='btnSave']"));
		btnSave.click();
		
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		WebElement txtxLastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		
		WebElement nationalityDropdown = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
		Select selectNationality = new Select(nationalityDropdown);
		
		WebElement DOB = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		txtxLastName.clear();
		txtxLastName.sendKeys(lastName);
		selectNationality.selectByVisibleText(nationality);
		DOB.clear();
		DOB.sendKeys(dob);
		Thread.sleep(5000);
		btnSave.click();
	}
	

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
