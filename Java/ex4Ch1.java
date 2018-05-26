import java.util.Scanner;
import java.util.HashMap;
public class ex4Ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		s = s.toLowerCase();
		ex4Ch1 obj = new ex4Ch1();
		System.out.println(obj.palPermut(s) + " bit: " + obj.bitPalPermut(s));
	}
	
	public Boolean palPermut(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != ' ')
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		int odd = 0;
		// one odd appearance allowed
		for(Character c : map.keySet())
			if(odd > 0 && map.get(c)%2 != 0)
				return false;
			else
			if(map.get(c) % 2 != 0)
				odd++;
		return true;
	}
	
	public Boolean bitPalPermut(String s){
		int marker = 0;
		int val = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ') continue;
			val = 1 << (s.charAt(i) - 'a');
			if((marker & val) == 0) // bit was 0, make it 1
				marker |= val;
			else
				marker &= (~val); // bit was 1 make it 0
		}
		if(marker == 0)
			return true;
		//count nr of 1's
		boolean odd = false;
		for(int i = 0; i < 32; i++){
			if((marker & (1 << i)) > 0){
				if(odd == true)
					return false;
				odd = true;
			}
		}
		// verifica daca are exact un 1, mai inteligent decat for de sus
		//if((marker &(marker - 1)) == 0)
		return true;
	//	return false;
	}
}