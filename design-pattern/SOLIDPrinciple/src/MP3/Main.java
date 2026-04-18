package MP3;

public class Main {

	public static void main(String[] args) {
		
		// Playable 인터페이스 타입으로 선언 -> DIP 적용
		Playable mp3 = new MP3();
		TimeReminder reminder = new TimeReminder(mp3);
		

		// ── 테스트 1: FakeTimeProvider (10시) ──────────────────────────
		System.out.println("=== [Fake] 10시 테스트 ===");
		FakeTimeProvider fake = new FakeTimeProvider(24);
		reminder.setTimeProvider(fake);
		reminder.reminder();

		// ── 테스트 2: FakeTimeProvider (23시) ──────────────────────────
		System.out.println("\n=== [Fake] 23시 테스트 ===");
		fake.setHours(23);
		reminder.reminder();

		// ── 테스트 3: RealRimeProvider (실제 시스템 시간) ───────────────
		System.out.println("\n=== [Real] 실제 시스템 시간 테스트 ===");
		RealTimeProvider real = new RealTimeProvider();
		reminder.setTimeProvider(real);
		reminder.reminder();
	}
}
