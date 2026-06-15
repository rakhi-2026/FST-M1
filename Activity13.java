package activities;

import java.util.*;

public class Activity13 {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user's age : ");
		int age = Integer.parseInt(scan.next());
		scan.close();
		Activity13 activity = new Activity13();
		activity.registerUser(age);
		

		
	}

	public void registerUser(int ageInput) throws Exception {
		
		try{
			if(ageInput < 18)
				throw new IllegalArgumentException("Users must be at least 18 years old.");
			else
				System.out.println("Registration successful! Welcome aboard.");
			
		}catch(NumberFormatException e) {
			System.out.println("Age must be a valid number.");
		}
		
		
	}


}
