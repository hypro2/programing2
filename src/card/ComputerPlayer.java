package card;

import javax.swing.JOptionPane;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		boolean decision = false;
		int r = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			r += c[i].getRank();
		}
		if (r <= 10) {
			decision = true;
		}
		return decision;

	}
}
