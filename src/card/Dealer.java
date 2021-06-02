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
			//���� ī�� ���̱�
			System.out.println("���� ī�� : "+c.getSuit()+" "+c.getRank());
		}
	}
	
	void dealTo2(CardPlayerBehavior p) {
		Card c = deck.newCard();
		p.receiveCard(c);
		System.out.println("���� ī�� : "+c.getSuit()+" "+c.getRank());
		}
	}

