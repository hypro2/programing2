package card;

import java.awt.*;
import java.awt.*;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.*;

public class Drawing extends JPanel {
	
	private Blackjack blackjack;
	private String[] HumanList = new String[11];
	private String[] ComList = new String[11];
	
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
		
		//�ΰ� ī��׸���	
		int x = 0;
		HumanList = blackjack.HumanList();
		for (int i = 0; i <blackjack.humanCount() ; i++) {
			g.drawString(HumanList[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;}
		
		//�ΰ� ���� & ����
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("�ΰ��� Burst!!!!",10,100);}
		else if(blackjack.HumanSumCard()==21){
			g.drawString("�ΰ��� ����!!!!",10,100);}
		
		//���� �� �� ǥ��
		if (blackjack.humanCount()==0) {
			g.drawString("���迡 ���Ű� ȯ���մϴ�.",10,50);
			g.drawString("[Hit!] �� ������ ������ ���� �˴ϴ�.",10,70);}
			
		
		//��ǻ�� ī��׸���
		g.setColor(Color.blue);
		g.drawString("��ǻ�� ī��",10,120);
		ComList = blackjack.ComList();
		
		//�����ư�� ������ �����ǰ� �ص�
		if (!blackjack.stop()) {	
			int y = 0;
			for (int i = 0; i <blackjack.ComCount() ; i++) {
				g.drawString(ComList[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			//��ǻ�� ���� & ����
			if (blackjack.ComSumCard() >21) {
				g.drawString("��ǻ���� Burst!!!!",10,210);}
			else if (blackjack.ComSumCard() == 21) {
				g.drawString("��ǻ���� ����!!!!",10,210);}
			
			//���� ��Ʈ ���� �� ���
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
			g.drawString("�ΰ��� ���ʰ� �����⸦ ��ٸ��� �ֽ��ϴ�.../",10,160);
			}
		}
	}


