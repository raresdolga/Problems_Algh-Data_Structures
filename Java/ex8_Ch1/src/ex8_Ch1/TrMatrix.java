package ex8_Ch1;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TrMatrix {

	private static int [][] zeroCol(int [][] a, int col){
		for(int i = 0; i< a.length; i++){
			a[i][col] = 0;
		}
		return a;
	}
	private static int [][] zeroRow(int [][] a, int row){
		for(int i = 0; i< a[0].length; i++){
			a[row][i] = 0;
		}
		return a;
	}
	private static void print (int [][] a){
		int i,j;
		int m = a.length;
		int n = a[0].length;
		for(i = 0; i < m; i++){
			for(j = 0; j < n; j++)
				System.out.print(a[i][j] +" ");
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int m = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			System.out.println(m + " "+ n);
			int j = 0;
			int i = 0;
			int [][] a = new int [m][n];
			for(i = 0; i < m; i++){
				String s = in.readLine();
				String [] c = s.split(" ");
				for(j = 0; j < n; j++){
					a[i][j] = Integer.parseInt(c[j]);
				}
			}
			boolean col = false;
			boolean row = false;
		
		for(i = 0; i <m; i++)
			if(a[i][0] == 0) {
				col = true;
				break;
			}
		for(i = 0; i <n; i++)
			if(a[0][i] == 0) {
				row = true;
				break;
			}
		
		for(j = 1; j < m; j++)
			for(i = 1; i < n; i++)
				if(a[i][j] == 0) {
					a[i][0] = 0;
					a[0][j] = 0;
				}
		for(i = 1; i <n; i++)
			if(a[0][i] == 0) {
				a = zeroCol(a,i);
			}
		for(i = 1; i <m; i++)
			if(a[i][0] == 0) {
				a = zeroRow(a,i);
			}
		if(col)
			a = zeroCol(a,0);
		if(row)
			a = zeroRow(a,0);
		print(a);
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}

}
