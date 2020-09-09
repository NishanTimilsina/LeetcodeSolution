import java.util.Random;

public class Card {

	String rank;
	String suit;
	
	Card(String r,String s) {
		this.rank = r;
		this.suit = s;
	}
}


class DeckOfCards{
	
	final int size = 52;
	Card[] deckOfCard = new Card[size];
	int counter=0;
	
	DeckOfCards(){
	String[] suits = {"Heart","Diamond","spade","clubs"};
	String[] ranks = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	for(String s:suits) {
		for (String r:ranks) {
			Card card = new Card(r,s);
			deckOfCard[counter] = card;
			counter++;
		}
	}	
}
	
	public void suffle() {
	
		Random rand = new Random();
		int j;
		for(int i=0;i<size;i++) {
			j = rand.nextInt(52);
			Card temp = deckOfCard[i];
			deckOfCard[i] = deckOfCard[j];
			deckOfCard[j] = temp;
		}
		

	}
}
