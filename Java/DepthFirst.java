
/*
// Assume this class
public class Node{
	public List<Integer> neigh;
	public int data;
	public  Node(int data, List<Integer> neigh){
		this.neigh = neigh;
		this.data = data;
	}	
}
*/
public class DepthFirst{
	public static void main(String []args){
		Node startNode;
		
		HashMap<Node,Boolean> visited =  new HashMap<>();
		DF(startNode, visited);
	}
	
	public static void DF(Node node, HashMap<Node,Boolean> [] vis){
		Stack<Integer> process = new Stack<>();
		process.push(node);
		Node act;
		vis.put(node, true);
		while(!process.isEmpty()){
			act = process.poll();
			List<Integer>neigh = act.neigh;
			for(int i = 0; i < neigh.size(); i++)
				if( vis.contains(neigh.get(i) && !vis.get(neigh.get(i))){
					process.push(neigh.get(i));
					//do whatever you want with  the node here
				}		
		}
	}
}