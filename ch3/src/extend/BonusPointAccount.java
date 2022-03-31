package extend;

public class BonusPointAccount extends Account {
	
	//보너스 포인트(정수형)
	private int bonusPoint;
	
	public BonusPointAccount(String accountNo, String owner, int balance, int bonusPoint) {
		super(accountNo, owner, balance);
		this.bonusPoint = bonusPoint;
		// TODO Auto-generated constructor stub
	}
	
	//예금 + 보너스 포인트 같이 계산
	@Override
	int deposit(int amount) {
		//예금, super : 부모꺼를 부를 때
		super.deposit(amount);
		//보너스 포인트 = 예금액 * 0.1%
		bonusPoint = (int)(amount * 0.001);
		return bonusPoint;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}
}
