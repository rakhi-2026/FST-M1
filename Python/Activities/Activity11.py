fruit_shop = {
    "apple":200,
    "banana":45,
    "Kiwi":150,
    "oranges":60 
}

user_input = input("Which fruit you need ? ")
print (f"The available fruits in the shop : {fruit_shop.keys()}")
print(f"User is asked for {user_input}")

#process 1 ------------------------------------------
availability = False

for key in fruit_shop.keys():
   if user_input == key:
       availability = True
       
if  availability == False:     
    print (f"{user_input} is not available in the shop")
else:
     print (f"{user_input} is available in the shop") 

#process 2-------------------------------------------------
if user_input in fruit_shop.keys():
    print (f"{user_input} is available in the shop") 
else:
    print (f"{user_input} is not available in the shop")        
