package ex4_Ch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bitmask {
	private boolean bitArray(String s){
		long mask = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if((c>='A'&&c<='Z')) 
				mask = constructMask(c-'A',mask);
			else
				if((c>='a'&&c<='z'))
					mask = constructMask(c-'a',mask);
		}
		return (mask & (mask - 1)) == 0;
	}
	private long constructMask(int index,long mask){
		long aux = (1<<index);
		if((mask & aux)== 0){
			mask |= aux;
		}
		else{
			//turn the bit off = even nr of apparitions
			mask &= ~aux; // turn to 0 (negate) the bit on the right position
		}
		return mask;
	}
	public static void main(String[] args) {
		try{
			
		String s;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while(( s = in.readLine()) != null){
				Bitmask arr = new Bitmask();
				
				boolean b = arr.bitArray(s);
				System.out.println(b);
				
			}
			in.close();
		}catch(Exception  e){
			System.out.println(e.getMessage());
		}
		
	}

}
