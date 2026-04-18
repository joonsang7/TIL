package calculate;

/**
 * [분리] 급여 계산 책임만 담당하는 클래스
 * UI와 완전히 독립 → 계산 방식이 바뀌어도 UI 코드 수정 불필요
 */
public class PayCalculator {

    private final int hourlyRate;
    private final int overtimeRate;

    public PayCalculator(int hourlyRate, int overtimeRate) {
        this.hourlyRate = hourlyRate;
        this.overtimeRate = overtimeRate;
    }

    public int calculate(int workingHours, int overtimeHours) {
        return hourlyRate * workingHours + overtimeRate * overtimeHours;
    }
}