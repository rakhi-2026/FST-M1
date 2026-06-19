#Write a recursive function to calculate the sum of numbers from 0 to 10


def rec_Adder(n):
    
    if n >= 0:
        return n + rec_Adder(n-1)
    else:
        return 0    

print(rec_Adder(10))        
