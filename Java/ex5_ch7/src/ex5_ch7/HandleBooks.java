package ex5_ch7;

import java.util.ArrayList;

public class HandleBooks {
	private ArrayList<User> users = new ArrayList<User>();
	private BookCollection bc;
	
	public void addUser(User u){
		users.add(u);
	}
	
	public boolean removeUser(User u){
		return users.remove(u);		
	}
	
	public HandleBooks(){
		bc = new BookCollection();
	}
	
	public static void main(String[] args) {

	}

}