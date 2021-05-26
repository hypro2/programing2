package card;

import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {
	
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		String response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
		
		//리턴 decision1로 변경
		boolean decision1 = response.equals("Y") || response.equals("y");
		
		//카드 숫자 합
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i = 0; i < c.length; i++) {
			card_sum += c[i].getRank();}
		
		//21초과 버스트 출력하고 스탑
		if(card_sum >= 21) {
//			System.out.println( card_sum + " burst!!!!");
			decision1 = false;}
		
		return decision1;

	}
}
