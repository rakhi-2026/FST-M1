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



// Goal: Add an employee and their details to the site
public class Activity4 {
	
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
	
	@DataProvider(name = "empData")
	public static Object[][] fetchEmpData(){
		
		List<List<String>> inputData = ReadExcel.readExcelData("src/test/resources/input.xlsx","empDetails");
		Object[][] data = new Object[inputData.size()][];
		for (int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i).toArray();
		}
		return data;
		
	}
	
	@Test(priority = 0 , dataProvider = "loginData")
	public void login(String userNameVal,String passwordVal) {
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement btnLogin = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		userName.sendKeys(userNameVal);
		passWord.sendKeys(passwordVal);
		btnLogin.click();
		
		
	}
	
	@Test(priority = 1 , dataProvider = "empData")
	public void addEmployee(String firstName,String lastName) {
		
		WebElement PIM = driver.findElement(By.xpath("//b[normalize-space()='PIM']"));
		PIM.click();
		WebElement addEmployee = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		addEmployee.click();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Add Employee']")));
		
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement txtxLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		WebElement btnSave = driver.findElement(By.xpath("//input[@id='btnSave']"));
		
		txtFirstName.sendKeys(firstName);
		txtxLastName.sendKeys(lastName);
		
		btnSave.click();
	}
	
	@Test(priority = 2 , dataProvider = "empData")
	public void verifyEmployee(String firstName,String lastName) {
		
		String expectedEmpName = firstName + " " + lastName;
		
		WebElement PIM = driver.findElement(By.xpath("//b[normalize-space()='PIM']"));
		PIM.click();
		WebElement employeeList = driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
		employeeList.click();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='empsearch_employee_name_empName']")));
		
		WebElement txtSearchEmployeeName= driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
		WebElement btnSearch = driver.findElement(By.xpath("//input[@id='searchBtn']"));
		
		txtSearchEmployeeName.sendKeys(expectedEmpName);
		btnSearch.click();
		
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr/td[contains(.,'Rakhi')]")));
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
