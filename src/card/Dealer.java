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
			//받은 카드 보이기
			System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}
	}

	 
}
