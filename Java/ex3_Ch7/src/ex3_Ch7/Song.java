package ex3_Ch7;

public class Song {
	private final  String artist;
	private  final String name;
	private final String release_year;
	
	public Song(String artist, String name, String release_year){
		this.name = name;
		this.artist = artist;
		this.release_year = release_year;
	}
	
	public String getArtist(){
		return this.artist;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getRelease_year(){
		return this.release_year;
	}
	
	public void play(){
		System.out.println(this.name + " Lalalalalalala we are singing");
	}
	
	public String toString(){
		String s = new String("Name:");
		s = s +  " " +this.name;
		s += "\nArtist " + this.artist;
		s += "\nreleas_year" + this.release_year;
		return s;
	}
}
