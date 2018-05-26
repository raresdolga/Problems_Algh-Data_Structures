import java.util.Scanner;

public class ex5Ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		ex5Ch1 ob = new ex5Ch1();
		System.out.print(ob.oneEdit(s1, s2));
	}
	
	public boolean oneEdit(String s1, String s2){
		if(Math.abs(s1.length() - s2.length()) >= 2)
			return false;
		String a, b;
		// a smallest, b biggest
		if(s1.length() > s2.length()){
			a = s2;
			b = s1;
		}
		else{
			a = s1;
			b = s2;
		}
		int j = 0;
		int i = 0;
		int count = 0;
		while( j < a.length() && count < 2){
			if(a.charAt(j) != b.charAt(i)){
				count++;
				if(a.length() < b.length())
					j--;
			}
			j++;
			i++;
		}
		if(count >= 2) return false;
		return true;
	}
}