
import pandas as pd

data = {
    "Usernames" : ["admin","Charles","Deku"],
    "Passwords" : ["password","Charl13","AllMight"]
}

dataFrame = pd.DataFrame(data)
print(dataFrame)

#Write data to CSV file

dataFrame.to_csv("activity17.csv",index=False)