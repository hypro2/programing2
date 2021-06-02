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
		g.drawString("�ΰ��� ī��� : "+blackjack.HumanCard(),10,10);
		g.setColor(Color.blue);
		g.drawString("��ǻ���� ī�� : "+blackjack.ComCard(),10,30);
		}
	}

