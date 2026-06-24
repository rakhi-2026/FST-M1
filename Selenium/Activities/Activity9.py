from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-content")
    explicitwait  = WebDriverWait(driver,10)
    print(f"The page title is : {driver.title}")
    
    button = driver.find_element(By.XPATH,"//button[@id = 'genButton']")
    button.click();
    
    if explicitwait.until(EC.text_to_be_present_in_element((By.ID,"word"),"release")) :
        print(f"The text is visible : {driver.find_element(By.ID,"word").text}")
    driver.quit()