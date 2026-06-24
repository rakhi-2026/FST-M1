from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/keyboard-events")
    print(f"The page title is : {driver.title}")
    builder = webdriver.ActionChains(driver)
    builder.send_keys("Typing from Selenium").send_keys(Keys.RETURN).perform()
    txt = driver.find_element(By.XPATH,"//p[@id='result']/following-sibling::h1")
    print(f"The confirmation text is : {txt.text}")
    driver.quit()