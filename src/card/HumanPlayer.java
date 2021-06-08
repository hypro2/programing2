package card;

//사용안함
public class HumanPlayer extends CardPlayer {
	
	public HumanPlayer(int max_cards) {
		super(max_cards);}
	
	public boolean wantsACard() {
		boolean decision1 = true;

		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i = 0; i < c.length; i++) {
			card_sum += c[i].getRank();}
		
		if(card_sum >= 21) {
			decision1 = false;}

		return decision1;

	}
}
