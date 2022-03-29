package condition;

public class WhileEx2 {
	public static void main(String[] args) {
		// 1 ~ 10 까지 합 구하기
		
//		int sum = 0;
//		for(int i=1; i<11; i++) {
//				sum += i; // sum = sum + i;
//		}
		
		int i = 1, sum = 0;
		while(i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ 10까지 합 : "+sum);
		
		// 1 ~ 100 까지 합
		
//		sum = 0;
//		for (int j=1;j<101;j++) {
//		sum += j;
//		}
		int j = 1, sum1 = 0;
		while(j <= 100) {
			sum1 += j;
			j++;
		}
		System.out.println("1 ~ 100까지 합 : "+sum1);
		
		
		
	}
}
