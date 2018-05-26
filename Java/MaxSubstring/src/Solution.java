import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
	public String longestSub(ArrayList<String> sub, String word){
		HashMap<Character,ArrayList<Integer>> positions = new HashMap<>();
		ArrayList<Integer> newArr = null;
		for(int i = 0; i < word.length(); i++){
			if(positions.containsKey(word.charAt(i))){
				newArr = positions.get(word.charAt(i));
				newArr.add(i);
				positions.put(word.charAt(i), newArr);
				
			}
			else{
				newArr = new ArrayList<>();
				newArr.add(i);
				positions.put(word.charAt(i), newArr);
			}
		}
		for(Character c : positions.keySet()){
			for(Integer a :positions.get(c)){
				System.out.print(a + " "+ c);
			}
			System.out.println();
		}
		int j, now;
		String max = "";
		ArrayList<Integer> prev;
		HashMap<Character, ArrayList<Integer>> aux = positions;
		for(String s : sub){
			aux = positions;
			for(j = 0; j < s.length(); j++){
				if(aux.containsKey(s.charAt(j))){
					prev = aux.get(s.charAt(j));
					if(prev.size() !=0){
						prev.remove(0);
						System.out.println("ntra");
						aux.put(s.charAt(j), prev);
					}
					else{
						System.out.println("masa");
						break;
					}
				}
				else{
					System.out.println("ce ???");
					break;
				}
			}
			
			if(s.length() > max.length() && j >=s.length())
				max = s;
			System.out.println("nou:");
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		String word = in.nextLine();
		int n = in.nextInt();
		System.out.println(n);
		// go next line to read a string
		in.nextLine();
		String current;
		ArrayList<String> sub = new ArrayList<String>();
		for(int i = 0; i < n; i++){
			current = in.nextLine();
			sub.add(current);
			
		}
		in.close();
		Solution sol = new Solution();
		System.out.println(sol.longestSub(sub, word));
	}

}
