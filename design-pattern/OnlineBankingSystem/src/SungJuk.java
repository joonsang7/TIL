public class SungJuk {

	private String userId;
	private int java;
	private int db;
	private int security;
	private int total;
	private float avg;
	private boolean hasGrades;

	public SungJuk(String userId) {
		this.userId = userId;
	}

	public boolean add(String userId, int java, int db, int security) {
		if (!this.userId.equals(userId)) {
			System.out.println("성적 등록 실패. 학생 정보가 없습니다.");
			return false;
		}

		this.java = java;
		this.db = db;
		this.security = security;
		calculateAvg();
		this.hasGrades = true;
		System.out.println("성적 등록 성공.");
		return true;
	}

	private void calculateAvg() {
		total = java + db + security;
		avg = total / 3.0f;
	}

	public String getDegree() {
		if (!hasGrades) {
			return "성적이 등록되지 않았습니다.";
		}

		calculateAvg();
		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else {
			return "D";
		}
	}

	public int getTotal() {
		return total;
	}

	public float getAvg() {
		return avg;
	}

	public int getJava() {
		return java;
	}

	public int getDb() {
		return db;
	}

	public int getSecurity() {
		return security;
	}

	public boolean hasGrades() {
		return hasGrades;
	}
}
