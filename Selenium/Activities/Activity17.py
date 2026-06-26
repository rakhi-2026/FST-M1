from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    print(f"The page title is : {driver.title}")

    multiSelect = driver.find_element(By.CSS_SELECTOR,"select.h-80")
    select = Select(multiSelect)

    select.deselect_by_index(0);
    select.select_by_visible_text("HTML");
    for i in range(3,6):
        select.select_by_index(i)
    selectedOptions = select.all_selected_options
    for e in selectedOptions:
        print(f"Selected Options : {e.text}")
    select.select_by_value("nodejs")
    select.deselect_by_index(4)
    selectedOptions1 = select.all_selected_options

    for e in selectedOptions1 :
        print(f"Selected Options : {e.text}")
    driver.quit()