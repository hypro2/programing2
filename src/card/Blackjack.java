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
	private String[] HumanList = new String[11];
	
	//컴퓨터 변수
	private int ComSumCard;
	private int ComCount;
	private int ComAce;
	private Card[] ComHand;
	private String[] ComList= new String[11];
	
	//승자, 인간턴종료 확인
	private String winner;
	private boolean HumanTurnEnd;
	
	public Blackjack(int card_num) {
		Dealer d = new Dealer();
		ComputerPlayer c = new ComputerPlayer(card_num);

		//인간 카드 초기화
		humanCount=0;
		HumanSumCard=0;
		
		//사람이 그만둘때 컴퓨터터 카드를 보이게 하기위해 드로잉,프레임에 활용
		HumanTurnEnd = true;	
		
		//컴퓨터는 미리 실행
		d.dealTo(c);
		ComHand = c.showCards();

		//컴퓨터 카드를 문자로 바꾸고 컴퓨터 손 리스트에 저장
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
			ComAce = -1;}
		else if(ComSumCard > 11 & ComAce >0) {
			ComAce = -1;}
		
		if(ComSumCard>21 & ComAce < 0) {
			ComSumCard = ComSumCard -10;
			ComAce = 0;}
		}


	//인간 딜러 역할 한장씩 뽑아서 추가함(버튼에서 활용)
	public void hit(){
		//카드 뽑기
		c = deck.newCard(); 	
		
		//뽑은 카드를 문자로 바꾸고 인간 손 리스트에 저장
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
			HumanAce = -1;}
		else if(HumanSumCard > 11 & HumanAce >0) {
			ComAce = -1;}
		
		
		if(HumanSumCard>21 & HumanAce < 0) {
			HumanSumCard = HumanSumCard -10;
			HumanAce = 0;}
		}

	//카드패 리턴
	public String[] HumanList() {
		return HumanList;}
	public String[] ComList() {
		return ComList;}
		
	//스톱버튼을 누르면 스톱휴먼이 펄스가됨(버튼에서 활용)
	//스톱휴먼의 값을 리턴해줌
	public void HumanTurnEnd() {
		HumanTurnEnd = false;}
	public boolean stop() {
		return HumanTurnEnd;}
	
	//카드 매수 리턴
	public int humanCount() {
		return humanCount;}
	public int ComCount() {
		return ComCount;}
	
	//카드합 리턴
	public int HumanSumCard() {
		return HumanSumCard;}
	public int ComSumCard() {
		return ComSumCard;}
	
	//승자 리턴
	public String winner() {
		if (HumanSumCard == 21 & HumanSumCard != ComSumCard | HumanSumCard > ComSumCard & HumanSumCard < 21 & ComSumCard < 21) {
			winner = "인간 승";}
		else if (ComSumCard ==21  & HumanSumCard != ComSumCard | ComSumCard > HumanSumCard & HumanSumCard < 21 & ComSumCard < 21) {
			winner = "컴퓨터 승";}
		else if (ComSumCard > 21 & HumanSumCard < 21) {
			winner = "인간 승";}
		else if (HumanSumCard > 21 & ComSumCard < 21) {
			winner = "컴퓨터 승";}
		else{
			winner = "비김";}
		return winner;
	}


}
