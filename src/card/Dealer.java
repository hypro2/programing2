package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	
	public Dealer() {

	}
	//��ǻ�� ����
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			deck = new CardDeck();
			c = deck.newCard();
			p.receiveCard(c);
		}
	}
}
