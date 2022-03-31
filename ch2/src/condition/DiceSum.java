package condition;

public class DiceSum {

	public static void main(String[] args) {
		// While문과 Math.random() 사용
		// 주사위 2개를 던졌을 때 나오는 값을 (값1, 값2) 형태로 출력
		// 값1 + 값2 의 합이 5가 아니면 계쏙 주사위를 던지고
		// 합이 5인 경우 실행을 멈추는 프로그램 작성
		
		int i;
		int j;
		while(true) {
			i = (int)(Math.random() * 6) + 1;
			j = (int)(Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", i, j);
			
			
			if (i + j == 5) {
				System.out.printf("%d + %d = 5입니다", i, j);
				break;
			}
		}

	}

}
