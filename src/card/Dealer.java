package card;

public class Dealer {
	
	
	private CardDeck deck;
	private Card c;
	
	public Dealer() {

	}
	
	void dealTo(CardPlayerBehavior p) {
		while(p.wantsACard()) {
			deck = new CardDeck();
			c = deck.newCard();
			p.receiveCard(c);
			//���� ī�� ���̱�
			System.out.println("���� ī�� : "+c.getSuit()+" "+c.getRank());
		}
	}
	
	void dealTo2(CardPlayerBehavior p) {
		if(p.wantsACard()) {
		p.receiveCard(c);
		System.out.println("���� ī�� : "+c.getSuit()+" "+c.getRank());
		}
	}
	}
