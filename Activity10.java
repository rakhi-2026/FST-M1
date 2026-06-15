package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity10 {

	public static void main(String[] args) {
		
		Map<Integer,String> colours  = new HashMap<Integer,String>();
		colours.put(1, "red");
		colours.put(2, "yellow");
		colours.put(3, "green");
		colours.put(4, "blue");
		colours.put(5, "purple");
		
		colours.remove(4);
		if(colours.containsValue("green"))
			System.out.println("Green is present");
		else
			System.out.println("Green is not present");
		
		System.out.println("Size of the Map : " + colours.size());

	}

}
