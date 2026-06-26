from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    print(f"The page title is : {driver.title}")

    singleSelect = driver.find_element(By.CSS_SELECTOR,"select.h-10")
    select = Select(singleSelect)
    select.select_by_visible_text("Two")
    select.select_by_index(2)
    select.select_by_value("four")
			
    options = select.options
    for  opt in options :
       print(opt.text)
    driver.quit()
