package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}
	int r = 0;	
	public boolean wantsACard() {
		boolean decision2 = false;
		r+=1;
		
//		Card[] c = super.showCards();
//		for(int i =0; i < c.length; i++) {
//			r += c[i].getRank();
//			System.out.println(r+" "+i);
//		}
		
		if (r <= 10) {
			decision2 = true;
		}
		return decision2;

	}
}
