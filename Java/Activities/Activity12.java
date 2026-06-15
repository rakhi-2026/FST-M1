package activities;

import java.util.*;

public class Activity12 {

	public static void main(String[] args) {

			Scanner scan = new Scanner(System.in);
			ArrayList<Integer> list = new ArrayList<Integer>();
			Random indexGen = new Random();
			
			while(scan.hasNextInt()) {
				list.add(scan.nextInt());
				
			}
			scan.close();
			Integer nums[] = list.toArray(new Integer[0]);
			
			int index = indexGen.nextInt(nums.length);
			
			System.out.println("The index value is : "+ index + " And the value in the index is : "+ nums[index]);

	}

}
