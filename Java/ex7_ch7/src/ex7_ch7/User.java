package ex7_ch7;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private String name;
	private String user_name;
	private ArrayList<User> friends;
	private CommonGUI inter;
	private System s = System.getInstance();
	
	
	public User(String name, String UserName){
		this.name = name;
		this.user_name = user_name;
		friends = new ArrayList<>();
		//set specific fields to the user
		inter = new CommonGUI(this);
	}
	
	public void acceptFriend(User us){
		s.make_Friends(us, this);
	}
	
	public void addFriend(User u){
		friends.add(u);
	}
	
	public void sendRequest(User destination){
		String Message = inter.getMessageInput();
		Message m = new Message(destination,this,Message);
		s.sendMessage(m);
	}
	
	//gets called when user presses log in 
	public void notifyObs(){
		s.add_currentUser(this);
	}
	
	
}
