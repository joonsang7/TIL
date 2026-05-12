package multipleInheritence;

// 증권 예탁 계좌 클래스 
public class SecuritiesAccount extends Account {

	// 추가 속성: 예치금, 증권 계좌
	private int deposit;
	private String securitiesAccount;
	
	
	@Override
	public boolean transfer() {
		// TODO 증권 예탁 계좌 전송 로직 구현 (성공시 true, 실패시 false)
		return true;
	}

	@Override
	public boolean balanceCalculate() {
		// TODO 증권 예탁 계좌 잔고계산 로직 구현 (성공시 true, 실패시 false)
		return true;
	
	}

}
