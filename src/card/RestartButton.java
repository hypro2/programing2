package card;

import java.awt.event.*;
import javax.swing.*;

public class RestartButton extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;

	public RestartButton(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		view.dispose();
		Blackjack blackjack = new Blackjack(11);
		new Frame(blackjack,new Drawing(blackjack));
	}

}

