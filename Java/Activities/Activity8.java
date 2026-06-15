package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity8 {

	public static void main(String[] args) {
		List<String> myList  = new ArrayList<String>();
		myList.add("name1");
		myList.add("name2");
		myList.add("name3");
		myList.add("name4");
		myList.add("name5");
		
		for (String name : myList) {
			System.out.println(name);
		}
		
		String thirdName = myList.get(2);
		System.out.println("Third name in the array list : "+thirdName);
		
		if(myList.contains("name4")) {
			int index = myList.indexOf("name4");
			System.out.println("The particular word name4 is present in the list. Index is : "+index);
		}
		
		System.out.println("Size of the list : " + myList.size());
		
		myList.remove(3);
		myList.add(3,"name6");
		for (String name : myList) {
			System.out.println(name);
		}
		System.out.println("Size of the list : " + myList.size());

	}

}
