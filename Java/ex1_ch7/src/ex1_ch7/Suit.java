package ex1_ch7;

public enum Suit {
	Plant(0), Diamond(1), Heart(3),Spade(4);
	int value;
	Suit s = null;
	private Suit(int val){
		value = val;
	}
	
	public int getVal(){
		return value;
	}
	
}
