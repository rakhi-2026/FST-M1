package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		
		int[] numbers = {20,12,45,48,67,89,34,56};
		System.out.println("Before Sorting the array");
		System.out.println(Arrays.toString(numbers));
		
		System.out.println("After Sorting the array");
		System.out.println(Arrays.toString(insertionSort(numbers)));
		
	}
	
	public static int[] insertionSort(int[] arr) {
		
		
		for(int i=1 ; i< arr.length-1; i++) {
			int Key = arr[i];
			int j = i-1;
			while(j>=0 && Key < arr[j]) {
				arr[j+1] = arr[j];
				System.out.println("Inside while loop : "+ "Value of arr["+(j+1)+"] : "+  arr[j+1]);
				j--;
			}
			arr[j+1] = Key;
			System.out.println("Outside while loop : "+ "Value of arr["+(j+1)+"] : "+  arr[j+1]);
			
		}
		
		return arr;
	}

}
