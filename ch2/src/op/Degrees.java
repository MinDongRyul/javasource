package op;

import java.util.Scanner;

public class Degrees {
	public static void main(String[] args) {
		// 화씨온도 => 섭씨 온도
		// 화씨온도 입력받은 후 섭씨온도로 변환하기
		// 화씨온도 = (섭씨온도 - 32) * 5/9
		Scanner sc = new Scanner(System.in);
		
		System.out.print("화씨 온도 : ");
		int fahr = sc.nextInt();
		
		// 5/9 => 몫 (0)
		// 5/9.0 => 0.xxx
		double celsius = 5/9.0 * (fahr - 32);
		System.out.println("섭씨 온도 : "+celsius);
		//format 지정 : %f(실수형), %d(정수형), %c(문자=''), %s(문자열="")
		System.out.printf("섭씨 온도 : %.3f\n",celsius);
		
		sc.close();
	}
}
