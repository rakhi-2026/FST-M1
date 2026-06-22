
import pandas as pd

dataFrame = pd.read_csv("activity17.csv")

print("====================================================================================")
print("Print Full Usernamrs : ")
print(dataFrame["Usernames"])

print("====================================================================================")
print("Print the username and password of the second row : ")
print("Username : " + dataFrame["Usernames"][1])
print("Password : " + dataFrame["Usernames"][2])

print("====================================================================================")
print("Sort the Usernames column data in ascending order and print data : ")
print(dataFrame.sort_values("Usernames",ascending=True))

print("====================================================================================")
print("Sort the Passwords column in descending order and print data : ")
print(dataFrame.sort_values("Passwords",ascending=False))