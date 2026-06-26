from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tables")
    print(f"The page title is : {driver.title}")

    print("The number of rows and columns in the table and print them")
    cols = driver.find_elements(By.XPATH,"//table/thead/tr/th")
    rows = driver.find_elements(By.XPATH,"//table/tbody/tr")

    print(f"The number of columns in the table : {len(cols)}")
    print(f"The number of rows in the table : {len(rows)}")
    
    print("Find and print all the cell values in the third row of the table....")

    thirdRow = driver.find_elements(By.XPATH,"//table/tbody/tr[3]/td")
    for row in thirdRow : 
        print(row.text)

    print("Find and print the cell value at the second row second column....")  

    print(f"Second row second column value is : {driver.find_element(By.XPATH,"//table/tbody/tr[2]/td[2]").text}")  
    driver.quit()