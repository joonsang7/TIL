import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	/*
	 * professor은 학생의 자바,db,보안 과목의 성적을 등록한다 (교수 id 체크)
	 * 학생은 A,B,C 등급의 학점을 조회할 수 있다.(학생 id 체크)
	 * 
	 * 프로그램이 시작하면 1.학생 2.교수 3.종료 를 입력받고, 학생이면 학생 id를 입력받고, 교수면 교수 id를 입력받기
	 * 
	 * 학생을 입력받으면 1. 신규 등록 2. 성적 조회를 입력. 신규 등록이면 학생 id와 이름을 입력받아서 학생 객체를 생성한다. 성적
	 * 조회면 학생 id를 입력받아서 성적이 존재하면 총합, 평균, 학점을 출력하고, 존재하지 않으면 "학생 정보가 없습니다." 라고 출력
	 * 
	 * 교수를 입력받으면 1. 신규 등록 2. 성적 등록을 입력받는다. 신규 등록이면 교수 id와 이름을 입력받아서 교수 객체를 생성한다. 성적
	 * 등록이면 학생 id와 자바, db, 보안 과목의 점수를 입력받아서 학생 id가 존재하면 성적을 등록하고, 존재하지 않으면
	 * "학생 정보가 없습니다." 출력
	 * 
	 * 등록하거나 조회할때는 id 체크 id가 존재하면 등록 또는 조회가 가능하고, 존재하지 않으면 등록 또는 조회가 불가능
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Map 객체로 학생, 교수, 성적 정보를 저장
		// 학생 id -> 학생 객체, 교수 id -> 교수 객체, 학생 id -> 성적 객체 총 3종류
		Map<String, Student> students = new HashMap<>();
		Map<String, Professor> professors = new HashMap<>();
		Map<String, SungJuk> grades = new HashMap<>();

		// 종료할때까지 반복
		while (true) {
			System.out.println("\n=== 성적 관리 시스템 ===");
			System.out.println("1. 학생 2. 교수 3. 종료");
			System.out.print("선택: ");
			int mainChoice = scanner.nextInt();
			scanner.nextLine();

			if (mainChoice == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (mainChoice == 1) {
				handleStudent(scanner, students, grades);
			} else if (mainChoice == 2) {
				handleProfessor(scanner, professors, students, grades);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

		scanner.close();
	}

	// 학생 메뉴 처리 메서드
	// 파라미터는 학생 정보, 성적 정보를 전달받아서 처리한다. 학생 메뉴에서는 학생 등록과 성적 조회를 처리
	private static void handleStudent(Scanner scanner, Map<String, Student> students, Map<String, SungJuk> grades) {
		System.out.println("\n--- 학생 메뉴 ---");
		System.out.println("1. 신규 등록 2. 성적 조회");
		System.out.print("선택: ");
		int studentChoice = scanner.nextInt();
		scanner.nextLine();

		if (studentChoice == 1) {
			// 학생 신규 등록
			System.out.print("학생 ID 입력: ");
			String studentId = scanner.nextLine().trim();

			if (students.containsKey(studentId)) {
				System.out.println("이미 존재하는 학생 ID입니다.");
				return;
			}

			System.out.print("학생 이름 입력: ");
			String studentName = scanner.nextLine().trim();

			Student student = new Student(studentId, studentName);
			students.put(studentId, student);
			System.out.println("학생 등록 성공.");

		} else if (studentChoice == 2) {
			// 성적 조회
			System.out.print("학생 ID 입력: ");
			String studentId = scanner.nextLine().trim();

			if (!students.containsKey(studentId)) {
				System.out.println("학생 정보가 없습니다.");
				return;
			}

			SungJuk sungJuk = grades.get(studentId);
			if (sungJuk == null || !sungJuk.hasGrades()) {
				System.out.println("등록된 성적이 없습니다.");
				return;
			}

			System.out.println("\n=== 성적 조회 ===");
			System.out.println("학생 ID: " + studentId);
			System.out.println("학생 이름: " + students.get(studentId).name);
			System.out.println("Java: " + sungJuk.getJava());
			System.out.println("DB: " + sungJuk.getDb());
			System.out.println("보안: " + sungJuk.getSecurity());
			System.out.println("총합: " + sungJuk.getTotal());
			System.out.printf("평균: %.2f\n", sungJuk.getAvg());
			System.out.println("학점: " + sungJuk.getDegree());
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 교수 메뉴 처리 메서드
	// 파라미터 : 교수 메뉴에서는 교수 등록과 성적 등록을 처리
	private static void handleProfessor(Scanner scanner, Map<String, Professor> professors,
			Map<String, Student> students, Map<String, SungJuk> grades) {
		System.out.println("\n--- 교수 메뉴 ---");
		System.out.println("1. 신규 등록 2. 성적 등록");
		System.out.print("선택: ");
		int professorChoice = scanner.nextInt();
		scanner.nextLine();

		if (professorChoice == 1) {
			// 교수 신규 등록
			System.out.print("교수 ID 입력: ");
			String professorId = scanner.nextLine().trim();

			if (professors.containsKey(professorId)) {
				System.out.println("이미 존재하는 교수 ID입니다.");
				return;
			}

			System.out.print("교수 이름 입력: ");
			String professorName = scanner.nextLine().trim();

			Professor professor = new Professor(professorId);
			professors.put(professorId, professor);
			System.out.println("교수 등록 성공.");

		} else if (professorChoice == 2) {
			// 성적 등록
			System.out.print("학생 ID 입력: ");
			String studentId = scanner.nextLine().trim();

			if (!students.containsKey(studentId)) {
				System.out.println("학생 정보가 없습니다.");
				return;
			}

			int javaScore = readScore(scanner, "Java");
			int dbScore = readScore(scanner, "DB");
			int securityScore = readScore(scanner, "보안");

			SungJuk sungJuk = grades.getOrDefault(studentId, new SungJuk(studentId));
			if (sungJuk.add(studentId, javaScore, dbScore, securityScore)) {
				grades.put(studentId, sungJuk);
			}

		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 점수 입력을 위한 메서드
	private static int readScore(Scanner scanner, String subject) {
		while (true) {
			System.out.print(subject + " 점수 입력 (0~100): ");
			try {
				int score = Integer.parseInt(scanner.nextLine().trim());
				if (score < 0 || score > 100) {
					System.out.println("점수는 0에서 100 사이여야 합니다.");
					continue;
				}
				return score;
			} catch (NumberFormatException e) {
				System.out.println("올바른 숫자를 입력하세요.");
			}
		}
	}
}
