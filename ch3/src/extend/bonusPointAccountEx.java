package extend;

public class bonusPointAccountEx {

	public static void main(String[] args) {
		// BonusPointAccount 객체 생성
		BonusPointAccount account1 = new BonusPointAccount("123-12", "홍길동", 0, 0);
		
		// 예금
		account1.deposit(200000);
		System.out.println(account1.getOwner()+"님의 현재 잔액 : "+account1.getBalance());
		
		// 보너스 포인트 출력
		System.out.println(account1.getOwner()+"님의 현재 보너스 포인트 : "+account1.getBonusPoint());
	}

}
