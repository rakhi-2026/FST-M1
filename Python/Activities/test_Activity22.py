	
import pytest

def test_twonumbers_addition():
    print("=========================================")
    print("Sum of two numbers")
    num1 = 20
    num2 = 25
    result = num1+num2
    print(result)
    assert result == 45


def test_twonumbers_substraction():
    print("=========================================")
    print("Substraction of two numbers")
    num1 = 40
    num2 = 25
    result = num1-num2
    print(result)
    assert result == 15  

@pytest.mark.activity
def test_multiplication():
    print("=========================================")
    print("Multiplication of two numbers")
    num1 = 20
    num2 = 4
    result = num1*num2
    print(result)
    assert result == 80

@pytest.mark.activity
def test_substraction():
    print("=========================================")
    print("Division of two numbers")
    num1 = 40
    num2 = 5
    result = num1/num2
    print(result)
    assert result == 8      
