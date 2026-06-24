from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"The page title is : {driver.title}")
	
    txtBox = driver.find_element(By.XPATH,"//input[@id = 'textInput']")
    enableInputButton  =  driver.find_element(By.XPATH,"//button[text() = 'Enable Input']")
    print(f"Is the text box visible on the page ? : {txtBox.is_displayed()}")
    print(f"If the textBox is enabled : {txtBox.is_enabled()}")
    enableInputButton.click()
    print(f"If the textBox is enabled : {txtBox.is_enabled()}")
    driver.quit()