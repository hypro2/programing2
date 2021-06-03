package card;

public class Blackjack {
	 
	private int h_sumcard;
	private int ch_sumcard;
	private String h_card="";
	private String ch_card="";
	private String winner;
	private Card[] h;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);

		d.dealTo(p);
		d.dealTo(c);

		//Ä«µå ÆÐ ¿ÀÇÂ
		h = p.showCards();
		Card[] ch = c.showCards();
		
		h_sumcard = 0;
		ch_sumcard = 0;
		

		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			ch_card = ch_card + ch[j].getSuit()+" "+ch[j].getRank()+" ";
			}
	}
	
	public int getHumanSum() {
		
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			h_card = h_card + h[i].getSuit()+" "+h[i].getRank()+" ";
			}
		
		
		return h_sumcard;
	}
	public int getComSum() {
		return ch_sumcard;
	}
	public String winner() {
		
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
		return winner;
	}
	public String HumanCard() {
		return h_card;
	}
	public String ComCard() {
		return ch_card;
	}

}
