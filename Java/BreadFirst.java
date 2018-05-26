
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
public class BreadFirst{
	public static void main(String []args){
		Node startNode;
		BF(startNode);
	}
	
	public static void BF(Node node){
		Queue process = new LinkedList<Integer>();
		HashMap<Node, Boolean> vis = new HashMap<>();
		process.push(node);
		Node act;
		while(!process.isEmpty()){
			act = process.poll();
			List<Integer>neigh = act.neigh;
			for(int i = 0; i < neigh.size(); i++)
				if(vis.contains(neigh.get(i)) && !vis.get(neigh.get(i))){
					process.push(neigh.get(i));
					//do whatever you want with  the node here
					vis.put(neigh.get(i), true);
				}		
		}
	}
}