from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/target-practice")
    print(f"The page title is : {driver.title}")

    header3 = driver.find_element(By.XPATH ,"//h3[contains(text(),'#3')]")
    print(f"The text in third header : {header3.text}");

    header5 = driver.find_element(By.XPATH,"//h5[contains(text(),'#5')]")
    headerColor = Color.from_string(header5.value_of_css_property("color")).rgb 
    print(f"The colour of the fifth header : {headerColor}")

    purpleBtn = driver.find_element(By.XPATH,"//button[text() = 'Purple']");
    print(f"The classes of purple button are : {purpleBtn.get_attribute("class")} ")
			
    slateBtn = driver.find_element(By.XPATH,"//button[text() = 'Slate']");
    print(f"The text of slate button is : {slateBtn.text}")
    driver.quit();