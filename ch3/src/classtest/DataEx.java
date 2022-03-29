package classtest;

public class DataEx {
	public static void main(String[] args) {
		Data d = new Data();
		
		d.x = 10;
		System.out.println("main d.x = "+d.x);
		
		//change(d.x);
		change(d);  // d의 주소를 obj에게 보냄 => obj.x = d.x
		System.out.println("change() 호출 후");
		System.out.println("main d.x = "+d.x);
		
		DataEx obj = new DataEx();
		obj.print();
	}
	
	static void change(int x) { // 기본형 매개변수(인자)
		x = 1000;
		System.out.println("change x = "+x);
	}
	
	static void change(Data obj) { // 참조형 매개변수
		obj.x = 1000; // obj.x 10 = 1000 => d.x = 1000
		System.out.println("change x = "+obj.x);
	}
	
	void print() {
		
	}
}
