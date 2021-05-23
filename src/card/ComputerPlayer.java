package card;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);}
	
	int card_count = 0;
	public boolean wantsACard() {
		boolean decision2 = false;
		
		//카드 갯수
		card_count+=1;
		if (card_count <= 10) {
			decision2 = true;
		}
		
		//카드 숫자 합
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i =0; i < c.length; i++) {
			card_sum += c[i].getRank();			
		}
		
		//카드 숫자 합이 16초과이면 스탑
		if(card_sum > 16) {
			decision2 = false;}
		
		//21초과 버스트 출력
		if(card_sum > 21) {
			System.out.println( card_sum + " burst!!!!");
		}
		
		return decision2;

	}
}
