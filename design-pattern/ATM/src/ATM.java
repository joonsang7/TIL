public class ATM {
	
	// 부품 객체 
	private Account acc;
	private User user;
	
	public ATM(Account acc, User user) {
		this.acc = acc;
		this.user = user;
	}
	
	/*
	 * 집단화를 통해 부품객체의 메서드를 실행한다 . ATM 객체가 없어도 Account와 User 가 존재해야 하기 때문에,
	 * ATM 과 Account,User 의 생명주기를 분리하여 필요 시에 기능을 호출하도록 한다. 
	 */
	
	// 입금 메서드 
	public float deposite(String id, float inMoney) {
		float balance = acc.deposite(id, inMoney); 
		// 예금 후 잔고 반환 
		return balance;
	}
	
	// 출금 메서드 
	public float withdraw(String id, float outMoney) {
		float balance = acc.withdraw(id, outMoney);
		// 출금 후 잔고 반환  
		return balance;
	}
	
	// 송금 메서드 
	public float transfer(String id, float transferMoney, String transferNum) {
		float balance = acc.transfer(id, transferMoney, transferNum);
		// 송금 후 잔고 반환 
		return balance;
	}
	
	// 유저 추가 메서드 
	public boolean addUser(String id, String pw, String address, String phone) {
		if(user.addUser(id, pw, address, phone)) {
			System.out.println("계정 추가 성공 ");
			return true;
		} else {
			System.out.println("계정 추가 실패 ");
			return false;
		}
	}
}
