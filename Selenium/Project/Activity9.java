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



// Goal: Login and retrieve the emergency contacts for the user
public class Activity9 {
	
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
	
	@Test(priority = 1)
	public void applyLeave() throws InterruptedException {
		
		
		WebElement myInfo = driver.findElement(By.xpath("//b[normalize-space()='My Info']"));
		myInfo.click();
		Thread.sleep(5000);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Personal Details']")));
		WebElement emergencyContacts = driver.findElement(By.xpath("//a[normalize-space()='Emergency Contacts']"));
		
		emergencyContacts.click();
		Thread.sleep(5000);
		
		List<WebElement> emergencyContactsTableRows = driver.findElements(By.xpath("//div[@id='listEmegrencyContact']//table[contains(@class,'hover')]/tbody/tr"));
		List<WebElement> emergencyContactsTableCols = driver.findElements(By.xpath("//div[@id='listEmegrencyContact']//table[contains(@class,'hover')]/tbody/tr[1]/td"));
		System.out.println("rows : " +  emergencyContactsTableRows.size());
		System.out.println("columns : " +  emergencyContactsTableCols.size());
		
		for (int i = 0 ; i < emergencyContactsTableRows.size() ; i++) {
			String name = emergencyContactsTableCols.get(1).getText();
			String relationship = emergencyContactsTableCols.get(2).getText();
			String homeTelephone = emergencyContactsTableCols.get(3).getText();
			String mobile = emergencyContactsTableCols.get(4).getText();
			String workTelephone = emergencyContactsTableCols.get(5).getText();
			System.out.println(" Personal Details : name : " + name + " relationship : " + relationship + " home telephone : " + homeTelephone + " mobile : " + mobile + " workTelephone : " + workTelephone);
		}
		
		
	}
	

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
