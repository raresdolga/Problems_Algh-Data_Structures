import java.util.Scanner;

public class ex9Ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		ex9Ch1 ob = new ex9Ch1();
		System.out.println(ob.checkRotation(s1,s2));
	}
	private boolean isSubstring(String s1, String s2){
		return s1.indexOf(s2) != -1;
		
	}
	public boolean checkRotation(String s1, String s2){
		// not sure about null strings
		if(s1.length() == 0 || s1.length() != s2.length())
			return false;
		// for efficiency make sufficeient space;
		StringBuilder sb = new StringBuilder(s1.length()*2);
		sb.append(s1);
		sb.append(s1);
		return isSubstring(sb.toString(),s2);
	}
}