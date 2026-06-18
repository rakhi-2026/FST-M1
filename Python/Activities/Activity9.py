list1 = input("Provide the first list with comma separated : ").split(",")
list2 = input("Provide the second list with comma separated : ").split(",")

newList = list(())
print(f"List 1 is : {list1}")
print(f"List 2 is : {list2}")

for num1 in list1:
    if int(num1) % 2 == 0:
            newList.append(num1)
for num2 in list2:
    if int(num2) % 2 != 0:
          newList.append(num2)

print(f"New list is {newList}")          
            