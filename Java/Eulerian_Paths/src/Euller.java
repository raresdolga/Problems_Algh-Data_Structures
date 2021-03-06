import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Euller {
	/*static inner classes cannot access variables/methods, without creating an instance,
	from the class in which are contained(Euller in this case)
     simple inner classes(i.e without "static" can access directly (without having an instance) the variables/
	 methods of the container/outer class */
	private static class Edge{
	 	private int start_node;
	 	private int end_node;
	 	
	 	public Edge(int start_node, int end_node){
	 		this.start_node = start_node;
	 		this.end_node = end_node;
	 	}
	 	public int getStartNode(){
	 		return start_node;
	 	}
	 	public int getEndNode(){
	 		return end_node;
	 	}
	}
	private LinkedList<Integer> [] adj;
	private Graph g;
	public Euller(Graph g){
		this.g = g;
		adj = g.getAdjList();
	}
	public LinkedList<Edge> euler_Path(){
		
		LinkedList<Edge> path = new LinkedList<Edge>();
		int odd_nr = 0, odd_node = 0, even_nr = 0;
		for(int i = 0; i < g.getSize(); i++)
			if(adj[i].size() % 2 == 0){
				even_nr++;
			}
			else {
				odd_nr++;
				odd_node = i;
			}
		if(even_nr == g.getSize()){
			// start at the first node
			fleuryPath(0,path);
		}
		else
		{
			if(odd_nr == 2){
				fleuryPath(odd_node,path);
			}
			else
				return null;
		}
		return path;
	}
	
	private void fleuryPath(Integer node,LinkedList<Edge> path){
		Integer next = null;
		LinkedList<Integer>[] local = new LinkedList[g.getSize()];
		//  create a copy for isBridge or else problems with the iterator
		for(int i = 0; i < g.getSize(); i++)
			local[i] = new LinkedList<Integer>(adj[i]);
		
		Iterator<Integer> it = adj[node].iterator();
		int v;
		while(it.hasNext()){
			v = it.next();
			if(!isBridge(node,v,local)){
				next = v;
				break;
			}	
		}
		if(next == null){
			if(adj[node].size() != 0)
				next = adj[node].getFirst();
			else
				return ;
		}
		adj[node].remove(next);
		adj[next].remove(node);
		path.addLast(new Edge(node,next));
		fleuryPath(next,path);
	}
	
	private boolean isBridge(Integer n, Integer v, LinkedList<Integer>[] local ){
		
		local[n].remove(v);
		boolean[] visited = g.dFS(n,local);
		
		int i = 0;
		while( i < g.getSize() && (visited[i] || local[i].size() == 0)){
			i++;
		}
		//put the edge back for future iterations
		local[n].add(v);
		//if not all node visited
		if(i < g.getSize())
			return true;
		return false;
	}
	public static void runEulerian(Graph g){
		if(!g.isConnected())
			System.out.println("No Eulerian paths");
		else {
			Euller eP = new Euller(g);
			LinkedList<Edge> path = eP.euler_Path();
			if(path == null) {
				System.out.println("No Eulerian paths");
			}
			else
				for(Edge i : path)				
					System.out.println(i.getStartNode() +" "+ i.getEndNode());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(3);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		
		Graph g1 = new Graph(4);
		  g1.addEdge(0, 1);
		  g1.addEdge(0, 2);
		  g1.addEdge(1, 2);
		  g1.addEdge(2, 3);
		  
		 
		  Graph g2 = new Graph(3);
		  g2.addEdge(0, 1);
		  g2.addEdge(1, 2);
		  g2.addEdge(2, 0);
		 
		  Graph g3 = new Graph(5);
		  g3.addEdge(1, 0);
		  g3.addEdge(0, 2);
		  g3.addEdge(2, 1);
		  g3.addEdge(0, 3);
		  g3.addEdge(3, 4);
		  g3.addEdge(3, 2);
		  g3.addEdge(3, 1);
		  g3.addEdge(2, 4);
		  
		  runEulerian(g3);
		  
	}
}
