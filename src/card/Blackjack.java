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
		
		//�ΰ��� ī�� 1��
		//��ǻ�ʹ� �̸� ����
		d.dealTo2(p);
		d.dealTo(c);
		
		//�����Ҷ� ��
		h = p.showCards();
		ch = c.showCards();

		//�ΰ� ī�带 ���ڷιٲٰ� ����Ʈ�� ����
		h_count=1;
		h_sumcard=0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			list_hand[i] = h[i].getSuit()+" "+h[i].getRank();
			}
		
		//��ǻ�� ī�带 ���ڷ� �ٲٰ� ����Ʈ�� ����
		ch_count=ch.length;
		ch_sumcard = 0;
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			list_chand[j] = ch[j].getSuit()+" "+ch[j].getRank();
				}
	
		//����� �׸��Ѷ� ��ǻ���� ī�带 ���̰� �ϱ����� �����,�����ӿ� Ȱ��
		stophuman = true;	
		}

	
	//�ΰ� ���� ���� ���徿 �̾Ƽ� �߰���(��ư���� Ȱ��)
	//�Ź� �� ī�嵦���� �̾Ƽ� �ߺ��� �ɸ��� ����!!!
	public void hit(){
		deck = new CardDeck();
		c = deck.newCard(); 		
		if (h_sumcard<21 & stophuman) {
			h_sumcard = h_sumcard + c.getRank();		
			list_hand[h_count()]=c.getSuit()+" "+c.getRank();
			h_count +=1;}		
		}
	
	//ī���� ����
	public String[] list_hand() {
		return list_hand;}
	public String[] list_chand() {
		return list_chand;}
		
	//�����ư�� ������ �����޸��� �޽�����(��ư���� Ȱ��)
	//�����޸��� ���� ��������
	public void stophuman() {
		stophuman = false;}
	public boolean stop() {
		return stophuman;}
	
	//ī�� �ż� ����
	public int h_count() {
		return h_count;}
	public int ch_count() {
		return ch_count;}
	
	//ī���� ����
	public int HumanSumCard() {
		return h_sumcard;}
	public int ComSumCard() {
		return ch_sumcard;}
	
	//���� ����
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "�ΰ� ��";}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "�ΰ� ��";}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";}
		else{
			winner = "���";}
		return winner;
	}


}
