package OrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;



// Goal: Login and apply for a leave on the HRM site
public class Activity8 {
	
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
	
	@DataProvider(name = "leaveData")
	public static Object[][] fetchEmpData(){
		
		List<List<String>> inputData = ReadExcel.readExcelData("src/test/resources/input.xlsx","leaveDetails");
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
	
	@Test(priority = 1 , dataProvider = "leaveData")
	public void applyLeave(String leaveType,String from,String to) throws InterruptedException {
		
		
		WebElement dashboard = driver.findElement(By.xpath("//b[normalize-space()='Dashboard']"));
		dashboard.click();
		Thread.sleep(5000);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
		WebElement applyLeave = driver.findElement(By.xpath("//span[text()='Apply Leave']"));
		
		applyLeave.click();
		
		WebElement leaveTypeDropdown = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
		Select leave = new Select(leaveTypeDropdown);
		WebElement txtFrom = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
		WebElement txtTo = driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
		WebElement btnApply = driver.findElement(By.xpath("//input[@id='applyBtn']"));
		
		Actions action = new Actions(driver);
		leave.selectByVisibleText(leaveType);
		Thread.sleep(2000);
		
		txtFrom.clear();
		txtFrom.sendKeys(from);
		
		Thread.sleep(2000);
		txtTo.clear();
		txtTo.sendKeys(to);
		Thread.sleep(2000);
		action.moveToElement(btnApply).click().build().perform();
		Thread.sleep(2000);
		
		
	}
	

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
