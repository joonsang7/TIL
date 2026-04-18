public class Student {
	public String userId;
	public String name;

	public Student(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	// 학생 객체. User가 존재하면 return true, 없으면 false 반환하는 코드 작성
	public boolean checkStudent(String userId) {
		if (userId.equals(this.userId)) {
			return true;
		} else {
			return false;
		}
	}
}
