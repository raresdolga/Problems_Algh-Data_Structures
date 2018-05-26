import java.util.Scanner;

public class ex3Ch1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		char[] s = new char[n + 1];
		String inp = in.nextLine();
		for(int i = 0; i < n; i++){
			s[i] = inp.charAt(i);
		}
		ex3Ch1 obj = new ex3Ch1();
		obj.codif(s,m);
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i]);
	}
	public void codif(char[] s, int n){
		int spaces = 0;
		for(int i = 0; i < n; i++)
			if(s[i] == ' ')
				spaces ++;
		int op;
		System.out.println(spaces);
		for(int i = n - 1; i >= 0; i--){
			op = i + spaces*2;
			if(s[i] == ' '){
				spaces --;
				op = i + spaces*2;
				s[op] = '%';
				s[op + 1] = '2';
				s[op + 2] = '0';
			}
			else
			s[op] = s[i];
		}
	}
}