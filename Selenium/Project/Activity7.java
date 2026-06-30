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



// Goal: Add employee qualifications
public class Activity7 {
	
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
	
	@DataProvider(name = "qualificationData")
	public static Object[][] fetchEmpData(){
		
		List<List<String>> inputData = ReadExcel.readExcelData("src/test/resources/input.xlsx","qualificationDetails");
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
	
	@Test(priority = 1 , dataProvider = "qualificationData")
	public void addQualification(String company,String jobTitle,String from,String to) throws InterruptedException {
		
		
		WebElement myInfo = driver.findElement(By.xpath("//b[normalize-space()='My Info']"));
		myInfo.click();
		Thread.sleep(5000);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Personal Details']")));
		WebElement qualification = driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]"));
		
		qualification.click();
		
		WebElement btnAdd = driver.findElement(By.xpath("//input[@id='addWorkExperience']"));
		btnAdd.click();
		
		WebElement txtCompany = driver.findElement(By.xpath("//input[@id='experience_employer']"));
		WebElement txtJobTitle = driver.findElement(By.xpath("//input[@id='experience_jobtitle']"));
		WebElement txtFrom = driver.findElement(By.xpath("//input[@id='experience_from_date']"));
		WebElement txtTo = driver.findElement(By.xpath("//input[@id='experience_to_date']"));
		WebElement btnSave = driver.findElement(By.xpath("//input[@id='btnWorkExpSave']"));
		
		txtCompany.sendKeys(company);
		Thread.sleep(2000);
		txtJobTitle.sendKeys(jobTitle);
		Thread.sleep(2000);
		txtFrom.clear();
		txtFrom.sendKeys(from);
		
		Thread.sleep(2000);
		txtTo.clear();
		txtTo.sendKeys(to);
		Thread.sleep(2000);
		btnSave.click();
		Thread.sleep(2000);
		
		List<WebElement> workExpTableRows = driver.findElements(By.xpath("//div[@id='sectionWorkExperience']//table[contains(@class,'hover')]/tbody/tr"));
		List<WebElement> workExpTableCols = driver.findElements(By.xpath("//div[@id='sectionWorkExperience']//table[contains(@class,'hover')]/tbody/tr[1]/td"));
		
		for (int i = 0 ; i < workExpTableRows.size() ; i++) {
			String actCompany = workExpTableCols.get(0).getText();
			String actJobTitle = workExpTableCols.get(1).getText();
			String actFrom = workExpTableCols.get(2).getText();
			String actTo = workExpTableCols.get(3).getText();
			if (actCompany == company && actJobTitle == jobTitle && actFrom == from && actTo == to) {
				break;
			}
		}
			
		
		
	}
	

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
