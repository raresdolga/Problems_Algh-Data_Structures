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
	
	public void addToSol(ArrayList<PuzzlePiece> a,Orientation or, Edge e, int row, int col){
		PuzzlePiece p = e.parrent; 
	    a.remove(p);
		p.setOrientation(or, e);
		resolve[row][col] = p;
	}
	
	public PuzzlePiece find_corner(){
		
	}
	
	public boolean findNext(int row, int col){
		if(row == 0 && col == 0){
			PuzzlePiece p = find_corner();
		}
	}
	
	public static void main(String[] args) {
		
	}

}
