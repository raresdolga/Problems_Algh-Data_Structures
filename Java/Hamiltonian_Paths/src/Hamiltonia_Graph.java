import java.util.ArrayList;
import java.util.Arrays;

public class Hamiltonia_Graph {
	
	public static boolean hP_path(int [][] adiacency, ArrayList<Integer> remain_nodes, Integer v){
		if(remain_nodes.size() == 1){
			return true;
			}
		boolean ans = false;
		remain_nodes.remove(v);
		int [][] copy = eliminate_edges(v,adiacency,remain_nodes);
		
		for(int n : remain_nodes ){
			if(adiacency[v][n] != 0)
				ans = ans || hP_path(copy,remain_nodes,n);
		}
		return ans;
	}
	
	private static int[][] eliminate_edges(Integer v, int [][] adj,ArrayList<Integer>remain_nodes){
		int [][] copy = new int [adj.length][adj.length];
		int i, j;
		for(i = 0; i < adj.length; i++){
				copy[i] = Arrays.copyOf(adj[i], adj.length);
		}
		for(int n : remain_nodes){
			copy[n][v] = copy[v][n] = 0;
		}
		return copy;
	}
	public static void main(String args[]){
		int n = 3;
		int [][] adiacency = {
				{0,1,1},
				{1,0,1},
				{1,1,0}
		};
		
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		for(Integer i = 0; i < n; i++)
			nodes.add(i);
		System.out.println(hP_path(adiacency,nodes,0));
	}
}
