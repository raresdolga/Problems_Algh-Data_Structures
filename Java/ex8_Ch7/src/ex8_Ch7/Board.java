package ex8_Ch7;

public class Board {
	private int size;
	private Color [][] board;
	private Game g;
	
	public Board(int size, Game g){
		this.size = size;
		board = new Color[size][size];
		this.g = g;
	}
	
	private void flip_color(Color c, int row, int col){
		board[row][col] = c;
		int p = c.getVal();
		g.increaseScore(p);
	}
	
	private void check_neigh(int row, int col, Color c){
		if(row - 2 > 0){
			if(board[row - 2][col] == board[row][col])
				if(board[row -1][col] != board[row][col] && board[row -1 ][col] != null){
					//flip color
					flip_color(c,row - 1, col);
					//check again for new neighbours
					check_neigh(row - 1, col , c);	
				}
		}
			if(col - 2 >0){
				if(board[row][col - 2] == board[row][col])
					if(board[row][col - 1] != board[row][col] && board[row ][col - 1] != null){
						//flip color
						flip_color(c,row, col - 1);
						//check again for new neighbours
						check_neigh(row, col - 1, c);	
					}
			}
			
			if(row + 2 < size){
				if(board[row + 2][col] == board[row][col])
					if(board[row  + 1][col] != board[row][col] && board[row + 1][col] != null){
						//flip color
						flip_color(c,row + 1, col);
						//check again for new neighbours
						check_neigh(row + 1, col , c);	
					}
			}
			if(col + 2 < size){
				if(board[row][col + 2] == board[row][col])
					if(board[row][col + 1] != board[row][col] && board[row][col + 1] != null){
						//flip color
						flip_color(c,row, col + 1);
						//check again for new neighbours
						check_neigh(row, col + 1 , c);	
					}
			}
	}
	
	public int getSize(){
		return size;
	}
	
	public void addPiece(int row, int col, Color c) throws ArrayIndexOutOfBoundsException{
		if(row < 0 || row >= size || col < 0 || row >= size)
			throw new ArrayIndexOutOfBoundsException();
		board[row][col] = c;
		check_neigh(row,col,c);
	}
}
