package card;

import java.awt.event.*;
import javax.swing.*;

public class MoreCardButton extends JButton implements ActionListener {

	
	private Blackjack model;
	private Frame view;
	
	public MoreCardButton(String label, Blackjack m, Frame v) {
		super(label);
		model =m;
		view = v;
		addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e) {
		//model.increment();
		//view.update();
	}
}
