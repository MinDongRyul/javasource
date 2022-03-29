package condition;

public class PrimeNumber {
	public static void main(String[] args) {
		// 1 ~ 100 숫자 중에서 소수 구하기
		// 1과 자기자신으로만 나누어지는 수
		
		for(int i = 1; i <= 100; i++) {
			int sum = 0;
			for(int j = 1; j <= (int)Math.sqrt(i); j++){
				if(i % j == 0) {
					sum += 1;
				}
			}
			if(sum == 1 || sum == 0) {
				System.out.printf("%d은(는) 소수\n",i);
			}
		}
	}
}

