package example1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 *   MyFrame4 객체는 
 *   Component type 도 되고
 *   JFrame type 도 되고
 *   ActionListener type 도 된다. 
 */
public class MyFrame5 extends JFrame 
				implements ActionListener{
	
	//생성자 
	public MyFrame5() {
		initUI();
	}
	//초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//페널 객체 생성
		JPanel panel=new JPanel();
		//버튼 객체 생성 해서 참조값을 필드에 저장 
		JButton button1=new JButton("입력");
		JButton button2=new JButton("수정");
		JButton button3=new JButton("삭제");
		//버튼에 action command 등록
		button1.setActionCommand("input");
		button2.setActionCommand("update");
		button3.setActionCommand("delete");
		
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
		JButton btn=(JButton)e.getSource();
		// 버튼에 설정된 action command 를 읽어온다. 
		String command=btn.getActionCommand();
		// java 에서 문자열 비교는 반드시
		// .equals() 메소드를 이용해서 비교한다. 
		if(command.equals("input")) {
			JOptionPane.showMessageDialog(this, "입력합니다.");
		}else if(command.equals("update")) {
			JOptionPane.showMessageDialog(this, "수정합니다.");
		}else if(command.equals("delete")) {
			JOptionPane.showMessageDialog(this, "삭제합니다.");
		}
	}
}