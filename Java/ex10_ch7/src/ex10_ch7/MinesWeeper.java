package ex10_ch7;

import java.awt.Button;

public class MinesWeeper {
	Board b;
	UnitSquare[][] board;
	Button [][] buttons;
	public MinesWeeper(int size, int bombs){
		b = new Board(size,bombs);
		b.initializeGame();
		board = b.getBoard();
		buttons = new Button[size][size];
	}
	
	public void clickSquare(int row, int col){
		int neigh [][] = {
				{-1, -1}, {-1, 0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1,0}, {1,1}
		};
		int r, c;
			if(board[row][col].has_bomb)
				System.out.println("you have lost");
			else {
				for(int[] n : neigh){
					r = row + n[0];
					c = col + n[1];
					reveal_Neigh(r, c);
				}
			}
		}
	private void reveal_Neigh(int row, int col){
		String label;
		if(row >= 0 && row < b.getSize() && col >= 0 && col < b.getSize()){
			if(!board[row][col].has_bomb){
				label = board[row][col].bomb_neigh + "";
				buttons[row][col].setEnabled(false);
				buttons[row][col].setLabel(label);
				// recurse but in parallel functions
				clickSquare(row, col);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinesWeeper g = new MinesWeeper(5,7);
	}

}
