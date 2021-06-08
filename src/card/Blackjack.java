package card;

public class Blackjack {
	
	private Card c;
	private CardDeck deck = new CardDeck();
	private int h_sumcard;
	private int ch_sumcard;
	private int h_count;
	private int ch_count;
	private int HumanAce;
	private int ComAce;
	private String winner;
	private Card[] ch;
	private String[] list_hand = new String[11];
	private String[] list_chand= new String[11];
	private boolean stophuman;
	
	public Blackjack(int card_num) {
		Dealer d = new Dealer();
		ComputerPlayer c = new ComputerPlayer(card_num);

		//인간 카드 초기화
		h_count=0;
		h_sumcard=0;
		
		//사람이 그만둘때 컴퓨터터 카드를 보이게 하기위해 드로잉,프레임에 활용
		stophuman = true;	
		
		//컴퓨터는 미리 실행
		d.dealTo(c);
		ch = c.showCards();

		//컴퓨터 카드를 문자로 바꾸고 컴퓨터 손 리스트에 저장
		ch_count=ch.length;
		ch_sumcard = 0;
		for (int j = 0; j<ch.length;j++ ) {
			if(ch[j].getRank()==1) {
				ch_sumcard += ch[j].getRank();
				list_chand[j] = ch[j].getSuit()+" "+ch[j].getRank_s();
				ComAce=1;}
			else if (ch[j].getRank() > 10) {
				ch_sumcard += 10;
				list_chand[j] = ch[j].getSuit()+" "+ch[j].getRank_s();}
			else {
				ch_sumcard += ch[j].getRank();
				list_chand[j] = ch[j].getSuit()+" "+ch[j].getRank();}
			}
		
		//Ace 카드를 1 또는 11
		if(ch_sumcard<=11 & ComAce > 0) {
			ch_sumcard = ch_sumcard +10;
			ComAce = 0;}
		if(ch_sumcard>21 & ComAce < 0) {
			ch_sumcard = ch_sumcard -10;
			ComAce = 0;}
		}


	//인간 딜러 역할 한장씩 뽑아서 추가함(버튼에서 활용)
	public void hit(){
		//카드 뽑기
		c = deck.newCard(); 	
		
		//뽑은 카드를 문자로 바꾸고 인간 손 리스트에 저장
		if (h_sumcard<21 & stophuman) {
			if (c.getRank() == 1) {
				h_sumcard = h_sumcard + c.getRank();
				list_hand[h_count()]=c.getSuit()+" "+c.getRank_s();
				HumanAce = 1;}
			else if (c.getRank() > 10) {
				h_sumcard = h_sumcard + 10;
				list_hand[h_count()]=c.getSuit()+" "+c.getRank_s();}
			else {
				h_sumcard = h_sumcard + c.getRank();
				list_hand[h_count()]=c.getSuit()+" "+c.getRank();}
			h_count +=1;
			}
		
		//Ace 카드를 1 또는 11
		if(h_sumcard<=11 & HumanAce > 0) {
			h_sumcard = h_sumcard +10;
			HumanAce = 0;}
		if(h_sumcard>21 & HumanAce < 0) {
			h_sumcard = h_sumcard -10;
			HumanAce = 0;}
		}

	//카드패 리턴
	public String[] list_hand() {
		return list_hand;}
	public String[] list_chand() {
		return list_chand;}
		
	//스톱버튼을 누르면 스톱휴먼이 펄스가됨(버튼에서 활용)
	//스톱휴먼의 값을 리턴해줌
	public void stophuman() {
		stophuman = false;}
	public boolean stop() {
		return stophuman;}
	
	//카드 매수 리턴
	public int h_count() {
		return h_count;}
	public int ch_count() {
		return ch_count;}
	
	//카드합 리턴
	public int HumanSumCard() {
		return h_sumcard;}
	public int ComSumCard() {
		return ch_sumcard;}
	
	//승자 리턴
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "인간 승";}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "인간 승";}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "컴퓨터 승";}
		else{
			winner = "비김";}
		return winner;
	}


}
