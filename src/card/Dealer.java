package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	private String card;
	
	public Dealer() {

	}
	//��ǻ�� ����
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			deck = new CardDeck();
			c = deck.newCard();
			p.receiveCard(c);
			card = (c.getSuit()+" "+c.getRank());
		}
	}
	
	//1ȸ��
	void dealTo2(CardPlayerBehavior p) {
		if(p.wantsACard()) {
		deck = new CardDeck();
		c = deck.newCard();
		p.receiveCard(c);
		card = (c.getSuit()+" "+c.getRank());
		}
	}
	}
