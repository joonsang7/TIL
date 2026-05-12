package multipleInheritence;

// 일반계좌 클래스
public class CurrentAccount extends Account {

	@Override
	public boolean transfer() {
		// TODO 일반계좌 전송 로직 구현 (성공시 true, 실패시 false)
		return true;
	
	}

	@Override
	public boolean balanceCalculate() {
		// TODO 일반계좌 잔고계산 로직 구현 (성공시 true, 실패시 false)
		return true;
	
	}

}
