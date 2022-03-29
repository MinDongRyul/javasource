package exam;

import java.util.Scanner;

public class AccountEx2 {
	
	// 멤버변수 , 접근: 클래스이름명.변수명 하고 접근
	private static Account2[] accountArray = new Account2[100]; // 주소를 배열에 삽입
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
			System.out.println("--------------------------------------------");
			System.out.print("선택 >> ");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) {
				//계좌생성
				createAccount();
			}else if(selectNo == 2) {
				//계좌목록
				accountList();
			}else if(selectNo == 3) {
				//예금
				deposit();
			}else if(selectNo == 4) {
				//출금
				withdraw(); 
			}else if(selectNo == 5) {
				// 종료
				run = false;
				System.out.println("프로그램 종료.");
			}else {
				System.out.println("잘못된 번호 입니다.");
			}
		}
	}//main end
	
	//계좌생성
	private static void createAccount() {
		//ano,owner,balance 입력받기
		System.out.print("계좌 번호를 입력하세요 : ");
		String ano = sc.nextLine();
		System.out.print("계좌주를 입력하세요 : ");
		String owner = sc.nextLine();
		System.out.print("처음 입금액을 입력하세요 : ");
		int balance = Integer.parseInt(sc.nextLine()); // sc.nextint(); 쓰니까 엔터가 밀려서 에러가 나는거에 대한 궁금증
		//Account2 객체 생성
		//Account2 account = new Account2(ano, owner, balance);
		//accountArray[0] = account;
		//배열에 담아주기
		
		for(int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null) { // null도 타입이 있는지? 질문
				accountArray[i] = new Account2(ano, owner, balance);
				System.out.println("계좌 생성 완료");
				break;
			}
		}	
	}
	//계좌목록
	private static void accountList() {
		// 지금까지 생성된 모든 계좌목록을 보여주기
		
//		--------------------------
//		계좌번호   계좌주   잔액
//		--------------------------
//		110-11   홍길동   100000
		
		System.out.println("-------------------------");
		System.out.println("계좌번호\t계좌주\t잔액 ");
		System.out.println("-------------------------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.printf("%s\t%s\t%d\n",
						accountArray[i].getAno(),
						accountArray[i].getOwner(),
						accountArray[i].getBalance());
			}
		}
	}
	//예금
	private static void deposit() {
		//계좌번호 입력 받기
		System.out.print("계좌 번호를 입력하세요 : ");
		String ano = sc.nextLine();
		
		//입금액 입력 받기
		System.out.print("예금액를 입력하세요 : ");
		int amount = Integer.parseInt(sc.nextLine());
		
		//입력받은 계좌번호가 배열에 들어 있는 지 확인
		Account2 account = findAccount(ano); // account : 주소가 들어있음
		
		//account가 널이 아니면 입금
		if(account != null) {
			//잔액 = 잔액 + 예금액
			//account.balance = account.balance + amount;
			account.setBalance(amount + account.getBalance());
			System.out.println("잔액 : "+account.getBalance());
		}else {
			System.out.println("계좌번호를 다시 확인해 주세요");
		}
	}
	//출금
	private static void withdraw() {
		//계좌번호 입력 받기
		System.out.print("계좌 번호를 입력하세요 : ");
		String ano = sc.nextLine(); 
				
		//입금액 입력 받기
		System.out.print("출금액를 입력하세요 : ");
		int amount = Integer.parseInt(sc.nextLine());// sc.nextint(); 쓰니까 엔터가 밀려서 에러가 나는거에 대한 궁금증
		
		Account2 account = findAccount(ano);
		
		if(account != null) {
			// 잔액 = 잔액 - 출금액
			if(account.getBalance() >= amount) {
				account.setBalance(account.getBalance()-amount);
				System.out.println("잔액 : "+account.getBalance());
			}else {
				System.out.println("잔액 부족입니다.");
			}
		}else {
			System.out.println("계좌번호를 다시 확인해 주세요");
		}
	}
	private static Account2 findAccount(String ano) {
		//Account2 배열에서 ano와 동일한 Account 찾기
		
		//for 문
		for (int i = 0; i < accountArray.length; i++) {
			//if(null이 아닌 경우만)
			if(accountArray[i] != null) {
				//if(Account2 배열에서 ano와 동일한 Account2 찾기)
				//equals
				if(accountArray[i].getAno().equals(ano)) {
					//찾은 Account2를 리턴
					return accountArray[i];
				}
			}
		}
		return null;
	}
}
