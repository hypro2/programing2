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
			g.drawString("�ΰ� ī�� : "+blackjack.HumanCard(),10,10);}
		else {g.drawString("�ΰ� ��ο�",10,10);}
		
		g.setColor(Color.blue);
		if (!blackjack.stop()) {
			if(blackjack.ComCard() != null) {
				g.drawString("��ǻ�� ī�� : "+blackjack.ComCard(),10,30);}
			else {g.drawString("��ǻ�� ��ο�",10,30);}
		}
		else {
			g.drawString("��ǻ�� ī�� : ���",10,30);}
		}
	}


