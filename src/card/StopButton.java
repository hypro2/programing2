package card;

import java.awt.event.*;
import javax.swing.*;

public class StopButton extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;

	public StopButton(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//인간의 차례를 끝내고 컴퓨터의 값을 공개
		model.HumanTurnEnd();
		view.update();
	}

}

