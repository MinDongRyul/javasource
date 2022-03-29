package basic;

//실수 => 3.14 
//    => 부동 소수점 방식 ( 가수부분 / 지수부분 )

// 실수형 : 1. float(4byte) : 부호비트 1bit, 지수부 8bit, 가수부 23bit(F, f필요)
//        2. double(8byte)-기본타입 : 부호비트 1bit, 지수부 11bit, 가수부 52bit

public class FloatVariable {
	public static void main(String[] args) {
		float f1 = 90.17f; // Type mismatch: cannot convert from double to float
		System.out.println("f1 = "+f1);
	}
			
}
