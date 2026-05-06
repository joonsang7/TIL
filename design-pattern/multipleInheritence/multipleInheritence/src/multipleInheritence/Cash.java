package multipleInheritence;

public class Cash extends Payment implements Bank {
	public String account;
	
	@Override
	public void pay() {
		// Payment 클래스의 pay 메서드 오버라이딩 -> 지불 수행 
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		//Bank interface 의 withdraw 메서드 구현 -> 출금 수행 
		
	}
		
	
}
