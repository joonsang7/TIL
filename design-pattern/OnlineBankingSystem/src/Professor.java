public class Professor {

	private String professorId;

	public Professor(String professorId) {
		this.professorId = professorId;
	}

	// 교수 객체. User가 존재하면 return true, 없으면 false 반환하는 코드 작성
	public boolean checkProfessor(String userId) {
		if (userId.equals(this.professorId)) {
			return true;
		} else {
			return false;
		}
	}

}
