package card;

public class CardDeck {
	
	private int card_count; // ī�� ���� �����ִ� ī�� ��� 
	private Card[] deck = new Card[4 * Card.SIZE_OF_ONE_SUIT];
	// Invariant: deck[0], .., decl[card_count-1] �� ī�尡 �ִ�. 
	
	/** Constructor - CardDeck ī�� �� �� ����  */ 
	public CardDeck() { 
		createDeck();
	}
	
	/** createSuit - �־��� ���̷� ī�� 13�� ����  */ 
	private void createSuit(String which_suit) {
		for(int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i++) {
			deck[card_count] = new Card(which_suit, i); 
			card_count = card_count + 1;
		} 
	}
	
	private void createDeck() {
		createSuit(Card.SPADES);
		createSuit(Card.HEARTS); 
		createSuit(Card.CLUBS); 
		createSuit(Card.DIAMONDS);
	}
	
	/** newCard - ������ �� ī�� �� ���� �̾� ��
	* @return ī�� ������ ���Ƿ� �� ���� �̾� ���� 
	*         ������ ī�� 1���� ���� ����� �� ���� �̾� ����   */
	public Card newCard() { 
		if (! this.moreCards()) 
			createDeck();
		int index = (int)(Math.random() * card_count);
		Card card_to_deal = deck[index];
		for (int i = index+1; i < card_count; i++)
			deck[i-1] = deck[i];
		card_count = card_count - 1;
		return card_to_deal;
	}
	
	/** moreCards - ī�� ���� ī�尡 �����ִ��� �˷���  
	 * @return ������ true, ������ false */
	public boolean moreCards() { 
		return card_count > 0; 
	}
	
//	public static void main(String[] args) {
//		CardDeck deck = new CardDeck();
//		for (int i = 0; i < 5; i++) {
//			Card card = deck.newCard();
//			System.out.println(card.getSuit() + " " + card.getRank());
//		}
//	}

}
