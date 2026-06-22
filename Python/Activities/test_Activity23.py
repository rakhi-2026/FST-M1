
import pytest



def test_sum_of_list(num_list):
   sum = 0
   for num in num_list:
      sum = sum + num
   assert sum == 55   
