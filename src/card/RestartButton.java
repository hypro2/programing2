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
		
		//�������� �ݱ�
		view.dispose();
		
		//�����
		Blackjack blackjack = new Blackjack(11);
		new Frame(blackjack,new Drawing(blackjack));
	}

}

