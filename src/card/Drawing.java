package card;

import java.awt.*;
import javax.swing.*;

public class Drawing extends JPanel {
	
	private Blackjack blackjack;
	
	public Drawing(Blackjack b) {
		blackjack = b;
		setSize(200,200);
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 300);
		
		g.setColor(Color.red);
		g.drawString("�ΰ� ī��",10,10);
		g.drawString(blackjack.HumanCard(),10,50);
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("�ΰ��� Burst!!!!",10,80);}
		
		g.setColor(Color.blue);
		g.drawString("��ǻ�� ī��",10,120);
		if (!blackjack.stop()) {
			g.drawString(blackjack.ComCard(),10,160);
			if ( blackjack.ComSumCard() >21) {
				g.drawString("��ǻ���� Burst!!!!",10,190);}
			
			g.setColor(Color.orange);
			Font font = g.getFont().deriveFont( 20.0f );
		    g.setFont( font );

			g.drawString("���� : "+ blackjack.winner(), 150, 220);
			}
		else {g.drawString("���",10,160);}
		
		
		}
	}


