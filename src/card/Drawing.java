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
		HumanList = blackjack.HumanList();
		
		//�ΰ� ī��׸���	
		int x = 0;
		for (int i = 0; i <blackjack.humanCount() ; i++) {
			g.drawString(HumanList[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;}
		
		//�ΰ� ���� ����
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("�ΰ��� Bust!!!! ��ǻ���� �п� ������� �й��Դϴ�.",10,100);}
		
		//�ΰ� ���� �¸� ����
		else if(blackjack.HumanSumCard()==21){
			try {
				if((HumanList[0].charAt(2) == 'A'||
				    HumanList[0].charAt(2) == 'J'||
				    HumanList[0].charAt(2) == 'Q'||
				    HumanList[0].charAt(2) == 'K'||
				    HumanList[0].substring(2)=="10")&&
				   (HumanList[1].charAt(2) == 'A'||
				    HumanList[1].charAt(2) == 'J'||
				    HumanList[1].charAt(2) == 'Q'||
				    HumanList[1].charAt(2) == 'K'||
				    HumanList[1].substring(2)=="10")) {
					g.drawString("�ΰ��� ���� �¸�!!!!",10,100);}
				else {
					g.drawString("�ΰ��� 21 �¸�!!!!",10,100);}
			}
			catch(ArrayIndexOutOfBoundsException e){
				g.drawString("�ΰ��� 21 �¸�!!!!",10,100);}
		}
		
		//���� ���� �Ŀ��� �ΰ� ī���� ���
		else if(blackjack.HumanSumCard() != 0){
			g.drawString("�ΰ��� ī�� ���� "+blackjack.HumanSumCard()+"�Դϴ�.",10,100);}
		
		//���� �� �� ǥ��, ���� ���� ���ĵ� �Ҷ�
		if (blackjack.humanCount()==0 && blackjack.stop()) {
			g.drawString("���迡 ���Ű� ȯ���մϴ�.",10,50);
			g.drawString("[Hit!] �� ������ ������ ���� �˴ϴ�.",10,70);}
		else if(blackjack.humanCount()==0 && !blackjack.stop()){
			g.drawString("������ ��� �ϼ̽��ϴ�.",10,50);}
			
		
		//��ǻ�� ī��
		g.setColor(Color.blue);
		g.drawString("��ǻ�� ī��",10,120);
		ComList = blackjack.ComList();
		g.drawRect(0, 220, 500, 25);
		
		//�����ư�� ������ �����ǰ� �ص�
		if (!blackjack.stop()) {	
			
			//��ǻ�� ī�� �׸���
			int y = 0;
			for (int i = 0; i <blackjack.ComCount() ; i++) {
				g.drawString(ComList[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			//��ǻ�� ���� ����
			if (blackjack.ComSumCard() >21) {
				g.drawString("��ǻ���� Bust!!!!",10,210);}
			
			//��ǻ�� ���� �¸� ����
			else if(blackjack.ComSumCard()==21){
				try {
					if((ComList[0].charAt(2) == 'A'||
						ComList[0].charAt(2) == 'J'||
						ComList[0].charAt(2) == 'Q'||
						ComList[0].charAt(2) == 'K'||
						ComList[0].substring(2) =="10")&&
					   (ComList[1].charAt(2) == 'A'||
					    ComList[1].charAt(2) == 'J'||
					    ComList[1].charAt(2) == 'Q'||
						ComList[1].charAt(2) == 'K'||
						ComList[1].substring(2) =="10")) {
						g.drawString("��ǻ���� ���� �¸�!!!!",10,210);}
					else {
						g.drawString("��ǻ���� 21 �¸�!!!!",10,210);}
				}
				catch(ArrayIndexOutOfBoundsException e){
					g.drawString("��ǻ���� 21 �¸�!!!!",10,210);}
			}
			
			//��ǻ�� ī�� �� ���
			else {
				g.drawString("��ǻ���� ī�� ���� "+blackjack.ComSumCard()+"�Դϴ�.",10,210);}
			
			//���� ũ��, ���� ����
		    g.setFont(g.getFont().deriveFont(20.0f));
		    if (blackjack.winner()=="��ǻ��") {
		    	g.setColor(Color.blue);}
		    else if (blackjack.winner()=="�ΰ�") {
		    	g.setColor(Color.red);}
		    else {
		    	g.setColor(Color.orange);}
		    
		    //���� ���
	    	g.drawString("���� : "+ blackjack.winner(), 200, 240);}
		
		//�����ư ������ ������ ���
		else {
			g.drawString("�ΰ��� ���ʰ� �����⸦ ��ٸ��� �ֽ��ϴ�.../",10,160);}
		}
	}


