package multipleInheritence;

// 자산 관리 계좌 클래스
public class CashManagementAccount extends Account {

	// 추가 속성 : 예치금
	private int deposit;
	
	@Override
	public boolean transfer() {
		// TODO 자산 관리 계좌 전송 로직 구현 (성공시 true, 실패시 false)
		return true;
	}

	@Override
	public boolean balanceCalculate() {
		// TODO 자산 관리 계좌 잔고계산 로직 구현 (성공시 true, 실패시 false)
		return true;
	}

}
