package condition;

public class SwitchEx3 {

	public static void main(String[] args) {
		char grade = 'A';
		
		switch (grade) {
		case 'A': case 'a': // or의 개념
			System.out.println("우수회원");
			break;
		case 'B': case 'b': 
			System.out.println("일반회원");
			break;
		default:
			System.out.println("손님");
			break;
		}
	}
}
