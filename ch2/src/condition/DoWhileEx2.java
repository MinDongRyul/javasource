package condition;

import java.util.Scanner;

public class DoWhileEx2 {
	public static void main(String[] args) {
		// q가 입력되기 전까지 문자를 입력받기
		
		Scanner sc = new Scanner(System.in);
		// sc.nextInt() : 숫자
		
		// 문자, 숫자....
//		String msg = sc.nextLine();
//		
//		System.out.println(msg);
		
		System.out.println("메세지 입력해 주세요(종료 : q 입력)");
		
		String msg = "";
		
		do {
			System.out.print(">> ");
			
			msg = sc.nextLine();
			System.out.println(msg);
		}while(!msg.equals("q"));
		
		System.out.println("\n프로그램 종료");
		
		sc.close();
		
	}
}
