from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tables")

    print(f"The page title is : {driver.title}")
    print("The number of rows and columns in the table and print them")
    cols = driver.find_elements(By.XPATH,"//table/thead/tr/th")
    rows = driver.find_elements(By.XPATH,"//table/tbody/tr")
    print(f"The number of columns in the table : {len(cols)}");
    print(f"The number of rows in the table : {len(rows)}");
    print(f"print the Book Name in the 5th row : {driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]").text}")
    print("Click the header of the Price column to sort it in ascending order")
    driver.find_element(By.XPATH,"//table[contains(@class,'table-auto')]/thead/tr/th[5]").click()
    print("Find and print the cell value at the fifth row again ....")
    print(f"print the Book Name in the 5th row : {driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]").text}")
    driver.quit()