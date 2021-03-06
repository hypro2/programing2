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
	private int HumanWinCount = 0;
	private int ComWinCount = 0;
	private int GameCount = 0;
	
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
		HumanList = blackjack.HumanList();
		g.drawString("인간 승리 :"+HumanWinCount+"회", 150, 10);

		//인간 카드그리기	
		int x = 0;
		for (int i = 0; i <blackjack.humanCount() ; i++) {
			g.drawString(HumanList[i], x*43+10,50);
			g.drawRect(x*43+3, 15, 41, 70);
			x+=1;}
		
		//인간 폭사 조건
		if ( blackjack.HumanSumCard() >21) {
			g.drawString("인간의 Bust!!!! 컴퓨터의 패와 상관없이 패배입니다.",10,100);}
		
		//인간 블랙잭 승리 조건
		else if(blackjack.HumanSumCard()==21){
			try {
				if((HumanList[0].charAt(2) == 'A'||
				    HumanList[0].charAt(2) == 'J'||
				    HumanList[0].charAt(2) == 'Q'||
				    HumanList[0].charAt(2) == 'K'||
				    Integer.parseInt(HumanList[0].substring(2))==10)&&
				   (HumanList[1].charAt(2) == 'A'||
				    HumanList[1].charAt(2) == 'J'||
				    HumanList[1].charAt(2) == 'Q'||
				    HumanList[1].charAt(2) == 'K'||
				    Integer.parseInt(HumanList[1].substring(2))==10)) {
					g.drawString("인간의 블랙잭 승리!!!!",10,100);}
				else {
					g.drawString("인간의 21 승리!!!!",10,100);}
			}
			catch(ArrayIndexOutOfBoundsException e){
				g.drawString("인간의 21 승리!!!!",10,100);}
		}
		
		//게임 시작 후에는 인간 카드합 출력
		else if(blackjack.HumanSumCard() != 0){
			g.drawString("인간의 카드 합은 "+blackjack.HumanSumCard()+"입니다.",10,100);}
		
		//시작 할 때 표시, 시작 전에 스탠드 할때
		if (blackjack.humanCount()==0 && blackjack.stop()) {
			g.drawString("블랙잭에 오신걸 환영합니다.",10,50);
			g.drawString("[Start] 를 누르면 게임이 시작 됩니다.",10,70);}
		else if(blackjack.humanCount()==0 && !blackjack.stop()){
			g.drawString("게임을 기권 하셨습니다.",10,50);}
			
		
		//컴퓨터 카드
		g.setColor(Color.blue);
		g.drawString("컴퓨터 카드",10,120);
		ComList = blackjack.ComList();
		g.drawString("컴퓨터 승리 :"+ComWinCount+"회", 150, 120);
		g.drawRect(0, 220, 500, 25);
		
		if(blackjack.HumanStart()) {
			g.drawString(ComList[0], 11, 160);
			g.drawRect(3, 125, 41, 70);}
		else if (blackjack.stop()) {
			g.drawString("인간의 시작을 기다리고 있습니다.../",10,160);}
		
		//스톱버튼을 누르면 공개되게 해둠
		if (!blackjack.stop()&&blackjack.HumanSumCard()>0) {	
			
			//컴퓨터 카드 그리기
			int y = 1;
			for (int i = 1; i <blackjack.ComCount() ; i++) {
				g.drawString(ComList[i], y*43+11, 160);
				g.drawRect(y*43+3, 125, 41, 70);
				y+=1;
				}
			//컴퓨터 폭사 조건
			if (blackjack.ComSumCard() >21) {
				g.drawString("컴퓨터의 Bust!!!!",10,210);}
			
			//컴퓨터 블랙잭 승리 조건
			else if(blackjack.ComSumCard()==21){
				try {
					if((ComList[0].charAt(2) == 'A'||
						ComList[0].charAt(2) == 'J'||
						ComList[0].charAt(2) == 'Q'||
						ComList[0].charAt(2) == 'K'||
						Integer.parseInt(ComList[0].substring(2))==10)&&
					   (ComList[1].charAt(2) == 'A'||
					    ComList[1].charAt(2) == 'J'||
					    ComList[1].charAt(2) == 'Q'||
						ComList[1].charAt(2) == 'K'||
						Integer.parseInt(ComList[1].substring(2))==10)) {
						g.drawString("컴퓨터의 블랙잭 승리!!!!",10,210);}
					else {
						g.drawString("컴퓨터의 21 승리!!!!",10,210);}
				}
				catch(ArrayIndexOutOfBoundsException e){
					g.drawString("컴퓨터의 21 승리!!!!",10,210);}
			}
			
			//컴퓨터 카드 합 출력
			else {
				g.drawString("컴퓨터의 카드 합은 "+blackjack.ComSumCard()+"입니다.",10,210);}
			
			//승자 크기, 색상 설정
		    g.setFont(g.getFont().deriveFont(20.0f));
		    if (blackjack.winner()=="컴퓨터") {
		    	g.setColor(Color.blue);
		    	ComWinCount=ComWinCount+1;
		    	GameCount = GameCount + 1;}
		    else if (blackjack.winner()=="인간") {
		    	g.setColor(Color.red);
		    	HumanWinCount=HumanWinCount+1;
		    	GameCount = GameCount + 1;}
		    else {
		    	g.setColor(Color.orange);
		    	GameCount = GameCount + 1;}
		    
		    //승자 출력
	    	g.drawString(GameCount + "번째 게임의 승자 : "+ blackjack.winner(), 10, 240);}
		
		//스톱버튼 누르기 전까지 비밀
		else {
			if(blackjack.HumanStart()) {
			g.drawString("인간의 차례가 끝나기를 기다리고 있습니다.../",50,160);}
			g.setFont(g.getFont().deriveFont(20.0f));
			g.setColor(Color.blue);
			if(GameCount==0) {
				g.drawString("1번째 게임", 10, 240);}
			else {
				g.drawString(GameCount+1+"번째 게임", 10, 240);}
			}
		}
	}


