from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/alerts")
    print(f"The page title is : {driver.title}")

    btnConfirm =  driver.find_element(By.CSS_SELECTOR,"button#confirmation")
    result = driver.find_element(By.CSS_SELECTOR,"p#result")

    btnConfirm.click()

    alert = driver.switch_to.alert
    print(f"The text on the simple alert is : {alert.text}")
    alert.accept()
    print(f"Result message is : {result.text}")
			
    btnConfirm.click()
    driver.switch_to.alert
    print(f"The text on the simple alert is : {alert.text}")
    alert.dismiss()

    print(f"Result message is : {result.text}")
    driver.quit()