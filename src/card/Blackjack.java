package card;

public class Blackjack {
	 
	private int h_sumcard;
	private int ch_sumcard;
	private String h_card;
	private String ch_card;
	private String winner;
	private Card[] h;
	private Card[] ch;
	private CardDeck deck;
	private Card c;
	private boolean stophuman;
	
	public Blackjack(int card_num) {
		 
		Dealer d = new Dealer();
		HumanPlayer p = new HumanPlayer(card_num);
		ComputerPlayer c = new ComputerPlayer(card_num);
		
		//시작할때 카드 1장만 줌
		d.dealTo2(p);
		//컴퓨터는 미리 실행
		d.dealTo(c);
		
		h = p.showCards();
		ch = c.showCards();
		
		//인간 카드 
		h_sumcard=0;
		h_card="";
		for (int i = 0; i<h.length;i++ ) {
			h_sumcard += h[i].getRank();
			h_card += h[i].getSuit()+" "+h[i].getRank()+" ";
			}
		
		//컴퓨터 카드
		ch_sumcard = 0;
		ch_card="";
		for (int j = 0; j<ch.length;j++ ) {
			ch_sumcard += ch[j].getRank();
			ch_card = ch_card + ch[j].getSuit()+" "+ch[j].getRank()+" ";
			}
		
		//사람이 그만둘때 드로잉,프레임에 활용
		stophuman = true;
		}
	
	//인간 딜러 역할 한장씩 뽑아서 추가함
	public void hit(){
		deck = new CardDeck();
		c = deck.newCard(); 
		if (h_sumcard<21 & stophuman) {
			h_sumcard = h_sumcard + c.getRank();
			h_card =h_card+" "+c.getSuit()+" "+c.getRank();
		}		
	}
	
	//스톱버튼을 누르면 스톱휴먼이 펄스가됨
	public void stophuman() {
		stophuman = false;
	}
	
	//스톱휴먼의 값을 리턴해줌
	public boolean stop() {
		return stophuman;
	}
	
	// 카드패, 카드합 리턴
	public String HumanCard() {
		return h_card;
	}
	public String ComCard() {
		return ch_card;
	}
	public int HumanSumCard() {
		return h_sumcard;
	}
	public int ComSumCard() {
		return ch_sumcard;
	}
	
	//승자 리턴
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "인간 승";	
		}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";
		}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "인간 승";
		}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";
		}
		else{
			winner = "비김";
		}
		return winner;
	}

}
