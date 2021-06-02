package card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Frame extends JFrame implements ActionListener {
	
	private Blackjack blackjack;
	private JLabel label1 =  new JLabel("�ΰ��� ī��?");
	private JLabel label2 =  new JLabel("��ǻ���� ī��?");
	private JLabel label3 =  new JLabel("���ڴ�?");
	
	public Frame(Blackjack b){	
		blackjack = b; 
		Container cp = getContentPane();
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(label1);
		north.add(label2);
		
		JPanel center = new JPanel(new FlowLayout());
		center.add(label3);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add(new Button("��� ��ǥ!", blackjack, this)); 
		
		cp.setLayout(new BorderLayout());
		cp.add(north, BorderLayout.NORTH);
		cp.add(center, BorderLayout.CENTER);
		cp.add(south, BorderLayout.SOUTH);
		
		setTitle("Blackjack");
		setSize(215,140);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void update() {
		label1.setText("�ΰ� : "+blackjack.get_Human_sum());
		label2.setText("��ǻ�� : "+blackjack.get_Com_sum()+"");
		label3.setText(blackjack.winner());
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	