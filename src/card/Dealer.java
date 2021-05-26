package card;

public class Dealer {
	
	
	private CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
	}
	
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			Card c = deck.newCard();
			p.receiveCard(c);
			//���� ī�� ���̱�
			System.out.println("���� ī�� : "+c.getSuit()+" "+c.getRank());
		}	
	}

	//���� �׽�Ʈ
	public static void main(String[] args){
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(11);
		ComputerPlayer c = new ComputerPlayer(11);
		System.out.println("----------���----------");
		d.dealTo(p);
		System.out.println("---------��ǻ��----------");
		d.dealTo(c);
		System.out.println("----------���----------");
	
		//ī�� �� ����
		Card[] h = p.showCards();
		Card[] ch = c.showCards();
		int h_sumcard = 0;
		int ch_sumcard = 0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();}
		System.out.println("��� ī�� �� : "+h_sumcard);
		
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();}
		System.out.println("��ǻ�� ī�� �� : "+ch_sumcard);
		
		
		//���� 
		System.out.println("----------��/��----------");
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			System.out.println("�ΰ� ��");
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			System.out.println("��ǻ�� ��");
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			System.out.println("��ǻ���� burst!!!!");
			System.out.println("�ΰ� ��");
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			System.out.println("�ΰ��� burst!!!!");
			System.out.println("��ǻ�� ��");
		}
		else{
			System.out.println("�����ϴ�.");
		}
	}
	 
}
