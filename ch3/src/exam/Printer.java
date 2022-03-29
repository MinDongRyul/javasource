package exam;

public class Printer {
	
	// 생성자 : 초기화
	public Printer() {
		super();
	}
	
	// 메소드 오버로딩
	public void println(int var) {
		System.out.println(var);
	}
	public void println(boolean var) {
		System.out.println(var);
	}
	public void println(double var) {
		System.out.println(var);
	}
	public void println(String var) {
		System.out.println(var);
	}
}
