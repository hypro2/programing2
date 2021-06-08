package card;


import java.awt.event.*;
import javax.swing.*;

public class MoreCardButton extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;
	private boolean firstHit = true;

	public MoreCardButton(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//������ �� 2�� �ޱ�
		if (firstHit) {
			model.hit();
			firstHit = false;}
		
		model.hit();
		view.update();
	}

}

