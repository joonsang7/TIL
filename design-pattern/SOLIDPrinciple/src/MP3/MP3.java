package MP3;

// SRP (단일 책임 원칙): 음악 재생/정지 책임만 가짐
// OCP (개방-폐쇄 원칙): Playable 인터페이스를 구현해 확장에 열려 있음

public class MP3 implements Playable {

	@Override
	public void playSong() {
		System.out.println("[MP3] 노래를 재생합니다.");
	}

	@Override
	public void stopSong() {
		System.out.println("[MP3] 노래를 정지합니다.");
	}
}



