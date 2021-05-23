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
		}	
	}

	//테스트
	public static void main(String[] args){
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(11);
		ComputerPlayer c = new ComputerPlayer(11);
		d.dealTo(p);
		d.dealTo(c);
		Card[] h = p.showCards();
		Card[] ch = c.showCards();
		
		for (int i = 0; i<h.length;i++ ) {
			System.out.println("사람 "+(i+1)+"번째 카드 "+h[i].getSuit()+" "+h[i].getRank());
			}	
		for (int j = 0; j<ch.length;j++ ) {
			System.out.println("컴퓨터 "+(j+1)+"번째 카드 "+ch[j].getSuit()+" "+ch[j].getRank());	
			}	
		
	}
	 
}
