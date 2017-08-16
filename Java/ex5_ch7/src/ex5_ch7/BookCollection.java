package ex5_ch7;

import java.util.ArrayList;

public class BookCollection {
	private ArrayList<ActionBook> action;
	private ArrayList<ScienceFiction> sF;
	
	public BookCollection(){
		action = new ArrayList<ActionBook>();
		sF = new ArrayList<ScienceFiction>();
	}
	
	public void addSF(ScienceFiction b){
		sF.add(b);
	}
	
	public void addActionBook(ActionBook b){
		action.add(b);
	}
	
	public Book findBook(ActionBook b, String name, String author){
		for(Book book : action){
			if(book.name.equals(name))
				if(book.author.equals(author))
					return book;
		}
		return null;
	}
}
