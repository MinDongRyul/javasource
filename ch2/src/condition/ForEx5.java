package condition;

public class ForEx5 {
	public static void main(String[] args) {
		// 구구단 출력
		// 3 * 1 = 3  3 * 2 = 6
		
		// 3 * 1 = 3
		// 3 * 2 = 6
		// ...
		
		for(int i=1;i<10;i++) {
			System.out.printf("3 * %d = %d\n",i,(3*i));
		}
		
		for(int i=1;i<10;i++) {
			System.out.printf("2 * %d = %d\t",i,(2*i));
		}
			
		
		
//		for (int i=2;i<10;i++) {
//			System.out.println(i+"단");
//			for(int j=1;j<10;j++) {
//				System.out.println(i+" * "+j+" = "+ (i*j));				
//			}
//		}
	}
}
