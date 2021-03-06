package shop;

public abstract class Product {
	//일반 클래스 + 추상 메소드
	private String name; // 상품명
	private int price; // 가격명
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//상품마다 동일안 내용을 출력
	public void printDetail() {
		System.out.println("상품 이름 : "+name);
		System.out.println("상품 가격 : "+price);
		
		printExtra();
	}
	//상품마다 서로 다른 내용을 출력
	public abstract void printExtra(); // 추상메소드가 하나이상있어야 추상클래스의 의미가 있음
}
