import java.util.Scanner;
import java.util.HashMap;
public class ex2Ch1{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String s1 = in.nextLine();
	String s2 = in.nextLine();
	
	ex2Ch1 obj = new ex2Ch1();
	System.out.println(obj.perm(s1, s2));
	}
	
	public Boolean perm(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++)
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		for(int i = 0; i < s2.length(); i++){
			map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
			if(map.get(s2.charAt(i)) < 0)
				return false;
		}
			
		return true;
	}
}