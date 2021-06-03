package card;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoreCardButton extends JButton implements ActionListener {
	private Frame view;
	private Blackjack model;
	private Dealer dealer;
	private HumanPlayer humanPlayer;
	
	public MoreCardButton(String label, Blackjack m, Frame v) {
		super(label);
		view = v;
		model = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		model.hit();
		view.update();
	}

}

