package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}
	int card_count = 0;	
	public boolean wantsACard() {
		boolean decision2 = false;
		card_count+=1;
		
//		int r = 0;
//		Card[] c = super.showCards();
//		for(int i =0; i < c.length; i++) {
//			r += c[i].getRank();
//			System.out.println(r+" "+i);
//		}
		
		if (card_count <= 10) {
			decision2 = true;
		}
		return decision2;

	}
}
