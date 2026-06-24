from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")
    print(f"The page title is : {driver.title}")
    confirmTxtElement = driver.find_element(By.XPATH,"//p[@id = 'result']")
    lockBtn= driver.find_element(By.XPATH,"//h1[text() = 'Cargo.lock']/ancestor::div[@role = 'button']")
    tomlBtn = driver.find_element(By.XPATH,"//h1[text() = 'Cargo.toml']/ancestor::div[@role = 'button']")
    srcBtn = driver.find_element(By.XPATH,"//h1[text() = 'src']/ancestor::div[@role = 'button']")
    targetBtn = driver.find_element(By.XPATH,"//h1[text() = 'target']/ancestor::div[@role = 'button']")
			
    builder = webdriver.ActionChains(driver)
    builder.click(lockBtn).pause(5).move_to_element(tomlBtn).click(tomlBtn).perform()
    print(f"The confirmation text is : {confirmTxtElement.text}")
    builder.double_click(srcBtn).pause(2).move_to_element(targetBtn).context_click(targetBtn).perform()
    print(f"The confirmation text is : {confirmTxtElement.text}")
    driver.quit()