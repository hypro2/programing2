package card;

import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {
	
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		String response = JOptionPane.showInputDialog("���� �� �帱���? (Y/N)");
		boolean decision1 = response.equals("Y") || response.equals("y");
		
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i = 0; i < c.length; i++) {
			card_sum += c[i].getRank();
		}
		
		if(card_sum > 21) {
			System.out.println( card_sum + "burst");
			decision1 = false;}
		
		return decision1;

	}
}
