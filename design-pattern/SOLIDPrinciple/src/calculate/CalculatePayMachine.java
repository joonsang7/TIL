package calculate;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class CalculatePayMachine extends Frame implements ActionListener, DocumentListener {

	// Label, TextField, Button attribute 생성
	private JLabel workingHoursLabel = new JLabel("Working Hours = ", Label.RIGHT);
	private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ", Label.RIGHT);
	private JLabel payAmountLabel = new JLabel("Pay Amount = ", Label.RIGHT);

	private JTextField tfWorkingHours = new JTextField();
	private JTextField tfOvertimeHours = new JTextField();
	private JTextField tfResult = new JTextField();

	private JButton calcButton = new JButton("Calculate");
	private JButton resetButton = new JButton("Reset");
	private JButton end = new JButton("Stop");
<<<<<<< HEAD
	
	// CalculatePayMachine 하나가 UI 구성, 이벤트 처리, 급여 계산 로직을 모두 담당하고 있기 떄문에 급여 계산 방식이 바뀌면 UI 클래스를 직접 수정해야 한다. (SRP 위반)
=======

>>>>>>> 85c13cc284f74cd56e94fa364c4b8b0a5a7d8ed7
	public CalculatePayMachine() {
		super("Payment Calculation");
		// init
		this.init();
		// start
		this.start();
		// setSize
		this.setSize(500, 250);
		// setVisible
		this.setVisible(true);
	}

	// init() : Making Panel form
	public void init() {
		this.setLayout(new GridLayout(5, 1));

		Panel p = new Panel(new BorderLayout());
		p.add("West", workingHoursLabel);
		p.add("Center", tfWorkingHours);
		this.add(p);

		Panel p1 = new Panel(new BorderLayout());
		p1.add("West", overTimeHoursLabel);
		p1.add("Center", tfOvertimeHours);
		this.add(p1);

		Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
		p2.add(calcButton);
		this.add(p2);

		Panel p3 = new Panel(new BorderLayout());
		p3.add("West", payAmountLabel);
		p3.add("Center", tfResult);
		this.add(p3);

		Panel p4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(resetButton);
		p4.add(end);
		this.add(p4);

	}

	// start() : 버튼 만들고 리스너로 대기
	public void start() {
		calcButton.addActionListener(this);
		resetButton.addActionListener(this);

		tfWorkingHours.getDocument().addDocumentListener(this);
		tfOvertimeHours.getDocument().addDocumentListener(this);

		end.addActionListener(this);

		calcButton.setEnabled(false);
		resetButton.setEnabled(false);
	}

	// isDataEntered() : 데이터 입력되었는지 확인하는 메서드
	public boolean isDataEntered() {
		if (tfWorkingHours.getText().trim().length() == 0 ||
				tfOvertimeHours.getText().trim().length() == 0)
			return false;

		return true;
	}

	// insertUpdate(DocumentEvent)
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		checkData();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		checkData();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		checkData();
	}

	private void checkData() {
		calcButton.setEnabled(isDataEntered());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == end) {
			System.exit(0);
		}

		// getSource() == resetButton 인 경우
		if (e.getSource() == resetButton) {
			tfWorkingHours.setText("");
			tfOvertimeHours.setText("");
			tfWorkingHours.requestFocus();
			tfResult.setText("");
			resetButton.setEnabled(false);
			return;
		}

		if (e.getSource() == calcButton) {
			int x = 0;
			try {
				x = Integer.parseInt(tfWorkingHours.getText().trim());
			} catch (NumberFormatException ee) {
				tfWorkingHours.setText("");
				tfWorkingHours.requestFocus();
				return;
			}

			int y = 0;
			try {
				y = Integer.parseInt(tfWorkingHours.getText().trim());
			} catch (NumberFormatException ee) {
				tfWorkingHours.setText("");
				tfWorkingHours.requestFocus();
				return;
			}
<<<<<<< HEAD
			
			// 시급(10, 15) 로직이 하드코딩 되어 있기 떄문에 변경 시 수정 범위가 커진다. (OCP 위반)
=======

>>>>>>> 85c13cc284f74cd56e94fa364c4b8b0a5a7d8ed7
			int payAmount = 0;
			payAmount = 10 * x + 15 * y;

			tfResult.setText(String.valueOf(payAmount));
			resetButton.setEnabled(true);
		}
<<<<<<< HEAD
	
=======

	}

	public static void main(String[] args) {
		CalculatePayMachine c = new CalculatePayMachine();

>>>>>>> 85c13cc284f74cd56e94fa364c4b8b0a5a7d8ed7
	}
}
