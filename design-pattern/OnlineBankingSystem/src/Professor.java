public class Professor extends Person {

	public Professor(String professorId, String name) {
		super(professorId, name); // 부모 생성자 호출
	}

	// 오버라이딩: 교수 전용 id 체크
	@Override
	public boolean checkUser(String userId) {
		System.out.println("[교수 인증 확인]");
		return super.checkUser(userId);
	}

	// 오버라이딩: 교수 전용 출력
	@Override
	public void printInfo() {
		System.out.print("[교수] ");
		super.printInfo();
	}
}