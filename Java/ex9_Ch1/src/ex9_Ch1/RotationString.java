package ex9_Ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotationString {
	private StringBuilder concat(String s1, String s2){
		StringBuilder b = new StringBuilder(2*s1.length());
		b.append(s1);
		b.append(s2);
		return b;
	}
	public static void main(String args []){
		// brilliant idea : concatenate s1 and s1, look for s2 in s1+s1 waterbottle waterbottle
		BufferedReader in = null;
		try{
			String s1;
			String s2;
			in = new BufferedReader(new InputStreamReader(System.in));
			s1 = in.readLine();
			s2 = in.readLine();
			if (s1.length() != s2.length()){
				System.out.println("false");
				return ;
			}

			RotationString cl = new RotationString();
			StringBuilder builder = cl.concat(s1,s1);
		    String concat = builder.toString();
			boolean b = concat.indexOf(s2) != -1;
			System.out.println(b);
		 } catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
