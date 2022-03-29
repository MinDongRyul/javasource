package condition;

import java.util.Scanner;

public class MinValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input Num1 : ");
		int num1 = sc.nextInt();
		System.out.println("Input Num2 : ");
		int num2 = sc.nextInt();
		System.out.println("Input Num3 : ");
		int num3 = sc.nextInt();
		
		int min = num1;
		
		if(min > num2) {
			min = num2;
		}
		if(min > num3) {
			min = num3;
		}
		System.out.println("가장 작은 수 : "+min);
		
		int max = num1;
		
		if(max < num2) {
			max = num2;
		}
		if(max < num3) {
			max = num3;
		}
		System.out.println("가장 큰 수 : "+max);
		
		sc.close();
		
	}
}
