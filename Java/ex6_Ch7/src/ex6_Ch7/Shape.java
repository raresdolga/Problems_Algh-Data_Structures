package ex6_Ch7;

public enum Shape {
	Inner, Outer,No;
	public Shape getOpposite(){
		switch(this){
		case Inner : return Outer;
		case Outer: return Inner;
		default : return null;
		}
			
	}
}
