package ex7_Ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Rotate {
	private int [][] rot(int [][] a){
		int i = 0, j = 0;
		int n = a.length;
		int [][] c = new int [n][n];
		
		for(i = 0; i< n; i++){
			for(j = 0; j< n; j++)
				c[i][j] = a [n-j-1][i];
		}
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rotate obj = new Rotate();
		BufferedReader in = null;
		int [][] a;
		try{
			
			in = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(in.readLine());
			
			int i,j;
			a = new int[n][n];
			for(i = 0; i < n; i++){
				String line = in.readLine();
				String[] t = line.split(" ");
				for(j = 0; j< n; j++)
					{
					a[i][j] = Integer.parseInt(t[j]);
					}
			}
			a = obj.rot(a);
			for(i = 0; i < n; i++){
				for(j = 0; j< n; j++)
					{
					System.out.print(a[i][j] + "  ");
					}
				System.out.print( "\n");
			}
			
		 } catch (Exception e){
			e.printStackTrace(System.out);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage()+ "sdsd");
			}
		}
		
	}

}
