from selenium import webdriver
from selenium.webdriver.common.by import By 

with  webdriver.Firefox() as driver :
    driver.get("https://training-support.net")
    print(f"Page title is : {driver.title}")
    element = driver.find_element(By.LINK_TEXT,"About Us")
    element.click()
    print("About Us has been clicked")
    print(f"New Page title is : {driver.title}")
    driver.quit()