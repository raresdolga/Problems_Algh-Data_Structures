package ex8_Ch7;

public enum Color {
	Black(0),White(1);
	private int b;
	
	private Color(int b){
		this.b = b;
	}
	
	public int getVal(){
		return b;
	}
}
