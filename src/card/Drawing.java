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
		
		//배경색
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 400);
		
		//인간 카드
		g.setColor(Color.red);
		g.drawString("인간 카드",10,10);
		
		//인간 카드그리기	
		int x = 0;
		HumanList = blackjack.HumanList();
		for (int i = 0; i <blackjack.humanCount() ; i++) {
			g.drawString(HumanList[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;}
		
		//인간 폭사 & 블랙잭
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("인간의 Burst!!!!",10,100);}
		else if(blackjack.HumanSumCard()==21){
			g.drawString("인간의 블랙잭!!!!",10,100);}
		
		//시작 할 때 표시
		if (blackjack.humanCount()==0) {
			g.drawString("블랙잭에 오신걸 환영합니다.",10,50);
			g.drawString("[Hit!] 를 누르면 게임이 시작 됩니다.",10,70);}
			
		
		//컴퓨터 카드그리기
		g.setColor(Color.blue);
		g.drawString("컴퓨터 카드",10,120);
		ComList = blackjack.ComList();
		
		//스톱버튼을 누르면 공개되게 해둠
		if (!blackjack.stop()) {	
			int y = 0;
			for (int i = 0; i <blackjack.ComCount() ; i++) {
				g.drawString(ComList[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			//컴퓨터 폭사 & 블랙잭
			if (blackjack.ComSumCard() >21) {
				g.drawString("컴퓨터의 Burst!!!!",10,210);}
			else if (blackjack.ComSumCard() == 21) {
				g.drawString("컴퓨터의 블랙잭!!!!",10,210);}
			
			//승자 폰트 설정 및 출력
			Font font = g.getFont().deriveFont( 20.0f );
		    g.setFont( font );
		    if (blackjack.winner()=="컴퓨터 승") {
		    	g.setColor(Color.blue);}
		    else if (blackjack.winner()=="인간 승") {
		    	g.setColor(Color.red);}
		    else {
		    	g.setColor(Color.orange);}
	    	g.drawString("승자 : "+ blackjack.winner(), 150, 240); }
		
		//스톱버튼 누르기 전까지 비밀
		else {
			g.drawString("인간의 차례가 끝나기를 기다리고 있습니다.../",10,160);
			}
		}
	}


