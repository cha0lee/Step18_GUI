package example1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame7 extends JFrame 
				implements ActionListener{
	//JTextField 객체의 참조값을 저장할 필드 선언
	JTextField inputNum1, inputNum2, result;
	
	//생성자 
	public MyFrame7() {
		initUI();
	}
	//초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//페널 객체 생성
		JPanel panel=new JPanel();
		//문자열을 입력 받을수 있는 JTextField 객체 
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		//결과를 출력할 TextField
		result=new JTextField(10);
		
		JButton sendBtn=new JButton("+");
		sendBtn.addActionListener(this);
		//레이블 객체 생성 
		JLabel equalLabel=new JLabel("=");
		// 페널에 UI 추가 
		panel.add(inputNum1);
		panel.add(sendBtn);
		panel.add(inputNum2);
		panel.add(equalLabel);
		panel.add(result);
		
		//페널을 프레임의 위쪽(북쪽) 에 배치
		add(panel, BorderLayout.NORTH);
		// setBounds(x, y, width, height)
		setBounds(100, 100, 500, 500);
		// x 를 눌러서 창을 닫았을때 프로세스가 종료 되도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임 객체가 화면에 보이도록 
		setVisible(true);
	}
	//메인 메소드 
	public static void main(String[] args) {
		new MyFrame7();
	}
	//버튼을 누르면 실행되는 메소드 
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력한 문자열을 숫자로 바꿔서 읽어들이기
		double num1=Double.parseDouble(inputNum1.getText());
		double num2=Double.parseDouble(inputNum2.getText());
		//두수의 합을 구한다.
		double result=num1+num2;
		//출력하기
		this.result.setText(Double.toString(result));
		
	}
}
