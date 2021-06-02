package card;

public class Dealer {
	
	
	private CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
	}
	
	void dealTo(CardPlayerBehavior p) {
		Card c = deck.newCard();
		while(p.wantsACard()) {
			p.receiveCard(c);
			//받은 카드 보이기
			System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}
	}
	
	void dealTo2(CardPlayerBehavior p) {
		Card c = deck.newCard();
		p.receiveCard(c);
		System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}
	}

