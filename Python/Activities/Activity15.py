#Write a Python program that throws a NameError.Handle the error so it doesn't halt execution.

try:
    print(x)
except NameError:
    print("x is not defined.It's a Name Error")
finally:
    print("program execution has been stopped")