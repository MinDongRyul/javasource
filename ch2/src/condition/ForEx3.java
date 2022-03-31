package condition;

public class ForEx3 {

	public static void main(String[] args) {
		// 1~10까지 합
		int sum = 0;
		for(int i=1; i<11; i++) {
				sum += i; // sum = sum + i;
		}
		// System.out.println(i); 
		// i cannot be resolved to a variable
		// i 는 for 블럭을 벗어날 수가 없다
		// i 를 사용하고 싶을 때(바깥으로 뺀다)
		// int i = 1;
		// for(생략가능; i<11; i++) {
		//		sum += i; // sum = sum + i;
		//	}
		
		System.out.println("1 ~ 10까지의 합 : "+sum);
	
		// 1 ~ 100 까지 합
		sum = 0;
		for (int j=1;j<101;j++) {
			sum += j;
		}
		System.out.println("1 ~ 100까지 합 : "+sum);
	}

}
