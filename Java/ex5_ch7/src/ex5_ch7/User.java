package ex5_ch7;

import java.util.ArrayList;

public class User {
	private String name;
	private int age;
	private String user_name;
	private ArrayList<Book> read_books;
	private Book current_reading;
	
	public User(String name, int age, String user_name){
		this.name = name;
		this.age = age;
		this.user_name = user_name;
		read_books = new ArrayList<>();
		current_reading = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public ArrayList<Book> getRead_books() {
		return read_books;
	}

	public void addRead_books(Book book) {
		read_books.add(book);
	}

	public Book getCurrent_reading() {
		return current_reading;
	}

	public void setCurrent_reading(Book current_reading) {
		this.current_reading = current_reading;
	}
	
	
	
}
