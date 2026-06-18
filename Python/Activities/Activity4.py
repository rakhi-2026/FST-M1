

while (True):
    user1_input = input("Please choose your option among rock,paper or scissors , for Rock-Paper-Scissors game : ").lower()
    user2_input = input("Please choose your option among rock,paper or scissors , for Rock-Paper-Scissors game : ").lower()
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
    user_replay = input("Do you want to replay ? Please provide your input as Yes or No.").lower()
    if user_replay == "no":
        break
    elif user_replay == "yes":
        continue
    else:
        print("You entered an invalid option. Exiting now.")
        break

