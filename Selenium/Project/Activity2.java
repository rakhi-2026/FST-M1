package OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;



// Goal: Print the url of the header image to the console
public class Activity2 {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void openBrowser() {
			
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@Test
	public void fetchHeaderImgURL() {
		driver.get("https://hrm.alchemy.hguy.co/");
		String title =  driver.getTitle();
		WebElement headerImg = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divLogo']/img")));
		Assert.assertEquals(title, "OrangeHRM");
		String url = headerImg.getAttribute("src");
		System.out.println("URL is : "+url);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
