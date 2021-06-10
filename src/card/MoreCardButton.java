package card;


import java.awt.event.*;
import javax.swing.*;

public class MoreCardButton extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;

	public MoreCardButton(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//시작할 때 2장 받기
		if (model.stop()) {
			model.hit();}
		
		model.hit();
		view.update();
	}

}

