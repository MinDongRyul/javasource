package condition;

import java.util.Scanner;

public class RockScissorPaper {
	public static void main(String[] args) {
		// 가위 : 1, 바위 : 2, 보자기 : 3
		
		// 컴퓨터가 무작위로 1~3까지의 숫자 중에서 하나를 가지고 있도록 한다.
		
		// 사용자의 가위,바위,보 정하기
		// 누가 이겼는지 결과 출력
		
		int computer = (int)(Math.random() * 3) + 1; 
		// *3 => 0~2 +1 =? 1~3
		
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(1) 바위(2) 보자기(3) 중 하나를 입력하세요 : ");
		int user = sc.nextInt();
		
		if(computer == 1) {
			if(computer == user) {
				System.out.println("computer : "+computer);
				System.out.println("비겼습니다");
			}else if(user == 2){
				System.out.println("computer : "+computer);
				System.out.println("user 승리");
			}else {
				System.out.println("computer : "+computer);
				System.out.println("computer 승리");
			}
		}else if(computer == 2){
			if(computer == user) {
				System.out.println("computer : "+computer);
				System.out.println("비겼습니다");
			}else if(user == 3){
				System.out.println("computer : "+computer);
				System.out.println("user 승리");
			}else {
				System.out.println("computer : "+computer);
				System.out.println("computer 승리");
			}
		}else if(computer == 3){
			if(computer == user) {
				System.out.println("computer : "+computer);
				System.out.println("비겼습니다");
			}else if(user == 1){
				System.out.println("computer : "+computer);
				System.out.println("user 승리");
			}else {
				System.out.println("computer : "+computer);
				System.out.println("computer 승리");
			}
		}
		
		// user 가위(1) - computer(1, 2, 3)
		// switch문 활용
//		switch(user - computer) {
//		case -1: case 2:
//			System.out.println("user가 졌음");
//			break;
//		case -2: case 1:
//			System.out.println("user가 졌음");
//			break;
//		case 0:
//			System.out.println("비겼음");
//			break;
//		}
		sc.close();
		
		
	}
}
