package calculate;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * [UI 전담] 화면 구성 + 이벤트 처리만 담당
 * 계산 로직은 PayCalculator에 위임
 */
public class CalculatePayMachine2 extends Frame implements ActionListener, DocumentListener {

    private JLabel workingHoursLabel  = new JLabel("Working Hours = ",  Label.RIGHT);
    private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ", Label.RIGHT);
    private JLabel payAmountLabel     = new JLabel("Pay Amount = ",     Label.RIGHT);

    private JTextField tfWorkingHours  = new JTextField();
    private JTextField tfOvertimeHours = new JTextField();
    private JTextField tfResult        = new JTextField();

    private JButton calcButton  = new JButton("Calculate");
    private JButton resetButton = new JButton("Reset");
    private JButton end         = new JButton("Stop");

    // [개선] 계산 책임을 외부 객체에 위임 (시급 10, 잔업 시급 15)
    private final PayCalculator calculator = new PayCalculator(10, 15);

    public CalculatePayMachine2() {
        super("Payment Calculation");
        init();
        start();
        setSize(500, 250);
        setVisible(true);
    }

    public void init() {
        setLayout(new GridLayout(5, 1));

        Panel p = new Panel(new BorderLayout());
        p.add("West", workingHoursLabel);
        p.add("Center", tfWorkingHours);
        add(p);

        Panel p1 = new Panel(new BorderLayout());
        p1.add("West", overTimeHoursLabel);
        p1.add("Center", tfOvertimeHours);
        add(p1);

        Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        p2.add(calcButton);
        add(p2);

        Panel p3 = new Panel(new BorderLayout());
        p3.add("West", payAmountLabel);
        p3.add("Center", tfResult);
        add(p3);

        Panel p4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
        p4.add(resetButton);
        p4.add(end);
        add(p4);

        // [개선] 결과 필드는 읽기 전용
        tfResult.setEditable(false);
    }

    public void start() {
        calcButton.addActionListener(this);
        resetButton.addActionListener(this);
        end.addActionListener(this);

        tfWorkingHours.getDocument().addDocumentListener(this);
        tfOvertimeHours.getDocument().addDocumentListener(this);

        calcButton.setEnabled(false);
        resetButton.setEnabled(false);
    }

    private boolean isDataEntered() {
        return !tfWorkingHours.getText().trim().isEmpty()
            && !tfOvertimeHours.getText().trim().isEmpty();
    }

    // [개선] 두 입력 필드 모두 감시해 reset 버튼도 함께 제어
    private void checkData() {
        boolean entered = isDataEntered();
        calcButton.setEnabled(entered);
        resetButton.setEnabled(entered);   // 입력 중에도 초기화 가능
    }

    @Override public void insertUpdate(DocumentEvent e)  { checkData(); }
    @Override public void removeUpdate(DocumentEvent e)  { checkData(); }
    @Override public void changedUpdate(DocumentEvent e) { checkData(); }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == end) {
            System.exit(0);
            return;
        }

        if (e.getSource() == resetButton) {
            tfWorkingHours.setText("");
            tfOvertimeHours.setText("");
            tfResult.setText("");
            tfWorkingHours.requestFocus();
            return;
        }

        if (e.getSource() == calcButton) {
            int x, y;

            try {
                x = Integer.parseInt(tfWorkingHours.getText().trim());
            } catch (NumberFormatException ex) {
                tfWorkingHours.setText("");
                tfWorkingHours.requestFocus();
                return;
            }

            try {
                // [버그 수정] 반드시 tfOvertimeHours에서 읽어야 함
                y = Integer.parseInt(tfOvertimeHours.getText().trim());
            } catch (NumberFormatException ex) {
                tfOvertimeHours.setText("");
                tfOvertimeHours.requestFocus();
                return;
            }

            // [개선] 계산을 PayCalculator에 위임
            int payAmount = calculator.calculate(x, y);
            tfResult.setText(String.valueOf(payAmount));
        }
    }

    public static void main(String[] args) {
        new CalculatePayMachine();
    }
}