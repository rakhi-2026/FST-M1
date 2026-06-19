#Write a function sum() such that it can accept a list of elements and print the sum of all elements

def sum(* nums):

    total = 0
    for num in nums:
        total += int(num)
    return total

print(f"Sum of the list of elements : {sum(2,3,4,5)}")