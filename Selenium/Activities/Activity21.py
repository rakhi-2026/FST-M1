from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
import selenium.webdriver.support.expected_conditions as EC


with webdriver.Firefox() as driver:
    
    explicitWait = WebDriverWait(driver,5)
    driver.get("https://training-support.net/webelements/tabs");
    print(f"The page title is : {driver.title}")
    
    parentWindow = driver.current_window_handle
    print(f"Parent Window handle is : {parentWindow}")
			
    btnNewTab =  driver.find_element(By.XPATH,"//button[text()='Open A New Tab']")
    btnNewTab.click()
			
    explicitWait.until(EC.number_of_windows_to_be(2))
    print(f"Number of tabs opened : {len(driver.window_handles)}")
			
    for handle in driver.window_handles :
        print(f"Window handle is : {handle}")
        driver.switch_to.window(handle)

    explicitWait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH,"//button[text()='Open Another One']")))
    print(f"The new Tab Title : {driver.title}")
    print(f"The message is : {(driver.find_element(By.CSS_SELECTOR,"h2.mt-5")).text}")
	
    secondParentWindow = driver.current_window_handle
    print(f"Second Parent Window handle is : {secondParentWindow}")
    
    btnAnotherOne = driver.find_element(By.XPATH,"//button[text()='Open Another One']")
    btnAnotherOne.click();
    explicitWait.until(EC.number_of_windows_to_be(3));
			
    for  handle in driver.window_handles :
        print(f"Window handle is : {handle}")
        driver.switch_to.window(handle)

    explicitWait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH,"//button[text()='Open Another One']")))
			
    print(f"The second new Tab Title : {driver.title}")
    print(f"The message is : {(driver.find_element(By.CSS_SELECTOR,"h2.mt-5")).text}")
			
    driver.quit()