package ex8_Ch7;

import java.util.HashMap;

public class Game {
	
	private Board b;
	private Player [] p;
	private int nr_pl;
	
	private HashMap<Player, Integer> score;
	
	public Game(int nr_pl, int sz){
		this.nr_pl = nr_pl;
		p = new Player[nr_pl];
		b = new Board(sz,this);
		score = new HashMap<>();
		//Initialise HashMap
		for(int i = 0; i < nr_pl; i++){
			score.put(p[i],0);
		}
	}
	
	public void increaseScore(int i){
		score.put(p[i],score.get(p[i]) +1); 
		p[i].update_score(score.get(p[i]));
	}
	
	public int getScore(Player p1){
		return score.get(p1);
	}
	
	private Color getColor(boolean v){
		if(v == false)
			return Color.White;
		return Color.Black;
	}
	
	public void run() throws ArrayIndexOutOfBoundsException{
		int i, j;
		boolean val = true;
		Color c;
		for(i = 0; i < b.getSize(); i++)
			for(j = 0; j < b.getSize(); j++){
				c = getColor(val);
				b.addPiece(i, j, c);
				val = !val;
			}
	}
	
	public static void main(String[] args){
		
	}
}
