package shop;

import java.util.Scanner;

public class MyShop implements IShop {

	private String title;
	
	private User users[] = new User[2];
	
	private Product products[] = new Product[5];
	
	private Product carts[] = new Product[10];
	
	Scanner sc = new Scanner(System.in);
	
	private int selUser;
	
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	@Override
	public void genUser() {
		// User 객체를 이용해서 2명 생성
		// User 생성 후 배열에 담기
		users[0] = new User("홍길동", PayType.CARD);
		users[1] = new User("성춘향", PayType.CASH);	
	}
	@Override
	public void genProduct() {
		// 핸드폰 3개 생성, 스마트 TV 2개 생성
		products[0] = new CellPhone("갤럭시노트11", 1500000, "SKT");
		products[1] = new CellPhone("아이폰12", 1300000, "KT");
		products[2] = new CellPhone("아이폰11", 900000, "LGU+");
		products[3] = new SmartTV("삼성울트라HD", 2500000, "4K");
		products[4] = new SmartTV("LG스마트", 1400000, "1080p");
	}
	@Override
	public void start() {
		
		System.out.println(title+" : 메인 화면 - 계정 선택");
		System.out.println("==========================");
//		for (int i = 0; i < users.length; i++) {
//			System.out.println("["+i+"]"+users[i].getName()+"("+users[i].getPayType()+")");
//		}
		int i = 0;
		for (User user:users) {
			System.out.printf("[%d] %s(%s)\n",i++,user.getName(),user.getPayType());
		}
		System.out.println("[x] 종 료");
		System.out.print("선택 : ");
		String input =  sc.nextLine();
		
		// input : 0, 1, x 
		// switch
		switch(input) {
		case "0" :case "1" :
			// System.out.println("### "+input+"선택 ###");
			System.out.println("### "+input+"선택 ###");
			
			selUser = Integer.parseInt(input);
			
			// 0, 1 => 위 출력문 보여주고, productList() 호출
			productList();
			break;
		case "x" :case "X" :
			System.out.println("프로그램 종료합니다.");
			// x(X) => 프로그램 종료
			break;
		default : 
			// 다른게 입력되면 => 입력값을 확인해 주세요
			System.out.println("입력 값을 확인해 주세요.");
			// 계정선택 화면 보여주기
			start();
			break;
		}
		
	}
	
	public void productList() {
		System.out.println(title+" : 상품목록 - 상품선택");
		System.out.println("========================");
		int i = 0;
		
		for(Product p:products) { // p가 배열을 받아온거같은데 어떻게 printDetail까지 호출 가능한지 궁금합니다
			System.out.printf("[%d]",i++);
			p.printDetail();
		}
		System.out.println("[h] 메인화면");
		System.out.println("[c] 체크아웃");
		System.out.print("선택 : ");
		String input = sc.nextLine();
		
		//input :  h : 계정선택 , c : 체크아웃(checkOut호출)
		// 	      0~4 상품(장바구니에 담고 다시 한번 상품 목록 보여주기)
		switch(input){
//		case "0":
//			carts[j] = new CellPhone("갤럭시노트11", 1500000, "SKT");
//			j++;
//			productList();
//			break;
//		case "1":
//			carts[j] =new CellPhone("아이폰12", 1300000, "KT");
//			j++;
//			productList();
//			break;
//		case "2":
//			carts[j] = new CellPhone("아이폰11", 900000, "LGU+");
//			j++;
//			productList();
//			break;
//		case "3":
//			carts[j] = new SmartTV("삼성울트라HD", 2500000, "4K");
//			j++;
//			productList();
//			break;
//		case "4":
//			carts[j] = new SmartTV("LG스마트", 1400000, "1080p");
//			j++;
//			productList();
//			break;
		case "0":case "1":case "2":case "3":case "4":
			for (int j = 0; j < carts.length; j++) {
				if(carts[j] == null) {
					carts[j] = products[Integer.parseInt(input)];
					break;
				}
			}
			productList();
			break;
		case "h": case "H": // start() 호출
			start();
			break;
		case "c": case "C": // checkOut() 호출
			checkOut();
			break;
		default : // productList() 호출
			System.out.println("메뉴를 확인해 주세요.");
			productList();
			break;
		}
	}
	
	public void checkOut() {
		System.out.println(title+" : 상품목록 - 상품선택");
		System.out.println("========================");
		int i = 0;
		int sum = 0;
		for(Product p:carts) { // p가 배열을 받아온거같은데 어떻게 printDetail까지 호출 가능한지 궁금합니다
			if(p != null) {
				System.out.printf("[%d] %s(%d)\n",i++,p.getName(),p.getPrice());
				sum += p.getPrice();
			}
		}
		System.out.println("결제 방법 : "+users[selUser].getPayType());
		System.out.println("합계 : "+sum+"원 입니다.");
		System.out.println("[p] 이전, [q] 결제 완료");
		System.out.print("선택 : ");
		String input = sc.nextLine();
		
		// input : p, q
		// p : 이전 화면 productList()
		// q : 결제가 완료되었습니다. 감사합니다. 
		switch (input) {
		case "p":
			productList();
			break;
		case "q":
			System.out.println("결제가 완료되었습니다. 감사합니다.");
			break;
		default:
			System.out.println("잘못 눌렀습니다. 다시 눌러 주세요");
			checkOut();
			break;
		}
	}
	
	

}
