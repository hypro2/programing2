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
		g.drawString("인간 카드",10,10);
		g.drawString(blackjack.HumanCard(),10,50);
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("인간의 Burst!!!!",10,80);}
		
		g.setColor(Color.blue);
		g.drawString("컴퓨터 카드",10,120);
		if (!blackjack.stop()) {
			g.drawString(blackjack.ComCard(),10,160);
			if ( blackjack.ComSumCard() >21) {
				g.drawString("컴퓨터의 Burst!!!!",10,190);}
			
			g.setColor(Color.orange);
			Font font = g.getFont().deriveFont( 20.0f );
		    g.setFont( font );

			g.drawString("승자 : "+ blackjack.winner(), 150, 220);
			}
		else {g.drawString("비밀",10,160);}
		
		
		}
	}


