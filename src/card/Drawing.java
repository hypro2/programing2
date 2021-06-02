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
		g.drawString("인간의 카드는 : "+blackjack.HumanCard(),10,10);
		g.setColor(Color.blue);
		g.drawString("컴퓨터의 카드 : "+blackjack.ComCard(),10,30);
		}
	}

