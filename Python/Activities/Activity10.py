user_tuple = input("Please provide a tuple of number with comma separated : ").split(",")
print(f"The tuple is {user_tuple}")

for item in user_tuple:
    if int(item) % 5 == 0:
        print(f"The item is {item}")