package activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Activity9 {

	public static void main(String[] args) {
		
		List<Object> objLists = new ArrayList<Object>();
		objLists.add(2);
		objLists.add("Good");
		objLists.add(10);
		objLists.add("Morning");
		objLists.add(3);
		objLists.add("Java");
		objLists.add(4);
		objLists.add("Python");
		objLists.add(12);
		objLists.add("Selenium");
		
		Set<Object> hs = new HashSet<Object>(objLists);
		System.out.println("Size of the hash set : "+ hs.size());
		
		System.out.println(hs);
		
		Iterator<Object> it = hs.iterator();
		while(it.hasNext()) {
			Object s = it.next();
			if(s.equals("Morning")) {
				it.remove();
			}
		}
		hs.removeIf(o -> o.equals("Morning"));
		
		if(hs.remove("Breakfast"))
			System.out.println("Breakfast has been removed");
		else
			System.out.println("Unable to remove. Kindly chek if the element is present or not");
		
		System.out.println("Check if Java is present in the set : "+hs.contains("Java"));
		System.out.println(hs);
		
	}

}
