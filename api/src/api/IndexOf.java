package api;

public class IndexOf {
	public static void main(String[] args) {
		String str1 = "자바 프로그래밍";
		
		//indexOf() : 문자열 위치를 인덱스로 돌려줌
		int pos = str1.indexOf("프");
		System.out.println(pos); //3
		
		System.out.println(str1.indexOf("크"));
		
		if(str1.indexOf("자바") == -1) {
			System.out.println("자바 문자열 없음");
		}else {
			//System.out.println(str1.indexOf("프로그래밍")); // 출력 : 맨처음 문자의 인덱스 숫자
			System.out.println("자바 문자열 있음");
		}
		
		String str2 = new String("HelloHelloHello World");
		// 가장 처음에 만나는 위치를 찾아줌
		System.out.println(str2.indexOf('o'));
		// 가장 나중에 나오는 위치
		System.out.println(str2.lastIndexOf('o'));
		// 'o'를 6번자리부터 찾아서 찾은 'o'의 인덱스 반환
		// 시작위치 지정 가능
		System.out.println(str2.indexOf('o', 6)); 
	}
}
