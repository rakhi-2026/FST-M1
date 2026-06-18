
user_list = input("Please enter a list of number with comma separated : ").split(", ")

print (user_list)
sum = 0
for num in user_list:
    sum = sum + int(num)
print (sum) 