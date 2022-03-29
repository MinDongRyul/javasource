package api;

import java.util.Arrays;

public class Split {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		
		for(String s:arr) {
			System.out.println(s);
		}
		
		String animals1 = "dog cat bear";
		String[] arr1 = animals1.split(" ");
//		System.out.println(Arrays.toString(arr1));
		for(String s:arr1) {
			System.out.println(s);
		}
	}
}
