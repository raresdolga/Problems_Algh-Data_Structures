package ex1_ch7;

public abstract class Card {
	private boolean available = true;
	protected int faceValue;
	protected Suit s;
	
	public Card(int c, Suit s){
		faceValue = c;
		this.s = s;
	}
	
	public abstract int value();
	public Suit suit(){ return s;}
	
	public boolean isAvailable(){
		return available;
	}
	
	public void setUnAvailable(){
		available = false;
	}
	
	public void setAvailable(){
		available = true;
	}
	
	
}
