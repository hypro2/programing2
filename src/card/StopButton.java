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
		model.stophuman();
		view.update();
	}

}

