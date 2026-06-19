#Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.

user_input = int(input ("how many Fibonnaci numbers to generat : "))



def generate_fibonacci(num):

    if num <= 1:
        return num
    else:
        return (generate_fibonacci(num-1) + generate_fibonacci(num-2))


for i in range(user_input):
    print(generate_fibonacci(i))


