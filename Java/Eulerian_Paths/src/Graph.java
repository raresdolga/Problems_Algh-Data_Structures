import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer> []adj;
	private int nr_nodes;
	
	public Graph(int v){
		nr_nodes = v;
		adj = new LinkedList [nr_nodes];
		// initialize all linkedLists
		for(int i = 0; i < nr_nodes; i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int x, int y){
		adj[x].add(y);
		adj[y].add(x);
	}

	public boolean [] dFS(int v,LinkedList<Integer> [] local){
		boolean [] visited = new boolean[nr_nodes];
		for(int i = 0; i < nr_nodes; i++)
			visited[i] = false;
		dFS_helper(v, visited,local);
		// a weakly connected graph(undirected connected) will have all visited true;
		return visited;
	}
	
	private void dFS_helper(int v, boolean [] visited, LinkedList<Integer> [] local){
		visited[v] = true;
		Iterator<Integer> it = local[v].iterator();
		while(it.hasNext()){
			Integer node = it.next();
			if(!visited[node])
				dFS_helper(node,visited,local);
		}
	}
	
	public LinkedList<Integer> [] getAdjList(){
		return adj;
	}
	
	public int getSize(){
		return nr_nodes;
	}
	
	public boolean isConnected(){
		boolean[] visited = dFS(0,adj);
		int i = 0;
		while(i < nr_nodes && visited[i]){
			i++;
		}
		// not all nodes where visited => not connected as the while loop stops at visited[i] = false condition
		if(i < nr_nodes)
			return false;
		return true;
	}
}
