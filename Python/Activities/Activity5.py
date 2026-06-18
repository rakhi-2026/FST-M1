
user_number = int(input("Please enter a number for which you want to create a multiplication table : "))


for i in range(1,10):
    value = user_number * i
    print (f"multiplied value of {user_number} with {i} : {value}")
    i=i+1
    