package OrangeHRM;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;



// Goal: Read the title of the website and verify the text
public class Activity1 {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void openBrowser() {
			
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@Test
	public void verifyWebSiteTitle() {
		driver.get("https://hrm.alchemy.hguy.co/");
		String title =  driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
