package ex10_ch7;

public class UnitSquare {
	public boolean has_bomb;
	public int bomb_neigh;
	public boolean has_flag;
	private int row;
	private int col;
	
	public UnitSquare(int row, int col){
		has_bomb = false;
		bomb_neigh = 0;
		has_flag = false;
	}
}