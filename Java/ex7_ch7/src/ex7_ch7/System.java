package ex7_ch7;

import java.util.ArrayList;
import java.util.HashMap;

public class System {
	private ArrayList<User> users;
	private ArrayList<User> current_users;
	private volatile static System s;
	private HashMap<User, Integer> ids;
	
	private System(){
		users = new ArrayList<>();
		current_users = new ArrayList<>();
		ids = new HashMap<>();
	}
	
	public static System getInstance(){
		if(s == null){
			synchronized(System.class){
				if(s == null){
					s = new System();
				}
			}
		}
		return s;
	}
	
	public void make_Friends(User r, User s){
		r.addFriend(s);
		s.addFriend(r);
	}
	public void add_user(User u){
		users.add(u);
	}
	
	public void remove_user(User u){
		users.remove(u);
	}
	
	public void add_currentUser(User u){
		current_users.add(u);
	}
	
	public void rm_currentUser(User u){
		current_users.remove(u);
	}
	
	public void sendMessage(Message m){
		Integer id1 = ids.get(m.getReceiver());
		Integer id2 = ids.get(m.getSender());
		//server send message
	}
	public static void main(String[] args) {
	
	}

}
