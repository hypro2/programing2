package card;

public class Dealer {
	
	
	private CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
		//김형준 컴퓨터1 알았다
		//김형준 컴퓨터2 10:45분 수정
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
