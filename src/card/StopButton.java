package card;

import java.awt.event.*;
import javax.swing.*;

public class StopButton extends JButton implements ActionListener {

	
	private Blackjack model;
	private Frame view;
	
	public StopButton(String label, Blackjack m, Frame v) {
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