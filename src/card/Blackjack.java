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
	private ArrayList<String> hand;
	private ArrayList<String> chand;
	private CardDeck deck;
	private Card c;
	private boolean stophuman;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);
		
		//�����Ҷ� ī�� 1�常 ��
		d.dealTo2(p);
		//��ǻ�ʹ� �̸� ����
		d.dealTo(c);
		
		h = p.showCards();
		ch = c.showCards();
		
		ArrayList<String> hand = new ArrayList<String>();
		ArrayList<String> chand = new ArrayList<String>();
		
		//�ΰ� ī��
		h_count=1;
		h_sumcard=0;
		h_card="";
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			if (h[i].getRank()<10) {
				h_card += h[i].getSuit()+" 0"+h[i].getRank()+" ";
				hand.add(h[i].getSuit()+" 0"+h[i].getRank());
				}
			else {
				h_card += h[i].getSuit()+" "+h[i].getRank()+" ";
				hand.add(h[i].getSuit()+" "+h[i].getRank());
				}
			}
		
		//��ǻ�� ī��
		ch_count=ch.length;
		ch_sumcard = 0;
		ch_card=" ";
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();

			if(ch[j].getRank()<10) {
				ch_card = ch_card + ch[j].getSuit()+" 0"+ch[j].getRank()+"     ";
				chand.add(ch[j].getSuit()+" 0"+ch[j].getRank());
				}
			else {
				ch_card = ch_card + ch[j].getSuit()+" "+ch[j].getRank()+"     ";
				chand.add(ch[j].getSuit()+" "+ch[j].getRank());
				}
			}

		//����� �׸��Ѷ� �����,�����ӿ� Ȱ��
		stophuman = true;
		
		//������ ����
		//chand�� hand�� arraylist�� �Ϲ� �迭�� �ֱ����� for������ Ȱ���ؼ� ����� 
		//�����̺����� �����ؼ� �迭�� �ؿ� �Լ����� ���� �ְ� �Ѵ�. 
		// ��Ʈ���� �ٽ� �迭�� arraylist�� �迭�� ���� ����, �� ī�带 �߰��ϰ�
		//�ٽ� �迭�� ��ȯ�ؼ� �����ϰ� ����׿��� �޴´�.
		//����׿��� ���� �ȿ� ���ڸ� �ִ´�.
		}
	
	//�ΰ� ���� ���� ���徿 �̾Ƽ� �߰���
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
			
			h_count +=1;
		}		
	}
	
	//ī���� ����
	public ArrayList<String> hand() {
		return hand;
	}
	public ArrayList<String> chand() {
		return chand;
	}
		
	//�����ư�� ������ �����޸��� �޽�����
	public void stophuman() {
		stophuman = false;
	}
	
	//�����޸��� ���� ��������
	public boolean stop() {
		return stophuman;
	}
	
	public int h_count() {
		return h_count;
	}
	

	public int ch_count() {
		return ch_count;
	}
	
	// ī����, ī���� ����
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
	
	//���� ����
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "�ΰ� ��";	
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "�ΰ� ��";
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";
		}
		else{
			winner = "���";
		}
		return winner;
	}


}
