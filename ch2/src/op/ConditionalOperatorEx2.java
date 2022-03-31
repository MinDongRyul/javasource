package op;

import java.util.Scanner;

public class ConditionalOperatorEx2 {
	public static void main(String[] args) {
		// 숫자를 입력받고 그 숫자가 양수, 음수인지 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력 하시오 : ");
		int num = sc.nextInt();
		
		String grade =  num > 0 ? "양수입니다" : "음수입니다";
		System.out.println(grade);
		
		sc.close();
	}
}
