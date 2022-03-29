package condition;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// 윤년, 평년 구하기
		// 연도 입력 받은 후 윤년, 평년인지 출력
		// 윤년 = 연도를 4로 나눈 나머지가 0 이고, 연도를 100으로 나눈 나머지가 0 아니거나
		//       연도를 400으로 나눈 나머지가 0인 연도가 윤년
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 적으시오 : ");
		int num = sc.nextInt();
		
		if (num % 4 == 0 && num % 100 != 0 || num % 400 == 0) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
		sc.close();
	}

}
