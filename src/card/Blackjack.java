package card;

public class Blackjack {
	 
	private int h_sumcard;
	private int ch_sumcard;
	String winner;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);
		System.out.println("----------»ç¶÷----------");
		d.dealTo(p);
		System.out.println("---------ÄÄÇ»ÅÍ----------");
		d.dealTo(c);

		//Ä«µå ÆÐ ¿ÀÇÂ
		Card[] h = p.showCards();
		Card[] ch = c.showCards();
		h_sumcard = 0;
		ch_sumcard = 0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();}
		
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();}
				
		//½ÂÆÐ 
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "ÀÎ°£ ½Â";	
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "ÄÄÇ»ÅÍ ½Â";
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "ÀÎ°£ ½Â";
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "ÄÄÇ»ÅÍ ½Â";
		}
		else{
			winner = "ºñ±è";
		}
	}
	
	public int get_Human_sum() {
		return h_sumcard;
	}
	public int get_Com_sum() {
		return ch_sumcard;
	}
	public String winner() {
		return winner;
	}


}
