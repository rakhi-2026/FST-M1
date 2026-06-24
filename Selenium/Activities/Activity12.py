from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/drag-drop")
    print(f"The page title is : {driver.title}")
    builder = webdriver.ActionChains(driver)
			
    ball = driver.find_element(By.XPATH,"//img[@id='ball']")
    dropZone1 = driver.find_element(By.XPATH,"//div[@id='dropzone1']")
    dropZone2 = driver.find_element(By.XPATH,"//div[@id='dropzone2']")
			
    builder.click(ball).drag_and_drop(ball, dropZone1).perform()
    txtVerifyDropZone1 = driver.find_element(By.XPATH,"//div[@id='dropzone1']/span")
    print(f"The confirmation text from dropzone 1 is : {txtVerifyDropZone1.text}")
			
    builder.click(ball).drag_and_drop(ball, dropZone2).perform()
    txtVerifyDropZone2 = driver.find_element(By.XPATH,"//div[@id='dropzone2']/span")
    print(f"The confirmation text from dropzone 2 is : {txtVerifyDropZone2.text}")
    driver.quit()