package ex8_ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Permutations_repeat {
	public  void perm(HashMap<Character, Integer> frec, String partial, int sz, ArrayList<String> result){
		if(sz == 0){
	        result.add(partial);
	        return ;
	    }
	        for(Character i : frec.keySet()){
	                int cont = frec.get(i);
	                if(cont > 0){
		                frec.put(i,cont - 1);
		                perm(frec,partial + i, sz - 1, result);
		                // add character back for the other branches of the permutation
		                frec.put(i,cont);
		                
	                }
	        }

	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < a.length(); i++){
			if(frequency.containsKey(a.charAt(i)))
				frequency.put(a.charAt(i), frequency.get(a.charAt(i)) + 1);
			else
				frequency.put(a.charAt(i),1);
		}
		
		Permutations_repeat obj = new Permutations_repeat();
		/*for (Character f : frequency.keySet()){
			System.out.println(f + " " + frequency.get(f));
		}*/
		obj.perm(frequency,"", a.length(),result);
	 for(String s : result){
		System.out.println(s);
	}
	}

}
