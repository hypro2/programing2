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

	 
}
