package ex8_Ch7;

public class Player {
	private String name;
	private int score;
	
	public Player(String name){
		this.name = name;
		score = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void update_score(int score){
		score = this.score;
	}
}
