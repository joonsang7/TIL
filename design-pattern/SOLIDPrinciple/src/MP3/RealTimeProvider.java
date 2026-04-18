package MP3;
import java.util.Calendar;

// 실제 시스템 시간을 제공하는 구현체 (클래스 이름의 오타: RealTimeProvider 가 맞으나 파일명 유지)
// LSP (리스코프 치환 원칙): TimeProvider 를 완전히 대체 가능
public class RealTimeProvider implements TimeProvider {

	// 실제 시간 제공자는 외부에서 시간을 설정할 수 없으므로 아무 동작도 하지 않음
	@Override
	public void setHours(int hours) {
	}

	// 매번 호출 시 현재 시스템 시간을 반환
	@Override
	public int getTime() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
}
