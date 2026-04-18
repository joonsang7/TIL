package MP3;

// SRP (단일 책임 원칙): 시간 확인 후 알림 책임만 가짐
// DIP (의존성 역전 원칙): 구체 클래스(MP3, RealTimeProvider)가 아닌
//                        추상화(Playable, TimeProvider)에 의존
public class TimeReminder {

	private TimeProvider tProv; // 추상화에 의존
	private Playable player;    // 추상화에 의존
	private MP3 m;

	// 생성자 주입(Constructor Injection): 필수 의존성 명시
	public TimeReminder(Playable player) {
		this.player = player;
	}

	// 세터 주입(Setter Injection): 런타임에 Real/Fake 교체 가능
	public void setTimeProvider(TimeProvider tProv) {
		this.tProv = tProv;
	}

	// 현재 시간을 확인하고 22시 이후면 알림 재생
	public void reminder() {
		int hour = tProv.getTime();
		if (hour >= 22) {
			System.out.println("현재 시각: " + hour + "시 - 취침 시간입니다!");
			player.playSong();
		} else {
			System.out.println("현재 시각: " + hour + "시 - 아직 22시가 안 됐습니다.");
		}
	}
}
