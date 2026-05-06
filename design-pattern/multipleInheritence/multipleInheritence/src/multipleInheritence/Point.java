package multipleInheritence;

public class Point extends Payment {

	public int point;
	
	@Override
	public void pay() {
		// Payment 클래스의 pay 메서드 오버라이딩 -> 지불 수행 
	}
	
	public void check() {
		// 포인트(존재 여부, 사용 가능 여부) 체크 메서드 
	}
}


