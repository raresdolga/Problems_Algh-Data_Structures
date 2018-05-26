import java.util.Scanner;

public class ex1_ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		ex1_ch1 obj = new ex1_ch1();
		System.out.println(obj.checkUniqueCh(s));
	}
	public Boolean checkUniqueCh(String s){
		//128 bits can be stored in 2 longs = 64 bits each
		long a = 0;
		long b = 0;
		long val = 0;
		long check = 0;
		
		for(int i = 0; i < s.length(); i++){
			val = s.charAt(i) - '0';
			// bit 0 to 63
			if(val <= 63)
				check = a;
			else
				check = b;
			System.out.println(val + " " + (long)(1 << val));
			// if not 0 already marked, appears more then onece 
			if(((long)(1 << val) & check) > 0)
				return false;
			check = check | (long)(1 << val);
			if(val <= 63)
				 a = check;
			else
				 b = check;
		}
		return true;
	}
}