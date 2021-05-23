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
			System.out.println("받은 카드 : "+c.getSuit()+" "+c.getRank());
		}	
	}

	//테스트
	public static void main(String[] args){
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(11);
		ComputerPlayer c = new ComputerPlayer(11);
		
		System.out.println("----------사람----------");
		d.dealTo(p);
		System.out.println("---------컴퓨터----------");
		d.dealTo(c);
		System.out.println("----------결과----------");
	
		//카드 패 오픈
		Card[] h = p.showCards();
		Card[] ch = c.showCards();
		int h_sumcard = 0;
		int ch_sumcard = 0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			}
		System.out.println("사람 카드 합 : "+h_sumcard);
		
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			}
		System.out.println("컴퓨터 카드 합 : "+ch_sumcard);
		
		
		//승패 만들기
		System.out.println("----------승/패----------");

	}
	 
}
