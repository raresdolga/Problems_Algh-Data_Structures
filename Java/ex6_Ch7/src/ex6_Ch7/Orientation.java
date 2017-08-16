package ex6_Ch7;

public enum Orientation {
	Right,Left,Top,Bottom;
	
	public Orientation getOpposite(){
		switch(this){
		case Right : return Left;
		case Left : return Right;
		case Top : return Bottom;
		case Bottom : return Top;
		default : return null;
		}
	}
}
