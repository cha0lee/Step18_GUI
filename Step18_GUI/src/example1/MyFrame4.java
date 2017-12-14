package example1;

import java.awt.BorderLayout;
/*
 * MyFrame4 객체는 Component type도 되고 JFrame type도 되고 ActionListener type도 된다.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame4 extends JFrame 
				implements ActionListener{
	
	//버튼 참조값을 저장할 필드 (initUI에서 값을 설정해준다)
	JButton button1, button2, button3;
	
	//생성자 
	public MyFrame4() {
		initUI();
	}
	//초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//페널 객체 생성
		JPanel panel=new JPanel();
		//버튼 객체 생성
		this.button1=new JButton("버튼1");
		button2=new JButton("버튼2");
		button3=new JButton("버튼3");
		//버튼에 ActionListener 등록하기 
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		//버튼을 페널에 추가
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
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
		new MyFrame4();
	}
	//버튼을 누르면 실행되는 메소드 
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 참조값 얻어오기
		Object btn = e.getSource();
		//btn에 들어있는 참조값과 필드의 값을 비교한다.
		String msg="";
		if(btn==button1) {
			msg = "1번 버튼";
		}else if(btn==button2) {
			msg = "2번 버튼";
		}else if(btn==button3) {
			msg = "3번 버튼";
		}
		//System.out.println("버튼을 눌렀네요?");
		JOptionPane.showMessageDialog(this, msg+ "을 눌렀네?");
	}
}
