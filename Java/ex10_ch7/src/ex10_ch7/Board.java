package ex10_ch7;

import java.util.Random;

public class Board {
	private UnitSquare[][] board;
	private int size;
	private int nr_bombs;
	
	public Board(int size, int nr_bombs){
		this.size = size;
		board = new UnitSquare [size + 2][size + 2];
		this.nr_bombs = nr_bombs;
	}
	
	//template method
	public final void initializeGame(){
		// initialise board
				int i, j;
				for(i = 1; i <= size; i++)
					for(j = 1; j <= size; j++){
						board[i][j] = new UnitSquare(i,j);
					}
				putBombs();
				make_border();
				mark_neigh();
	}
	
	private void putBombs(){
		Random rn = new Random();
		int bomb, row, col;
		for(int i = 1; i <= nr_bombs; i++){
			bomb = rn.nextInt((size)*(size));
			row = (bomb)/ (size);
		    col = (bomb) % (size);
		 // index starts from 1 so we must adapt the modulo
		    board[row + 1][col + 1].has_bomb = true ;
		}		
	}
	
	private void make_border(){
		int i;
		for(i = 1; i <= size+1; i++){
			board[0][i] = new UnitSquare(0,i);
			board[i - 1][0] = new UnitSquare(i - 1, 0);
		}
		
		for(i = 0; i <= size; i++){
			board[size+1][i] = new UnitSquare(size + 1,i);
			board[i + 1][size+1] = new UnitSquare(i + 1, size + 1);
		}
	}
	private void mark_neigh(){
		int i,j;
		for(i = 1; i <= size; i++)
			for(j = 1; j <= size; j++){
				if(board[i][j].has_bomb)
				 count_neighBombs(i,j);
			}
	}
	private void count_neighBombs(int row, int col){
		if(!board[row - 1][col - 1].has_bomb)
			board[row - 1][col - 1].bomb_neigh ++;
		if(board[row - 1][col].has_bomb)
			board[row - 1][col].bomb_neigh ++;
		if(board[row][col - 1].has_bomb)
			board[row][col - 1].bomb_neigh ++;
		if(board[row + 1][col + 1].has_bomb)
			board[row + 1][col + 1].bomb_neigh ++;
		if(board[row + 1][col].has_bomb)
			board[row + 1][col].bomb_neigh ++;
		if(board[row][col + 1].has_bomb)
			board[row][col + 1].bomb_neigh ++;
		if(board[row - 1][col + 1].has_bomb)
			board[row - 1][col + 1].bomb_neigh ++;
		if(board[row + 1][col - 1].has_bomb)
			board[row + 1][col - 1].bomb_neigh ++;
		
	}
	
	public UnitSquare[][] getBoard(){
		return board;
	}
	
	public int getSize(){
		return size;
	}
}
