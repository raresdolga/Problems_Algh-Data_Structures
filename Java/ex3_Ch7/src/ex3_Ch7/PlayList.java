package ex3_Ch7;

import java.util.ArrayList;

public class PlayList {
	String name;
	public ArrayList<Song> songs = new ArrayList<>();
	
	public void addSong(Song s) {
		songs.add(s);
	}
	
	public void removeSong(Song s){
		songs.remove(s);
	}
	
	public void display(){
		for (Song s : songs)
			System.out.println(s.toString());
	}
	
	public void play(){
		for (Song s : songs)
			s.play();
	}
}
