public class Student extends Person {

	public Student(String userId, String name) {
		super(userId, name); // 부모 생성자 호출
	}

	// 오버라이딩: 학생 전용 id 체크
	@Override
	public boolean checkUser(String userId) {
		System.out.println("[학생 인증 확인]");
		return super.checkUser(userId);
	}

	// 오버라이딩: 학생 전용 출력
	@Override
	public void printInfo() {
		System.out.print("[학생] ");
		super.printInfo();
	}
}