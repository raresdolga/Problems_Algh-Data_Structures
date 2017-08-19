package ex6_Ch7;

import java.util.HashMap;

public class PuzzlePiece {
	private boolean isCorner;
	private boolean isMargin;
	// hash map has 4 elements
	private HashMap<Orientation, Edge> pos;
	
	public PuzzlePiece(boolean isCorner, boolean isMargin){
		this.isCorner = isCorner;
		this.isMargin = isMargin;
		pos = new HashMap<>();
	}
	
	public void setOrientation(Orientation o, Edge e) {
		pos.put(o,e);
	}
	
	public Edge getEdge_byOr(Orientation o){
		return pos.get(o);
	}

	public boolean isCorner() {
		return isCorner;
	}

}
