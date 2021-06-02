package card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
	
	private Blackjack blackjack;
	private JLabel label =  new JLabel("");
	
	public Frame(Blackjack b){	
		blackjack = b;
		JPanel north = new JPanel(new FlowLayout());
		north.add(label);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add( new MoreCardButton("More Card", blackjack, this));
		south.add( new StopButton("Stop", blackjack, this) );
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(north,BorderLayout.NORTH);
		cp.add(south,BorderLayout.SOUTH);

		setTitle("Blackjack");
		setSize(215,300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void update() {
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	