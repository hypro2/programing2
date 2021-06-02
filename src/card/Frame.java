package card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Frame extends JFrame implements ActionListener {
	
	private Blackjack blackjack;
	private JLabel label =  new JLabel("���ڴ�?");
	
	public Frame(Blackjack b){	
		blackjack = b; 
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(label);
		cp.add(new Button("��� ��ǥ!", blackjack, this));
		setTitle("Blackjack");
		setSize(215,100);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void update() {
		label.setText(blackjack.winner()+"!!!!");
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	