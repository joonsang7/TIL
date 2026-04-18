package MP3;

// ISP (인터페이스 분리 원칙): 재생 책임만 담당하는 인터페이스
// DIP (의존성 역전 원칙): TimeReminder 가 MP3 구체 클래스가 아닌 이 추상화에 의존

public interface Playable {
    void playSong();
    void stopSong();
}
