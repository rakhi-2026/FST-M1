from selenium import webdriver
from selenium.webdriver.common.by import By



with webdriver.Firefox() as driver:
	
    driver.get("https://training-support.net/webelements/alerts")
    print(f"The page title is : {driver.title}")
			
    btnPrompt =  driver.find_element(By.CSS_SELECTOR,"button#prompt")
    result = driver.find_element(By.CSS_SELECTOR,"p#result")
			
    btnPrompt.click();
    alert = driver.switch_to.alert
    print(f"The text on the simple alert is : {alert.text}")
    alert.send_keys("Awesome")
    alert.accept()
    print(f"Result message is : {result.text}")
    driver.quit()