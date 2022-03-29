package interfacetest;

public class AppinfoEx {
	public static void main(String[] args) {
//		SeparateVolume obj1 = new SeparateVolume("863-774", "개미", "베르나르");
		Lendable obj1 = new SeparateVolume("863-774", "개미", "베르나르"); // 다형성 or 상속의 개념
		obj1.checkOut("홍길동", "2022-02-28");		
		
		AppCD obj2 = new AppCD("2022-01", "Oracle");
		obj2.checkOut("성춘향", "2022-03-01");
	
	}
}
