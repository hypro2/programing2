package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	
	public Dealer() {

	}
	//컴퓨터 전용
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			deck = new CardDeck();
			c = deck.newCard();
			p.receiveCard(c);
		}
	}
}
