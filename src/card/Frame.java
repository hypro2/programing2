package card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Frame extends JFrame implements ActionListener {
	
	private Blackjack blackjack;
	private JPanel drawing;

	private JLabel label1 =  new JLabel("�ΰ��� ī��? /");
	private JLabel label2 =  new JLabel("��ǻ���� ī��? /");
	private JLabel label3 =  new JLabel("���ڴ�?");
	
	public Frame(Blackjack b,  JPanel panel){	
		blackjack = b; 
		drawing = panel;
		Container cp = getContentPane();
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(label1);
		north.add(label2);
		north.add(label3);
		JPanel south = new JPanel(new FlowLayout());
		south.add(new RestartButton("Restart",this));
		south.add(new MoreCardButton("Hit!",blackjack,this));
		south.add(new StopButton("Stop!", blackjack, this)); 
		south.add(new ExitButton("Exit")); 
		
		cp.setLayout(new BorderLayout());
		cp.add(north, BorderLayout.NORTH);
		cp.add(drawing, BorderLayout.CENTER);
		cp.add(south, BorderLayout.SOUTH);
		
		setTitle("Blackjack");
		setSize(480,350);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void update() {
		label1.setText("�ΰ��� ī�� �� : "+blackjack.HumanSumCard()+" /");
		if (!blackjack.stop()) {
			label2.setText("��ǻ���� ī�� �� : "+blackjack.ComSumCard()+" /");
			label3.setText("���� : "+ blackjack.winner());}
		else {
			label2.setText("��ǻ���� ī�� �� : ��� /");	
			label3.setText("���� : ���");
		}
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	