package multipleInheritence;

// 정기 예금 계좌 클래스 
public class TimeDepositAccount extends Account {

	// 추가 속성 : 정기 납입금
	private int fixedAmountMoney;	
	
	@Override
	public boolean transfer() {
		// TODO 정기 예금 계좌 전송 로직 구현 (성공시 true, 실패시 false)
		return true;
	}

	@Override
	public boolean balanceCalculate() {
		// TODO 정기 예금 계좌 잔고계산 로직 구현 (성공시 true, 실패시 false)
		return true;
	}

}
