package card;

public class Blackjack {
	 
	private int h_sumcard;
	private int ch_sumcard;
	private String h_card;
	private String ch_card;
	private String winner;
	private Card[] h;
	private Card[] ch;
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
		
		//�ΰ� ī�� 
		h_sumcard=0;
		h_card="";
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			h_card += h[i].getSuit()+" "+h[i].getRank()+" ";
			}
		
		//��ǻ�� ī��
		ch_sumcard = 0;
		ch_card="";
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			ch_card = ch_card + ch[j].getSuit()+" "+ch[j].getRank()+" ";
			}
		
		//����� �׸��Ѷ� �����,�����ӿ� Ȱ��
		stophuman = true;
		}
	
	//�ΰ� ���� ���� ���徿 �̾Ƽ� �߰���
	public void hit(){
		deck = new CardDeck();
		c = deck.newCard(); 
		if (h_sumcard<21 & stophuman) {
			h_sumcard = h_sumcard + c.getRank();
			h_card =h_card+" "+c.getSuit()+" "+c.getRank();
		}		
	}
	
	//�����ư�� ������ �����޸��� �޽�����
	public void stophuman() {
		stophuman = false;
	}
	
	//�����޸��� ���� ��������
	public boolean stop() {
		return stophuman;
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
