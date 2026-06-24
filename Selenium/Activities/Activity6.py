from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls");
    print(f"The page title is : {driver.title}")
			
    chkBox = driver.find_element(By.XPATH,"//input[@id = 'checkbox']")
    print(f"Is the checkbox visible on the page ? : {chkBox.is_displayed()}")
    print(f"If the checkbox is selected : {chkBox.is_selected()}")
    chkBox.click()
    print(f"If the checkbox is selected : {chkBox.is_selected()}")
    driver.quit()