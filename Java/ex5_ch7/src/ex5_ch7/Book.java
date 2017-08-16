package ex5_ch7;

public abstract class Book {
	public final String name;
	public final String author;
	public final int release_year;
	private int stars;
	private int nr_ratings;
	
	public Book(String name, String author, int release_year){
		this.name = name;
		this.author = author;
		this.release_year = release_year;
		stars = 0;
		nr_ratings = 1;
	}
	
	public void rate(int stars){
		// calculate dynamic average
		this.stars *= nr_ratings;
		this.stars += stars;
		this.stars /= ++nr_ratings;
		
	}
	
	
	
}
