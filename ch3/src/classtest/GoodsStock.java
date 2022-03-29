package classtest;

public class GoodsStock {
	//속성 - 상품코드, 재고수량
	String code;
	int stockNum;
	
	//생성자
	public GoodsStock() {
		// default 생성자
		super();
	}
	
	public GoodsStock(String code) {
		super();
		this.code = code;
	}
	
	public GoodsStock(String code, int stockNum) {
		super();
		this.code = code;
		this.stockNum = stockNum;
	}
	
	
	//기능 - 재고추가, 재고감소
	//메소드(== 함수)
	//리턴타입 메소드명(인자...){
	//	해야할 일 명시
	//}
	
	
	//리턴타입 : 데이터타입(byte, short, int, long, char, float, double, boolean) 모두가능
	//       : 배열타입(byte[], short[], int[]....)
	//       : 클래스, 인터페이스
	//       : void - 가지고 갈 값이 없음
	// 		 : 메소드가 일을 끝내고 돌아갈 때 가지고 가야할 데이터 타입
	// int mathod1() {} : method1 일을 끝내고 int 타입을 가지고 돌아간다.
	
	// 재고추가 : 재고수량을 입력받아서 현재 재고수량에 추가하기 / 현재 재고수량이 얼마인지 보내기
	int addStock(int amount) {
		stockNum += amount; // stockNum = stockNum + amount
		return stockNum;
	}

	// 재고감소 : 판매수량을 입력받아서 현재 재고수량에서 감소하기 / 현재 재고수량 리턴
	int subStock(int amount) {
		stockNum -= amount;
		return stockNum;
	}
	
	
}  
