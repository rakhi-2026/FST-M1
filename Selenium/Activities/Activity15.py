from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    print(f"The page title is : {driver.title}")

    wait = WebDriverWait(driver,10)

    txtFullName = driver.find_element(By.XPATH,"//input[@placeholder='Full name']")
    txtEmail = driver.find_element(By.XPATH,"//input[@placeholder='Email Address']")
    txtEventTime = driver.find_element(By.XPATH,"//input[@data-testid='event-date']")
    txtAdditionalDetails = driver.find_element(By.XPATH,"//textarea[contains(@name,'additional-details')]")
    btnSubmit = driver.find_element(By.XPATH,"//button[text()='Submit']")
    btnConfirmMsg =  driver.find_element(By.XPATH,"//h3[@id='action-confirmation']")
			
    txtFullName.send_keys("Rakhi Das")
    txtEmail.send_keys("rakhids08@gmail.com")
    txtEventTime.send_keys("2026-08-08")
    txtAdditionalDetails.send_keys("Home Party")
			
    btnSubmit.click();
			
    msg = wait.until(EC.visibility_of(btnConfirmMsg)).text
    print(f"Status message is : {msg}")
    driver.quit()