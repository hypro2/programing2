package card;

public class Blackjack {
	
	//변수 선언 
	//인간 카드 덱
	private Card c;
	private CardDeck deck = new CardDeck();
	
	//인간 변수
	private int HumanSumCard;
	private int humanCount;
	private int HumanAce;
	private boolean boolHumanAce = false;
	private String[] HumanList = new String[11];
	
	//컴퓨터 변수
	private Card[] ComHand;
	private int ComSumCard;
	private int ComCount;
	private int ComAce;
	private boolean boolComAce = false;
	private String[] ComList= new String[11];
	
	//승자, 인간턴종료 확인
	private String winner;
	private boolean HumanTurnEnd;
	private int HumanWinCount;
	private int ComWinCount;
	
	public Blackjack(int card_num) {
		ComHand();
		comhit();
		HumanWinCount = 0;
		ComWinCount = 0;
	}
	
	public Card[] ComHand(){
		Dealer d = new Dealer();
		ComputerPlayer c = new ComputerPlayer(11);	
		HumanTurnEnd = true;	
		d.dealTo(c);
		ComHand = c.showCards();	
		return ComHand;
		}
	
	public void comhit(){
		//컴퓨터 카드를 문자로 바꾸고 컴퓨터손 리스트에 저장
		ComCount=ComHand.length;
		ComSumCard = 0;
		for (int j = 0; j<ComHand.length;j++ ) {
			if(ComHand[j].getRank()==1) {
				ComSumCard += ComHand[j].getRank();
				ComList[j] = ComHand[j].getSuit()+" "+ComHand[j].getRank_s();
				ComAce=1;}
			else if (ComHand[j].getRank() > 10) {
				ComSumCard += 10;
				ComList[j] = ComHand[j].getSuit()+" "+ComHand[j].getRank_s();}
			else {
				ComSumCard += ComHand[j].getRank();
				ComList[j] = ComHand[j].getSuit()+" "+ComHand[j].getRank();}
			}
		
		//Ace 카드를 1 또는 11
		if(ComSumCard<=11 & ComAce > 0) {
			ComSumCard = ComSumCard +10;
			boolComAce = true;}
		
		//Ace 11이 1이 되는 조건, 단 한번만 실행가능
		if(ComSumCard>21 & ComAce > 0 & boolComAce) {
			ComSumCard = ComSumCard -10;
			boolComAce = false;
			ComAce = 0;}
		}

	//인간 딜러 역할 한장씩 뽑아서 추가함(버튼에서 활용)
	public void hit(){
		
		//덱에서 카드 뽑기
		c = deck.newCard(); 	
		
		//뽑은 카드를 문자로 바꾸고 인간손 리스트에 저장
		if (HumanSumCard<21 & HumanTurnEnd) {
			if (c.getRank() == 1) {
				HumanSumCard = HumanSumCard + c.getRank();
				HumanList[humanCount()]=c.getSuit()+" "+c.getRank_s();
				HumanAce = 1;}
			else if (c.getRank() > 10) {
				HumanSumCard = HumanSumCard + 10;
				HumanList[humanCount()]=c.getSuit()+" "+c.getRank_s();}
			else {
				HumanSumCard = HumanSumCard + c.getRank();
				HumanList[humanCount()]=c.getSuit()+" "+c.getRank();}
			humanCount +=1;
			}
		
		//Ace 카드를 1 또는 11
		if(HumanSumCard<=11 & HumanAce > 0) {
			HumanSumCard = HumanSumCard +10;
			boolHumanAce = true;}
		
		//Ace 11이 1이 되는 조건, 단 한번만 실행가능
		if(HumanSumCard>21 & HumanAce > 0 & boolHumanAce) {
			HumanSumCard = HumanSumCard -10;
			boolHumanAce = false;
			HumanAce = 0;}
		}

	//카드패 리턴
	public String[] HumanList() {
		return HumanList;}
	public String[] ComList() {
		return ComList;}
		
	//스톱버튼을 누르면 휴먼턴엔드 값이 펄스가됨(버튼에서 활용)
	//휴먼턴엔드의 값을 리턴해줌
	public void HumanTurnEnd() {
		HumanTurnEnd = false;}
	public boolean stop() {
		return HumanTurnEnd;}
	
	//카드 매수 리턴
	public int humanCount() {
		return humanCount;}
	public int ComCount() {
		return ComCount;}
	
	//카드 합 리턴
	public int HumanSumCard() {
		return HumanSumCard;}
	public int ComSumCard() {
		return ComSumCard;}

	//승자 리턴
	public String winner() {
			 if ((HumanSumCard == 21 & HumanSumCard != ComSumCard) || 
				 (HumanSumCard > ComSumCard & HumanSumCard < 21 & ComSumCard < 21) ||
				 (ComSumCard > 21 & HumanSumCard < 21 && HumanSumCard != 0)) {
			winner = "인간";
			HumanWinCount =+1;}
		
		else if ((ComSumCard == 21  & HumanSumCard != ComSumCard) ||
				 (ComSumCard > HumanSumCard & HumanSumCard < 21 & ComSumCard < 21)||
				 (HumanSumCard > 21 || HumanSumCard == 0)) {
			winner = "컴퓨터";}
		
		else{
			winner = "무승부";
			ComWinCount=+1;}
		return winner;
	}
	
	public int HumanWinCount() {
		return HumanWinCount;}

	public int ComWinCount() {
		return ComWinCount;}
	
	public void chogihwa(){
		HumanSumCard = 0;
		humanCount = 0;
		HumanAce = 0;
		boolHumanAce = false;
		HumanList = new String[11];
		ComHand = null;
		ComSumCard = 0;
		ComCount = 0;
		ComAce = 0;
		boolComAce = false;
		ComList= new String[11];
		HumanTurnEnd = true;
		ComHand();
		comhit();
	}


}
