package api;

public class Reverse {

	public static void main(String[] args) {
		String str= "ABzquartK";
		char arr[] = new char[str.length()];
		// 거꾸로 출력
		for (int i = 0 ; i < str.length(); i++) {
			arr[i] = str.charAt(str.length()-(i+1));
		}
		System.out.println(arr);
		
//		for(int i = str.length()-1; i >= 0; i--) {
//			System.out.print(str.charAt(i)+" ");
//		}
		
//		같은 의미
//		char[] chArr = str.toCharArray();
//		
//		char[] arr1 = new char[str2.length()];
//		for(int i = 0; i<str2.length(); i++) {
//			arr1[i] = str2.charAt(i);
//		}
		
		//StringBuilder reverse
		
		StringBuilder str2 = new StringBuilder(str);
		System.out.println(str2.reverse());
	}
}
