from selenium import webdriver
from selenium.webdriver.common.by import By
import time

with  webdriver.Firefox() as driver :
    driver.get("https://training-support.net/webelements/login-form/")
    print(f"Page title is : {driver.title}")
    username = driver.find_element(By.ID,"username")
    password = driver.find_element(By.ID,"password")
    btnSubmit = driver.find_element(By.XPATH,"//button[text()='Submit']")
    username.send_keys("admin")
    password.send_keys("password")
    btnSubmit.click()
    time.sleep(2)
    print("Login Success !")
    print(f"New Page title is : {driver.title}")
    driver.quit()