package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);}
	
	int card_count = 0;
	public boolean wantsACard() {
		boolean decision2 = false;
		
		//ī�� ����
		card_count+=1;
		if (card_count <= 10) {
			decision2 = true;
		}
		
		//ī�� ���� ��
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			card_sum += c[i].getRank();			
		}
		
		//ī�� ���� ���� 16�ʰ��̸� ��ž
		if(card_sum > 16) {
			decision2 = false;}
		
		//21�ʰ� ����Ʈ ���
		if(card_sum > 21) {
			System.out.println( card_sum + " burst!!!!");
		}
		
		return decision2;

	}
}
