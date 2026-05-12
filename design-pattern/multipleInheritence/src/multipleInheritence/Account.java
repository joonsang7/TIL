package multipleInheritence;

public abstract class Account {
	
	private int balance;
	
	// 입금 일반함수 -> 계좌에 입금 한 만큼 잔고에 추가  ( 계좌 유효성 검사는 하지 않았습니다.) 
	public void deposit(int depositMoney) { // 
		// balance += dipositMoney;
		if (depositMoney > 0) {
	        balance += depositMoney;
	        System.out.println(depositMoney + "원 입금 완료. 잔액: " + balance + "원");
	    }
	}
	
	// 출금 일반함수 -> 계좌에서 출금하려는 잔고에서 뺀다  ( 계좌 유효성 검사는 하지 않았습니다.) 
	public int withdraw(int withdrawalMoney) { 
		// 	if 계좌에 문제가 없고, 출금 양 이상으로 돈을 보유하고 있다면
		// balance -= withdrawalMoney;
		// System.Out.println(balance);
		// return balance;
		// 	else (계좌에 문제 있거나 보유 금액 부족하다면) return 0;
		 
		if (balance >= withdrawalMoney && withdrawalMoney > 0) {
	        balance -= withdrawalMoney;
	        System.out.println(withdrawalMoney + "원 출금 완료되었습니다. 잔액: " + balance + "원");
	        return balance;
	    } else {
	        System.out.println("출금 실패하였습니다. 잔액 부족 또는 잘못된 금액입니다");
	        return 0;
	    }
	}

	
	public abstract boolean transfer();  // 이체 추상함수
	
	public abstract boolean balanceCalculate(); // 잔액계산 추상함수
	
	
}
