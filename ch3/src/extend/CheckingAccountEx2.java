package extend;

public class CheckingAccountEx2 {
	public static void main(String[] args) {
		CheckingTrafficCardAccount account1 = new CheckingTrafficCardAccount("111-11", "홍길동", 20000, "5555-55", false);
		
		CheckingTrafficCardAccount account2 = new CheckingTrafficCardAccount("222-22", "성춘향", 60000, "3333-33", true);
		
//		System.out.println(account1.getOwner()+"님의 현재 잔액 : "+account1.getBalance());
//		//교통카드 사용
//		account1.payTrafficCard("5555-55", 1500);
//		System.out.println(account1.getOwner()+"님의 현재 잔액 : "+account1.getBalance());
		
		//예금
		account1.deposit(50000);
		//출금
		account1.withdraw(20000);
		//체크카드 사용
		account1.pay("5555-55", 30000);
		System.out.println(account1.getOwner()+"님의 현재 잔액 : "+account1.getBalance());
		//교통카드 사용
		account1.payTrafficCard("5555-55", 1450);
		System.out.println(account1.getOwner()+"님의 현재 잔액 : "+account1.getBalance());
		
		System.out.println();
		
		//예금
		account2.deposit(10000);
		//출금
		account2.withdraw(20000);
		//체크카드 사용
		account2.pay("3333-33", 30000);
		System.out.println(account2.getOwner()+"님의 현재 잔액 : "+account2.getBalance());
		//교통카드 사용
		account2.payTrafficCard("3333-33", 1450);
		System.out.println(account2.getOwner()+"님의 현재 잔액 : "+account2.getBalance());
		
	}
}
