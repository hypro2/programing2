package card;

public class Card {
	//♤ ♠ ♡ ♥ ♧ ♣
	public static final String SPADES =   "♠";
	public static final String HEARTS =   "♡";
	public static final String DIAMONDS = "◇";
	public static final String CLUBS =    "♣";

	public static final int A = 1;
	public static final int J = 11;
	public static final int Q = 12;
	public static final int K = 13;
	
	private char rank_s;
	
	public static final int SIZE_OF_ONE_SUIT = 13;
	
	private String suit;
	private int rank;

	/** Constructor - Card의 무늬와 끗수를 설정 
	 * @param s - 무늬 
	 * @param r - 끗수  */
	public Card(String s, int r) { 
		suit = s;
		rank = r;
		if(rank == 1) {rank_s = 'A';}
		else if(rank == 11) {rank_s = 'J';}
		else if(rank == 12) {rank_s = 'Q';}
		else if(rank == 13) {rank_s = 'K';}
	}

	/** getSuit - 카드의 무늬 리턴 */ 
	public String getSuit() { 
		return suit; 
	}
	
	/** getCount - 카드의 등급 리턴 */ 
	public int getRank() { 
		return rank; 
	}
	public char getRank_s() {
		return rank_s;
	}
	
}
