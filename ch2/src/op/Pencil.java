package op;

// 변수명
// 소문자로 시작(대소문자 구별) - filename, fileName 는 서로 다른 변수명
// 두개의 단어가 붙을 경우 첫 문자를 대문자로 한다.(관례) - firstName, maxSpeed
// $, _ 로 시작하는 것은 허용(다른 것은 안된다)

public class Pencil {
	public static void main(String[] args) {
		// 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나눌때 학생 당 몇 개를 가질수 있고 
		// 최종적으로 몇 개가 남는지 출력 하시오
		// 변수 사용, 산술 연산자 사용
		int a = 534;
		int b = a / 30;
		int c = a % 30;
		System.out.println("학생 당 개수 : "+b);
		System.out.println("최종적으로 남는 개수 : "+c);
		
		
	}
}
