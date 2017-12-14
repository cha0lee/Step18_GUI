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

public class MyFrame7_1 extends JFrame 
				implements ActionListener{
	//JTextField 객체의 참조값을 저장할 필드 선언
	JTextField inputNum1, inputNum2, result;
	
	//생성자 
	public MyFrame7_1() {
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
		
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multiBtn=new JButton("*");
		JButton divideBtn=new JButton("/");
		
		// 버튼에 ActionListener 객체 등록 
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		// 버튼에 action command 등록
		plusBtn.setActionCommand("plus");
		minusBtn.setActionCommand("minus");
		multiBtn.setActionCommand("multi");
		divideBtn.setActionCommand("divide");
		
		//레이블 객체 생성 
		JLabel equalLabel=new JLabel("=");
		// 페널에 UI 추가 
		panel.add(inputNum1);
		panel.add(plusBtn);
		panel.add(minusBtn);
		panel.add(multiBtn);
		panel.add(divideBtn);
		panel.add(inputNum2);
		panel.add(equalLabel);
		panel.add(result);
		
		//페널을 프레임의 위쪽(북쪽) 에 배치
		add(panel, BorderLayout.NORTH);
		// setBounds(x, y, width, height)
		setBounds(100, 100, 800, 500);
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
		
		// action command 읽어오기
		String command=e.getActionCommand();
		
		//결과 값을 담을 변수 만들기 
		double result=0;
		
		if(command.equals("plus")) {
			result=num1+num2;
		}else if(command.equals("minus")) {
			result=num1-num2;
		}else if(command.equals("multi")) {
			result=num1*num2;
		}else if(command.equals("divide")) {
			result=num1/num2;
		}
		
		//출력하기
		this.result.setText(Double.toString(result));
	}
}