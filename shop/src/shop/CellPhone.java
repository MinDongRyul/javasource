package shop;

public class CellPhone extends Product {

	private String carrier; // 통신사 정보
	
	
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/MinDongRyul/javasource.git
	public CellPhone(String name, int price, String carrier) {
		super(name, price);
		this.carrier = carrier;
	}

	// 추상메소드이기에 무조건 오버라이드
	@Override
	public void printExtra() {
		System.out.println("통신사 정보 : "+carrier);

	}

}
