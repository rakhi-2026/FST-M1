numbers = input("Please enter a list of numbers with comma separated : ").split(",")

first_num = int(numbers[0])
last_num = int(numbers[-1])

if first_num == last_num:
    print (True)
else:
    print(False)    