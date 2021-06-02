package card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Frame extends JFrame implements ActionListener {
	
	private Blackjack blackjack;
	private JPanel drawing;
	private JLabel label1 =  new JLabel("인간의 카드?");
	private JLabel label2 =  new JLabel("컴퓨터의 카드?");
	private JLabel label3 =  new JLabel("승자는?");
	
	public Frame(Blackjack b,  JPanel panel){	
		blackjack = b; 
		drawing = panel;
		
		Container cp = getContentPane();
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(label1);
		north.add(label2);
		
		JPanel center = new JPanel(new FlowLayout());
		center.add(label3);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add(new Button("결과 발표!", blackjack, this)); 
		
		cp.setLayout(new BorderLayout());
		cp.add(north, BorderLayout.NORTH);
		cp.add(drawing, BorderLayout.CENTER);
		cp.add(south, BorderLayout.SOUTH);
		
		setTitle("Blackjack");
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void update() {
		label1.setText("인간 합: "+blackjack.getHumanSum()+"");
		label2.setText("컴퓨터 합: "+blackjack.getComSum()+"");
		label3.setText(blackjack.winner());
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	