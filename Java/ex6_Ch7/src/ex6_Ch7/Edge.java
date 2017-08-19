package ex6_Ch7;

public class Edge {
	public PuzzlePiece parrent;
	public Shape shape;
	
	public Edge(Shape shape, PuzzlePiece parrent){
		this.parrent = parrent;
		this.shape = shape;
	}
	
	
}
