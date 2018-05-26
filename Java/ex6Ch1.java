import java.util.Scanner;

public class ex6Ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		ex6Ch1 ob = new ex6Ch1();
		System.out.print(ob.compress(s));
	}
	
	public String compress(String s){
		int count = 0, i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < s.length() - 1){
			while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
				count++; 
				i++;
			}
			count++;
			sb.append(s.charAt(i));
			sb.append(count);
			count = 0;
			i++;
		}
		
		if(sb.length() < 2 || sb.charAt(sb.length() - 2) != s.charAt(s.length() - 1)){
			sb.append(s.charAt(s.length() - 1));
			sb.append(1);
		}
		if(sb.length() <= s.length())
			return sb.toString();
		else
			return s;
	}
}