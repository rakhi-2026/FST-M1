package activities;

public class Activity11 {

	public static void main(String[] args) {

		Addable ad1;
		Addable ad2;
		ad1 = (num1,num2) -> (num1+num2);
		System.out.println(ad1.add(5, 6));
		
		ad2 = (num1,num2) -> {return (num1+num2);};
		System.out.println(ad2.add(2, 6));

	}

}
