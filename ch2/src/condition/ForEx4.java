package condition;

public class ForEx4 {
	public static void main(String[] args) {	
		// for(int j=1,k=0;j<101 && k<=50;j++,k++)
			
		// 1~10까지 숫자 중에서 짝수만 출력
		for (int i=2;i<11;i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		for (int i=1;i<11;i++) {
			if(i %2 == 0) {
			System.out.print(i+" ");
			}
		}
		System.out.println();
		
		// 1~10까지 숫자 중에서 홀수만 출력
		for (int j=1;j<11;j+=2) {
			System.out.print(j+" ");
		}
		System.out.println();
		
		for (int j=1;j<11;j++) {
			if(j %2 == 1) {
			System.out.print(j+" ");
			}
		}
		System.out.println();
		
		
		// 1~100까지 숫자 중에서 3의 배수만 출력
		for (int k=3;k<101;k+=3) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		for (int k=1;k<101;k++) {
			if(k % 3 == 0) {
			System.out.print(k+" ");
			}
		}
		System.out.println();
	}
}
