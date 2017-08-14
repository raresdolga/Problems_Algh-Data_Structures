package ex1_ch7;

import java.util.ArrayList;

public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	
	public void suffle(){ }
	
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int nr){ // game detail	
		return null;
	}
	
	public T dealCard(){
		//game detail
		return null;
		}
}
