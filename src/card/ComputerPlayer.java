package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		boolean decision2 = false;
		int card_count = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			
//			card_count += c[i].getRank();
//			System.out.println(card_count+" "+i);
			
			card_count+=1;
		}
		
		if (card_count <= 10) {
			decision2 = true;
		}
		return decision2;

	}
}
