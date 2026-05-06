package multipleInheritence;

public class CreditCard extends Payment {
	public String cardNum;
	
	@Override
	public void pay() {
		// Payment 클래스의 pay 메서드 오버라이딩 -> 지불 수행 
	}
	
	public void transfer() {
		// 전송 메서드 ,  전송 알고리즘 수행 ( 카드 -> Other )
	}
}
