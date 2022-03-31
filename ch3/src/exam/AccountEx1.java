package exam;

public class AccountEx1 {
	public static void main(String[] args) {
		Account1 account = new Account1();
		
		account.setBalance(10000);
		System.out.println(account.getBalance());
		account.setBalance(-15000);
		System.out.println(account.getBalance());
		account.setBalance(1000000);
		System.out.println(account.getBalance());
		
	}
}
