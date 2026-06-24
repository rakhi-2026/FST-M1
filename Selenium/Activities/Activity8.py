from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print(f"The page title is : {driver.title}")
	
    explicitwait  = WebDriverWait(driver,10)
    print(f"The page title is : {driver.title}")
	
    chkBox = driver.find_element(By.XPATH,"//input[@id = 'checkbox']")
    print(f"Is the checkbox visible on the page ? : {chkBox.is_displayed()}")
    btnToggle =  driver.find_element(By.XPATH,"//button[text() = 'Toggle Checkbox']")
    btnToggle.click()
    explicitwait.until(EC.invisibility_of_element(chkBox))
    print(f"Is the checkbox visible on the page ? After clicking on toggle button : {chkBox.is_displayed()}")
			
    btnToggle.click()
    explicitwait.until(EC.element_to_be_clickable(chkBox)).click()
			
    print(f"Toggle button is clicked again to make the Checkbox is visible . Checkbox is selected : {chkBox.is_selected()}")
    driver.quit()