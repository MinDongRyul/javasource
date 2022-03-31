package api;

public class StartsWith {

	public static void main(String[] args) {
		String s = "java.lang.Object";
		
		// 원하는 문자로 시작했는지 판별
		System.out.println(s.startsWith("java"));
	
		// 원하는 문자로 끝났는지 판별
		System.out.println(s.endsWith("java"));
	}

}
