package card;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Blackjack {
	
	private CardDeck deck;
	private Card c;
	private int h_sumcard;
	private int ch_sumcard;
	private int h_count;
	private int ch_count;
	private String winner;
	private Card[] h;
	private Card[] ch;
	private String[] list_hand = new String[11];
	private String[] list_chand= new String[11];
	private boolean stophuman;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);
		
		//인간은 카드 1장
		//컴퓨터는 미리 실행
		d.dealTo2(p);
		d.dealTo(c);
		
		//시작할때 패
		h = p.showCards();
		ch = c.showCards();

		//인간 카드를 문자로바꾸고 리스트에 저장
		h_count=1;
		h_sumcard=0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			list_hand[i] = h[i].getSuit()+" "+h[i].getRank();
			}
		
		//컴퓨터 카드를 문자로 바꾸고 리스트에 저장
		ch_count=ch.length;
		ch_sumcard = 0;
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			list_chand[j] = ch[j].getSuit()+" "+ch[j].getRank();
				}
	
		//사람이 그만둘때 컴퓨터터 카드를 보이게 하기위해 드로잉,프레임에 활용
		stophuman = true;	
		}

	
	//인간 딜러 역할 한장씩 뽑아서 추가함(버튼에서 활용)
	//매번 새 카드덱에서 뽑아서 중복이 걸릴수 있음!!!
	public void hit(){
		deck = new CardDeck();
		c = deck.newCard(); 		
		if (h_sumcard<21 & stophuman) {
			h_sumcard = h_sumcard + c.getRank();		
			list_hand[h_count()]=c.getSuit()+" "+c.getRank();
			h_count +=1;}		
		}
	
	//카드패 리턴
	public String[] list_hand() {
		return list_hand;}
	public String[] list_chand() {
		return list_chand;}
		
	//스톱버튼을 누르면 스톱휴먼이 펄스가됨(버튼에서 활용)
	//스톱휴먼의 값을 리턴해줌
	public void stophuman() {
		stophuman = false;}
	public boolean stop() {
		return stophuman;}
	
	//카드 매수 리턴
	public int h_count() {
		return h_count;}
	public int ch_count() {
		return ch_count;}
	
	//카드합 리턴
	public int HumanSumCard() {
		return h_sumcard;}
	public int ComSumCard() {
		return ch_sumcard;}
	
	//승자 리턴
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "인간 승";}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "인간 승";}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";}
		else{
			winner = "비김";}
		return winner;
	}


}
