package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	
	public Dealer() {
		deck = new CardDeck();
		 c = deck.newCard();
	}
	
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			p.receiveCard(c);
			//받은 카드 보이기
			System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}
	}
	
	void dealTo2(CardPlayerBehavior p) {
		if(p.wantsACard()) {
		p.receiveCard(c);
		System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}
	}
	}
