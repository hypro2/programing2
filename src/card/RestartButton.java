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
		if(!model.stop()) {
			model.chogihwa();
			model.hit();
			model.hit();
			view.update();}
	}

}

