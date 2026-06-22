
import pandas as pd

dataFrame = pd.read_excel("sample.xlsx",sheet_name = "Sheet1")


print(dataFrame)
print("====================================================================================")
print("Print the number of rows and columns : ")
print(dataFrame.shape)

print("====================================================================================")
print("Print the data in the emails column only : ")
print(dataFrame["Email"])


print("====================================================================================")
print("Sort the data based on FirstName in ascending order and print the data : ")
print(dataFrame.sort_values("FirstName"))