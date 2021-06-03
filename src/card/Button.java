package card;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;
	
	/** CountButton - 버튼 컨트롤러 
	 * @param label - 버튼에 붙는 라벨 
	 * @param m - 협조할 모델 
	 * @param v - 갱신할 뷰 */
	public Button(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	/** actionPerformed - '버튼 누르기' 액션 이벤트를 처리 
	 * @param e - 이벤트 */
	//딜러의 역할을 버튼으로 해야될...
	public void actionPerformed(ActionEvent e) {
		view.update();
	}

}

