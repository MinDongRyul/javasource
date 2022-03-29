package classtest;

import java.util.Arrays;

public class MethodTestEx {
	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		MethodTest1 obj = new MethodTest1();
		
		System.out.println(obj.sum(10, 5));
		
		char charValue = obj.method1();
		
		int value = charValue + 1; // 'c' + 1
		System.out.println(value);
		
		// float
		float result1 = obj.divide2(5.0f, 2.0f);
		System.out.println(result1);
		
		// array
		int arr[] = {10, 20, 30, 40};
		int arr2[] = obj.array(arr);
		//Arrays.toString(배열) : 배열을 그대로 출력하게 해준다.
		System.out.println(Arrays.toString(arr2));
		
	}
}
