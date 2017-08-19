package ex6_Ch7;

import java.util.ArrayList;

public class Puzzle {
	public int size;
	ArrayList<PuzzlePiece> pieces;
	PuzzlePiece [][] resolve;
	
	public Puzzle(ArrayList<PuzzlePiece> a){
		pieces = a;
		resolve = new PuzzlePiece[size][size];
	}
	
	public void solve(){}
	
	public void addToSol(Orientation or, Edge e, int row, int col){
		PuzzlePiece p = e.parrent; 
	    pieces.remove(p);
		p.setOrientation(or, e);
		resolve[row][col] = p;
	}
	
	public PuzzlePiece find_corner(){
		for(int i = 0; i < pieces.size(); i++){
			if(pieces.get(i).isCorner())
				if(pieces.get(i).getEdge_byOr(Orientation.Top).shape == Shape.No && pieces.get(i).getEdge_byOr(Orientation.Left).shape == Shape.No){
					pieces.remove(i);
					return pieces.get(i);
				}
		}
		return null;
	}
	
	public boolean findNext(int row, int col){
		if(row == 0 && col == 0){
			PuzzlePiece p = find_corner();
			resolve [0][0] = p;
		}
		else{
			PuzzlePiece p = col == 0 ? resolve[row -1][0]:resolve[row-1][col-1];
			Orientation or = col == 0 ? Orientation.Bottom: Orientation.Right;
			Edge ed_toMatch = p.getEdge_byOr(or);
			if(ed_toMatch == null)
				return false;
		
			Orientation oOpp = or.getOpposite();
			addToSol(oOpp,ed_toMatch,row,col);
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
	}

}
