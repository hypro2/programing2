package card;

import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {
	
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		//리턴 decision1로 변경
		String response = "Y";
		boolean decision1 = true;
		
		//카드 숫자 합
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i = 0; i < c.length; i++) {
			card_sum += c[i].getRank();}
		
		//첫번째 카드는 필수
		if (card_sum == 0) {
			decision1 = true;}
		//21초과 버스트 출력하고 스탑
		else if(card_sum >= 21) {
			decision1 = false;}
		else
			response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
			decision1 = response.equals("Y") || response.equals("y");

		return decision1;

	}
}
