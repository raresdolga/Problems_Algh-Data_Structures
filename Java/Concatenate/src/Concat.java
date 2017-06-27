import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Concat {
	private int count(int index, String s){
		int counter = 0;
		char c = s.charAt(index);
		while(index < s.length() && c == s.charAt(index)){
			counter ++;
			index ++;
		}
		return counter;
	}
	private StringBuilder construct(String s){
		StringBuilder b = new StringBuilder(s.length());
		int i = 0;
		int freq = 0;
		while(i < s.length()){
			freq = count(i, s);
			b.append(freq);
			b.append(s.charAt(i));
			i += freq;
		}
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		
		try {

			in = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while((s = in.readLine()) != null){
				Concat compress = new Concat();
				StringBuilder rez = compress.construct(s);
				if(rez.length() < s.length())
					System.out.println(rez.toString());
				else
					System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		

	}

}
