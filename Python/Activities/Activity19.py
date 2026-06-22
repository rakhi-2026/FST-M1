import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
    "FirstName" : ["Satvik","Avinash","Lahri"],
    "LastName" : ["Shah","Kati","Rath"],
    "Email" : ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber" : ["4537829158","5892184058","4528727830"]
}

dataFrame = pd.DataFrame(data)

print(dataFrame)

# This is a way to write in the excel file. But if we are not mentioning arguements keyword , a warning message will come

#writer = ExcelWriter("sample.xlsx")
#dataFrame.to_excel(writer,sheet_name="Sheet1",index = False)
#writer.close()


#This is a new approach with with as operator
with ExcelWriter("sample.xlsx") as writer:
    dataFrame.to_excel(writer,sheet_name="Sheet1",index = False)