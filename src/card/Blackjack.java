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

		//�ΰ� ī�� �ʱ�ȭ
		h_count=0;
		h_sumcard=0;
		
		//����� �׸��Ѷ� ��ǻ���� ī�带 ���̰� �ϱ����� �����,�����ӿ� Ȱ��
		stophuman = true;	
		
		//��ǻ�ʹ� �̸� ����
		d.dealTo(c);
		ch = c.showCards();

		//��ǻ�� ī�带 ���ڷ� �ٲٰ� ��ǻ�� �� ����Ʈ�� ����
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
		
		//Ace ī�带 1 �Ǵ� 11
		if(ch_sumcard<=11 & ComAce > 0) {
			ch_sumcard = ch_sumcard +10;
			ComAce = 0;}
		if(ch_sumcard>21 & ComAce < 0) {
			ch_sumcard = ch_sumcard -10;
			ComAce = 0;}
		}


	//�ΰ� ���� ���� ���徿 �̾Ƽ� �߰���(��ư���� Ȱ��)
	public void hit(){
		//ī�� �̱�
		c = deck.newCard(); 	
		
		//���� ī�带 ���ڷ� �ٲٰ� �ΰ� �� ����Ʈ�� ����
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
		
		//Ace ī�带 1 �Ǵ� 11
		if(h_sumcard<=11 & HumanAce > 0) {
			h_sumcard = h_sumcard +10;
			HumanAce = 0;}
		if(h_sumcard>21 & HumanAce < 0) {
			h_sumcard = h_sumcard -10;
			HumanAce = 0;}
		}

	//ī���� ����
	public String[] list_hand() {
		return list_hand;}
	public String[] list_chand() {
		return list_chand;}
		
	//�����ư�� ������ �����޸��� �޽�����(��ư���� Ȱ��)
	//�����޸��� ���� ��������
	public void stophuman() {
		stophuman = false;}
	public boolean stop() {
		return stophuman;}
	
	//ī�� �ż� ����
	public int h_count() {
		return h_count;}
	public int ch_count() {
		return ch_count;}
	
	//ī���� ����
	public int HumanSumCard() {
		return h_sumcard;}
	public int ComSumCard() {
		return ch_sumcard;}
	
	//���� ����
	public String winner() {
		if (h_sumcard == 21 & h_sumcard != ch_sumcard | h_sumcard > ch_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "�ΰ� ��";}
		else if (ch_sumcard ==21  & h_sumcard != ch_sumcard | ch_sumcard > h_sumcard & h_sumcard < 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";}
		else if (ch_sumcard > 21 & h_sumcard < 21) {
			winner = "�ΰ� ��";}
		else if (h_sumcard > 21 & ch_sumcard < 21) {
			winner = "��ǻ�� ��";}
		else{
			winner = "���";}
		return winner;
	}


}
