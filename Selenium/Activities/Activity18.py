from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver :
    driver.get("https://training-support.net/webelements/alerts")
    print(f"The page title is : {driver.title}")

    btnSimple =  driver.find_element(By.CSS_SELECTOR,"button#simple")
    btnSimple.click();
			
    alert = driver.switch_to.alert
    print(f"The text on the simple alert is : {alert.text}")
    alert.accept()
    driver.quit()