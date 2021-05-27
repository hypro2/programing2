package card;

public class Blackjack {
	 
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		
		
		ComputerPlayer c = new ComputerPlayer(card_num);
		System.out.println("----------사람----------");
		d.dealTo(p);
		System.out.println("---------컴퓨터----------");
		d.dealTo(c);
		System.out.println("----------결과----------");

		//카드 패 오픈
		Card[] h = p.showCards();
		Card[] ch = c.showCards();
		int h_sumcard = 0;
		int ch_sumcard = 0;
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();}
		System.out.println("사람 카드 합 : "+h_sumcard);
		
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();}
		System.out.println("컴퓨터 카드 합 : "+ch_sumcard);
		
		
		//승패 
		System.out.println("----------승/패----------");
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			System.out.println("인간 승");
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			System.out.println("컴퓨터 승");
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			System.out.println("컴퓨터의 burst!!!!");
			System.out.println("인간 승");
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			System.out.println("인간의 burst!!!!");
			System.out.println("컴퓨터 승");
		}
		else{
			System.out.println("비겼습니다.");
		}
		
	}
	


}
