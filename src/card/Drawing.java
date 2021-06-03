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
		g.fillRect(0, 0, 500, 200);
		
		g.setColor(Color.red);
		if(blackjack.HumanCard() != null) {
			g.drawString("인간 카드 : "+blackjack.HumanCard(),10,10);}
		else {g.drawString("인간 드로우",10,10);}
		
		g.setColor(Color.blue);
		if (!blackjack.stop()) {
			if(blackjack.ComCard() != null) {
				g.drawString("컴퓨터 카드 : "+blackjack.ComCard(),10,30);}
			else {g.drawString("컴퓨터 드로우",10,30);}
		}
		else {
			g.drawString("컴퓨터 카드 : 비밀",10,30);}
		}
	}


