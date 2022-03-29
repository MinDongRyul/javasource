package condition;

import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		
		boolean run = true;
		int money = 0; // 잔고
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택 >> ");
			
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.print("예금액 >> ");
				money += sc.nextInt();
				break;
			case 2:
				System.out.print("출금액 >> ");
				money -= sc.nextInt();
				break;
			case 3:
				System.out.printf("잔고 : %d\n", money);
				break;
			case 4:
				run = false;
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
			}
		}
		sc.close();
	}
}
