package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);}
	

	public boolean wantsACard() {
		boolean decision2 = true;
		
		//ī�� ���� ��
		int comAce =0;
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			card_sum += c[i].getRank();	
			if(c[i].getRank() ==1) {
				comAce = 1;}
		}
		
		//Ace�� 1 �Ǵ� 11
		boolean boolComAce = false;
		if (card_sum <= 11 & comAce > 0) {
			card_sum = card_sum + 10;
			boolComAce = true;}
		
		if (card_sum > 21 & comAce > 0 & boolComAce) {
			card_sum = card_sum -10;
			boolComAce = false;
			comAce = 0;}
		
		
		//ī�� ���� ���� 16�ʰ��̸� ��ž
		if(card_sum > 16) {
			decision2 = false;}
		
		return decision2;

	}
}
