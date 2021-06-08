package card;

public class Starter {

	public static void main(String[] args) {
		Blackjack blackjack = new Blackjack(11);
		new Frame(blackjack,new Drawing(blackjack));
	}

}
