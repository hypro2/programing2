package card;

import java.awt.event.*;
import javax.swing.*;

public class RestartButton extends JButton implements ActionListener {
	private Frame view;

	public RestartButton(String label, Frame v) {
		super(label);
		view = v;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//프레임을 닫기
		view.dispose();
		
		//재시작
		Blackjack blackjack = new Blackjack(11);
		new Frame(blackjack,new Drawing(blackjack));
	}

}

