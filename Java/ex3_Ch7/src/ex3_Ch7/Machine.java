package ex3_Ch7;

import java.util.ArrayList;

public class Machine {
	private ArrayList<PlayList> pl;
	public Machine(){
		pl = new ArrayList<>();
	}
	
	public void  addPl(PlayList p){
		pl.add(p);
	}
	
	public void displayPlayLists(){
		for (PlayList p : pl){
			System.out.println("Name" + p.name);
			p.display();
			System.out.println();
		}
	}
	
	public void play(PlayList p){
		p.play();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
