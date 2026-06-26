from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
import selenium.webdriver.support.expected_conditions as EC


with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/popups")
    print(f"The page title is : {driver.title}")

    explicitWait = WebDriverWait(driver,5)

    btnPopUp =  driver.find_element(By.CSS_SELECTOR,"button#launcher")
    btnPopUp.click()

    explicitWait.until(EC.visibility_of_element_located((By.CSS_SELECTOR,"div#popup")))

    txtUsername = driver.find_element(By.CSS_SELECTOR,"[name='username']")
    txtPassword = driver.find_element(By.CSS_SELECTOR,"[name='password']")
    btnSubmit = driver.find_element(By.XPATH,"//button[text()='Submit']")


    txtUsername.send_keys("admin")
    txtPassword.send_keys("password")
    btnSubmit.click()
			
    explicitWait.until(EC.text_to_be_present_in_element((By.CSS_SELECTOR,"h2.mt-5"), "Welcome Back, Admin!"))
    print(f"The message is : {(driver.find_element(By.CSS_SELECTOR,"h2.mt-5")).text}")
    
    driver.quit()


