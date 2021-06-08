package card;

public class Blackjack {
	
	//���� ���� 
	//�ΰ� ī�� ��
	private Card c;
	private CardDeck deck = new CardDeck();
	
	//�ΰ� ����
	private int HumanSumCard;
	private int humanCount;
	private int HumanAce;
	private String[] HumanList = new String[11];
	
	//��ǻ�� ����
	private int ComSumCard;
	private int ComCount;
	private int ComAce;
	private Card[] ComHand;
	private String[] ComList= new String[11];
	
	//����, �ΰ������� Ȯ��
	private String winner;
	private boolean HumanTurnEnd;
	
	public Blackjack(int card_num) {
		Dealer d = new Dealer();
		ComputerPlayer c = new ComputerPlayer(card_num);

		//�ΰ� ī�� �ʱ�ȭ
		humanCount=0;
		HumanSumCard=0;
		
		//����� �׸��Ѷ� ��ǻ���� ī�带 ���̰� �ϱ����� �����,�����ӿ� Ȱ��
		HumanTurnEnd = true;	
		
		//��ǻ�ʹ� �̸� ����
		d.dealTo(c);
		ComHand = c.showCards();

		//��ǻ�� ī�带 ���ڷ� �ٲٰ� ��ǻ�� �� ����Ʈ�� ����
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
		
		//Ace ī�带 1 �Ǵ� 11
		if(ComSumCard<=11 & ComAce > 0) {
			ComSumCard = ComSumCard +10;
			ComAce = -1;}
		else if(ComSumCard > 11 & ComAce >0) {
			ComAce = -1;}
		
		if(ComSumCard>21 & ComAce < 0) {
			ComSumCard = ComSumCard -10;
			ComAce = 0;}
		}


	//�ΰ� ���� ���� ���徿 �̾Ƽ� �߰���(��ư���� Ȱ��)
	public void hit(){
		//ī�� �̱�
		c = deck.newCard(); 	
		
		//���� ī�带 ���ڷ� �ٲٰ� �ΰ� �� ����Ʈ�� ����
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
		
		//Ace ī�带 1 �Ǵ� 11
		if(HumanSumCard<=11 & HumanAce > 0) {
			HumanSumCard = HumanSumCard +10;
			HumanAce = -1;}
		else if(HumanSumCard > 11 & HumanAce >0) {
			ComAce = -1;}
		
		
		if(HumanSumCard>21 & HumanAce < 0) {
			HumanSumCard = HumanSumCard -10;
			HumanAce = 0;}
		}

	//ī���� ����
	public String[] HumanList() {
		return HumanList;}
	public String[] ComList() {
		return ComList;}
		
	//�����ư�� ������ �����޸��� �޽�����(��ư���� Ȱ��)
	//�����޸��� ���� ��������
	public void HumanTurnEnd() {
		HumanTurnEnd = false;}
	public boolean stop() {
		return HumanTurnEnd;}
	
	//ī�� �ż� ����
	public int humanCount() {
		return humanCount;}
	public int ComCount() {
		return ComCount;}
	
	//ī���� ����
	public int HumanSumCard() {
		return HumanSumCard;}
	public int ComSumCard() {
		return ComSumCard;}
	
	//���� ����
	public String winner() {
		if (HumanSumCard == 21 & HumanSumCard != ComSumCard | HumanSumCard > ComSumCard & HumanSumCard < 21 & ComSumCard < 21) {
			winner = "�ΰ� ��";}
		else if (ComSumCard ==21  & HumanSumCard != ComSumCard | ComSumCard > HumanSumCard & HumanSumCard < 21 & ComSumCard < 21) {
			winner = "��ǻ�� ��";}
		else if (ComSumCard > 21 & HumanSumCard < 21) {
			winner = "�ΰ� ��";}
		else if (HumanSumCard > 21 & ComSumCard < 21) {
			winner = "��ǻ�� ��";}
		else{
			winner = "���";}
		return winner;
	}


}
