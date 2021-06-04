package card;

import java.awt.*;
import java.awt.*;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.*;

public class Drawing extends JPanel {
	
	private Blackjack blackjack;
	private String[] list_hand = new String[11];
	private String[] list_chand = new String[11];
	
	public Drawing(Blackjack b) {
		blackjack = b;
		setSize(200,200);
	}
	
	public void paintComponent(Graphics g) {
		
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 400);
		
		g.setColor(Color.red);
		g.drawString("인간 카드",10,10);		
		
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("인간의 Burst!!!!",10,100);}
			
		int x = 0;
		list_hand = blackjack.list_hand();
		for (int i = 0; i <blackjack.h_count() ; i++) {
			g.drawString(list_hand[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;
			}
		
		g.setColor(Color.blue);
		g.drawString("컴퓨터 카드",10,120);
		list_chand = blackjack.list_chand();
		if (!blackjack.stop()) {	
			int y = 0;
			for (int i = 0; i <blackjack.ch_count() ; i++) {
				g.drawString(list_chand[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			
			if ( blackjack.ComSumCard() >21) {
				g.drawString("컴퓨터의 Burst!!!!",10,210);
				}
			
			Font font = g.getFont().deriveFont( 20.0f );
		    g.setFont( font );
		    if (blackjack.winner()=="컴퓨터 승") {
		    	g.setColor(Color.blue);
		    	}
		    else if (blackjack.winner()=="인간 승") {
		    	g.setColor(Color.red);
		    	}
		    else {
		    	g.setColor(Color.orange);
		    	}
	    	g.drawString("승자 : "+ blackjack.winner(), 150, 240); 
				}
		else {
			g.drawString("비밀",10,160);
			}
		}
	}


