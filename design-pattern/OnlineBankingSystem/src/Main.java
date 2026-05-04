import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Student> students = new HashMap<>();
		Map<String, Professor> professors = new HashMap<>();
		Map<String, SungJuk> grades = new HashMap<>();

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

	private static void handleStudent(Scanner scanner, Map<String, Student> students, Map<String, SungJuk> grades) {
		System.out.println("\n--- 학생 메뉴 ---");
		System.out.println("1. 신규 등록 2. 성적 조회 3. 전체 목록");
		System.out.print("선택: ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1) {
			System.out.print("학생 ID 입력: ");
			String id = scanner.nextLine().trim();
			if (students.containsKey(id)) {
				System.out.println("이미 존재하는 학생 ID입니다.");
				return;
			}
			System.out.print("학생 이름 입력: ");
			String name = scanner.nextLine().trim();

			Student student = new Student(id, name);
			students.put(id, student);
			System.out.println("학생 등록 성공.");

		} else if (choice == 2) {
			System.out.print("학생 ID 입력: ");
			String id = scanner.nextLine().trim();

			if (!students.containsKey(id)) {
				System.out.println("학생 정보가 없습니다.");
				return;
			}

			// checkUser() 다형성 활용
			Student student = students.get(id);
			if (!student.checkUser(id)) {
				System.out.println("인증 실패.");
				return;
			}

			SungJuk sungJuk = grades.get(id);
			if (sungJuk == null || !sungJuk.hasGrades()) {
				System.out.println("등록된 성적이 없습니다.");
				return;
			}

			System.out.println("\n=== 성적 조회 ===");
			student.printInfo(); // 오버라이딩된 printInfo() 호출
			System.out.println("Java: " + sungJuk.getJava());
			System.out.println("DB: " + sungJuk.getDb());
			System.out.println("보안: " + sungJuk.getSecurity());
			System.out.println("총합: " + sungJuk.getTotal());
			System.out.printf("평균: %.2f\n", sungJuk.getAvg());
			System.out.println("학점: " + sungJuk.getDegree());

		} else if (choice == 3) {
			// 다형성: Person 타입으로 전체 출력
			System.out.println("\n=== 전체 학생 목록 ===");
			for (Person p : students.values()) {
				p.printInfo(); // 각 객체 타입에 맞는 printInfo() 호출
			}
		}
	}

	private static void handleProfessor(Scanner scanner, Map<String, Professor> professors,
			Map<String, Student> students, Map<String, SungJuk> grades) {
		System.out.println("\n--- 교수 메뉴 ---");
		System.out.println("1. 신규 등록 2. 성적 등록");
		System.out.print("선택: ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1) {
			System.out.print("교수 ID 입력: ");
			String id = scanner.nextLine().trim();
			if (professors.containsKey(id)) {
				System.out.println("이미 존재하는 교수 ID입니다.");
				return;
			}
			System.out.print("교수 이름 입력: ");
			String name = scanner.nextLine().trim();

			Professor professor = new Professor(id, name);
			professors.put(id, professor);
			professor.printInfo(); // 오버라이딩된 printInfo() 호출
			System.out.println("교수 등록 성공.");

		} else if (choice == 2) {
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
		}
	}

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