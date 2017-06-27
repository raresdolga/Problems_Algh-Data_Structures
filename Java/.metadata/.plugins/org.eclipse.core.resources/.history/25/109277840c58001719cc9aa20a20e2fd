package ex5_Ch1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneEdit {
	private boolean replace(String s1, String s2){
		boolean ok = true;
		for(int i = 0; i < s1.length(); i++){
			if((s1.charAt(i) != s2.charAt(i)) && ok )
				ok = false;
			else
				if(s1.charAt(i) != s2.charAt(i))
					return false;
		}
		return true;
	}
	private boolean insert_delete(String s1, String s2){
		// assume that s1 is bigger than s2
		int index1 = 0, index2 = 0;
		boolean ok = true;
		while(index1 < s1.length() && index2 < s2.length()){
			if((s1.charAt(index1) != s2.charAt(index2)) && ok){
				
				ok = false;
			}
			else
				if(s1.charAt(index1) != s2.charAt(index2)){
					return false;
				}
				else{
			index2 ++;
				}
			index1 ++;
		}
		return true;
	}
	private boolean call_apropriate(String s1, String s2){
		int n1 = s1.length();
		int n2 = s2.length();
		boolean ans = false ;
		if(n1 - n2 == 1) ans = insert_delete(s1,s2);
		else
			if(n1 - n2 == 0) ans = replace(s1,s2);
		else
			if(n1 - n2 == -1) ans = insert_delete(s2,s1);
		return ans;
	}
public static void main(String args []) {
		BufferedReader in = null;
		try{
			String s1;
			String s2;
			in = new BufferedReader(new InputStreamReader(System.in));
			s1 = in.readLine();
			s2 = in.readLine();
			OneEdit prb = new OneEdit();
			System.out.println(prb.call_apropriate(s1,s2));
			
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
