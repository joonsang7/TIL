
public abstract class Account {

	public void deposit() {
		// 입금 일반 함수
	}
	
	public void Withdraw() {
		// 출금 일반 함수
	}
	
	public abstract void transfer() {
		// 이체 추상 함수
	}
	
	public abstract void balanceCalculate() {
		// 잔액계산 추상 함수
	}
}
