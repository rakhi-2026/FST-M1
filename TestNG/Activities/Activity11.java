package Activities;

import java.io.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity11 {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
		@BeforeClass
		public void openBrowser() {
				
			driver = new FirefoxDriver();
			explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.get("https://training-support.net/webelements/simple-form");
			System.out.println("The page title is : " +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium: Simple Form");
			
		}
		
		public static List<List<String>> readExcel(String filePath) {
			// Creating the base list
			List<List<String>> data = new ArrayList<>();
	 
			// Create the workbook object
			Workbook excelFile;
			try {
				excelFile = new XSSFWorkbook(new FileInputStream(filePath));
	 
				// Select the sheet from the workbook
				Sheet sheet1 = excelFile.getSheetAt(0);
	 
				// Iterate through the rows in the sheet
				for (Row rows : sheet1) {
					// To skip the first row
					if (rows.getRowNum() == 0) {
						continue;
					}
					// Create a temp list to store one row's data
					List<String> rowData = new ArrayList<>();
					// Iterate through the cells in each row
					for (Cell cells : rows) {
						switch (cells.getCellType()) {
						case STRING:
							// To get string values
							rowData.add(cells.getStringCellValue().trim());
							break;
	 
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cells)) {
								// To get dates
								rowData.add(cells.getLocalDateTimeCellValue()
									.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
							} else {
								// To get numbers
								rowData.add(String.valueOf(cells.getNumericCellValue()));
							}
							break;
						default:
							// Add a placeholder string for empty cells
							rowData.add("-");
						}
					}
	 
					// Add the temp list to the base list
					data.add(rowData);
	 
					// Close the file
					excelFile.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	 
			// Return the base list to the DataProvider
			return data;
		}
	 
		@DataProvider(name = "excelDataProvider")
		public static Object[][] inputData() throws Exception{
			// Data from the Excel file
			List<List<String>> inputData = readExcel("src/test/resources/input.xlsx");
	 
			// Convert the data into a 2D array dataset
			// This is the dataset that will be passed to the test functions
			Object[][] data = new Object[inputData.size()][];
			for (int i = 0; i < inputData.size(); i++) {
				data[i] = inputData.get(i).toArray();
			}
	 
			// Return the dataset
			return data;
		}
				
				
		@Test(dataProvider = "excelDataProvider")
		public void submitForm(String fullName,String email,String eventDate,String details) {
			
			WebElement txtFullName = driver.findElement(By.xpath("//input[@name='full-name']"));
			WebElement txtEmail = driver.findElement(By.xpath("//input[@name = 'email']"));
			WebElement txtEventDt = driver.findElement(By.xpath("//input[@name='event-date']"));
			WebElement txtAdditionalDetails = driver.findElement(By.xpath("//textarea[@name='additional-details']"));
			WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
			
			txtFullName.sendKeys(fullName);
			txtEmail.sendKeys(email);
			txtEventDt.click();
			System.out.println("Event Date = " + eventDate);
			txtEventDt.sendKeys(eventDate);
			txtAdditionalDetails.sendKeys(details);
			
			btnSubmit.click();
			explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.text-center")));
			String successMsg = driver.findElement(By.cssSelector("h3.text-center")).getText();
			
			Assert.assertEquals(successMsg, "Your event has been scheduled!");
			
			driver.navigate().refresh();
			
		}
		
	
		
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}

}
