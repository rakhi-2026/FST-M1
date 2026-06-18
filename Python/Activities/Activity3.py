user1_input = input("Please choose your option among rock,paper or scissors , for Rock-Paper-Scissors game : ")
user2_input = input("Please choose your option among rock,paper or scissors , for Rock-Paper-Scissors game : ")

if user1_input == user2_input:
    print ("This is a Tie!")
elif user1_input == "rock":
    if user2_input == "scissors":
        print (f"User 1 wins!Ans : {user1_input}")
    else:
        print (f"User 2 wins! Ans : {user2_input}")
elif user1_input == "scissors":
    if user2_input == "paper":
        print (f"User 1 wins!Ans : {user1_input}")
    else:
        print (f"User 2 wins! Ans : {user2_input}")
elif user1_input == "paper":
    if user2_input == "rock":
        print (f"User 1 wins!Ans : {user1_input}")
    else:
        print (f"User 2 wins! Ans : {user2_input}") 
	
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")                       


