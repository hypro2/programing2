package card;

import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {
	
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}
	public boolean wantsACard() {
		//���� decision1�� ����
		String response = JOptionPane.showInputDialog("���� �� �帱���? (Y/N)");
		boolean decision1 = true;
		
		//ī�� ���� ��
		int card_sum = 0;
		Card[] c = super.showCards();
		for(int i = 0; i < c.length; i++) {
			card_sum += c[i].getRank();}
		
		//�ι�° ī��� �ʼ�
		if (c.length <=1) {
			decision1 = true;}
		
		//21�ʰ� ����Ʈ ����ϰ� ��ž
		else if(card_sum >= 21) {
			decision1 = false;}
		else
			decision1 = response.equals("Y") || response.equals("y");

		return decision1;

	}
}
