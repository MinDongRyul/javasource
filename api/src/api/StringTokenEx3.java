package api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenEx3 {

	public static void main(String[] args) {
		// 사용자로부터 문자열을 입력받아 공백으로 분리된 어절이 몇 개인가 출력
		
		// 오늘은 화요일 입니다. => 3
		// exit 문자를 입력하면 반복문 종료
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열 입력 (종료 : exit) : ");
			String str = sc.nextLine();
		
			if(str.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			StringTokenizer str2 = new StringTokenizer(str);
		
			//int count = 0;
//			while(str2.hasMoreElements()) {
//				str2.nextToken();
//				count += 1;
//			}
			System.out.println("분리된 어절 : "+str2.countTokens()); // 분리된 어절의 갯수 
			
		}
		
		sc.close();
	}

}
