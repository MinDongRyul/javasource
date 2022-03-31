package condition;

public class EquationEx {
	public static void main(String[] args) {
		// 4x + 5y = 60
		// x, y는 10 이하의 자연수 
		
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++ ) {
				int z = 4 * x + 5 * y;
				if((z == 60)) {
					System.out.printf("x = %d, y = %d\n", x, y);
				}
			}
		}				
	}
}
