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
		
		//����
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 400);
		
		//�ΰ� ī��
		g.setColor(Color.red);
		g.drawString("�ΰ� ī��",10,10);		
		//���� ����
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("�ΰ��� Burst!!!!",10,100);}
		else if(blackjack.HumanSumCard()==21){
			g.drawString("�ΰ��� ����!!!!",10,100);}
		
		//���� �� �� ǥ��
		if (blackjack.h_count()==0) {
			g.drawString("Start!!",10,50);}
		
		//�ΰ� ī��׸���	
		int x = 0;
		list_hand = blackjack.list_hand();
		for (int i = 0; i <blackjack.h_count() ; i++) {
			g.drawString(list_hand[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;
			}
		
		//��ǻ�� ī��׸���
		g.setColor(Color.blue);
		g.drawString("��ǻ�� ī��",10,120);
		list_chand = blackjack.list_chand();
		
		//�����ư�� ������ �����ǰ� �ص�
		if (!blackjack.stop()) {	
			int y = 0;
			for (int i = 0; i <blackjack.ch_count() ; i++) {
				g.drawString(list_chand[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			//��ǻ�� ���� ����
			if (blackjack.ComSumCard() >21) {
				g.drawString("��ǻ���� Burst!!!!",10,210);}
			else if (blackjack.ComSumCard() == 21) {
				g.drawString("��ǻ���� ����!!!!",10,210);}
			
			//���� ��Ʈ
			Font font = g.getFont().deriveFont( 20.0f );
		    g.setFont( font );
		    if (blackjack.winner()=="��ǻ�� ��") {
		    	g.setColor(Color.blue);}
		    else if (blackjack.winner()=="�ΰ� ��") {
		    	g.setColor(Color.red);}
		    else {
		    	g.setColor(Color.orange);}
	    	g.drawString("���� : "+ blackjack.winner(), 150, 240); }
		
		//�����ư ������ ������ ���
		else {
			g.drawString("���",10,160);
			}
		}
	}


