package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	private String card;
	
	public Dealer() {

	}
	//컴퓨터 전용
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			deck = new CardDeck();
			c = deck.newCard();
			p.receiveCard(c);
			card = (c.getSuit()+" "+c.getRank());
		}
	}
	
	//1회용
	void dealTo2(CardPlayerBehavior p) {
		if(p.wantsACard()) {
		deck = new CardDeck();
		c = deck.newCard();
		p.receiveCard(c);
		card = (c.getSuit()+" "+c.getRank());
		}
	}
	}
