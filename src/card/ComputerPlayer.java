package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);}
	

	public boolean wantsACard() {
		boolean decision2 = true;
		
		//ī�� ���� ��
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			card_sum += c[i].getRank();			
		}
		
		//ī�� ���� ���� 16�ʰ��̸� ��ž
		if(card_sum > 16) {
			decision2 = false;}
		
		return decision2;

	}
}
