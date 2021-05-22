package card;

public class Dealer {
	
	
	private CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
		//������ ��ǻ��1
		//������ ��ǻ��2
	}
	
	void dealTo(CardPlayerBehavior p) {
		if (p.wantsACard()) {
			Card c = deck.newCard();
			p.receiveCard(c);
		}
		
		
	}
	
	public static void main(String[] args){
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(11);
		d.dealTo(p);
		Card[] h = p.showCards();
		for ( int i = 0; i<h.length;i++ ) {
			System.out.println(h[i].getSuit()+" "+h[i].getRank());
			
		}
	}
	 
}
