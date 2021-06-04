package card;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Blackjack {
	 
	private int h_sumcard;
	private int ch_sumcard;
	private int h_count;
	private int ch_count;
	private String h_card;
	private String ch_card;
	private String winner;
	private Card[] h;
	private Card[] ch;
	private String[] list_hand = new String[11];
	private String[] list_chand= new String[11];
	private CardDeck deck;
	private Card c;
	private boolean stophuman;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);
		
		//시작할때 카드 1장만 줌
		d.dealTo2(p);
		//컴퓨터는 미리 실행
		d.dealTo(c);
		
		h = p.showCards();
		ch = c.showCards();

		//인간 카드
		h_count=1;
		h_sumcard=0;
		h_card="";
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			if (h[i].getRank()<10) {
				h_card += h[i].getSuit()+" 0"+h[i].getRank()+" ";
				list_hand[i] = h[i].getSuit()+" 0"+h[i].getRank();
				}
			else {
				h_card += h[i].getSuit()+" "+h[i].getRank()+" ";
				list_hand[i] = h[i].getSuit()+" "+h[i].getRank();
				}
			}
		
		//컴퓨터 카드
		ch_count=ch.length;
		ch_sumcard = 0;
		ch_card=" ";
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();

			if(ch[j].getRank()<10) {
				ch_card = ch_card + ch[j].getSuit()+" 0"+ch[j].getRank()+"     ";

				}
			else {
				ch_card = ch_card + ch[j].getSuit()+" "+ch[j].getRank()+"     ";
				
				}
			}
		//사람이 그만둘때 드로잉,프레임에 활용
		stophuman = true;	
	}
	
	//인간 딜러 역할 한장씩 뽑아서 추가함
	public void hit(){
		deck = new CardDeck();
		c = deck.newCard(); 		
		if (h_sumcard<21 & stophuman) {
			h_sumcard = h_sumcard + c.getRank();
			if(c.getRank()<10) {
				h_card = h_card+"     "+c.getSuit()+" 0"+c.getRank();
				}
			else {
				h_card = h_card+"     "+c.getSuit()+" "+c.getRank();		
				}
			
			list_hand[h_count()+1]=c.getSuit()+" "+c.getRank();
			for (int i =0; i<=h_count()+1;i++) {
			System.out.print(list_hand[i]+","+i+"/");}
			h_count +=1;
		}		
	}
	
	//카드패 리턴
	public String[] list_hand() {
		return list_hand;
	}
	public String[] list_chand() {
		return list_chand;
	}
		
	//스톱버튼을 누르면 스톱휴먼이 펄스가됨
	public void stophuman() {
		stophuman = false;
	}
	
	//스톱휴먼의 값을 리턴해줌
	public boolean stop() {
		return stophuman;
	}
	
	public int h_count() {
		return h_count;
	}
	
	public int ch_count() {
		return ch_count;
	}
	
	// 카드패, 카드합 리턴
	public String HumanCard() {
		return h_card;
	}
	public String ComCard() {
		return ch_card;
	}
	public int HumanSumCard() {
		return h_sumcard;
	}
	public int ComSumCard() {
		return ch_sumcard;
	}
	
	//승자 리턴
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "인간 승";	
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "인간 승";
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";
		}
		else{
			winner = "비김";
		}
		return winner;
	}


}
