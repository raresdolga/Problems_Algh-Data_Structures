

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T extends Comparable<T>> {
	private HashMap<T, Node<T>> nodes;
	
	public Graph() {
		
		nodes = new HashMap<T,Node<T>>();
	}
	
	public void addNode(Node<T> n) {
		//nodes.add(n);
		nodes.put(n.getVal(), n);
	}
	
	
	public ArrayList<Node<T>> getNodes() {
		ArrayList<Node<T>> nodesA = new ArrayList<Node<T>>();
		for(T key : nodes.keySet())
			nodesA.add(nodes.get(key));
		return nodesA;
	}
	
	public void setIncomming(){
		ArrayList<Node<T>> children;
		Node<T> child;
		for(T c : nodes.keySet()){
			child = nodes.get(c);
			children = child.neigh;
			for(Node<T> node : children) {
				// reuse of child variable
				node.incrementInbound();
			}
		}
	}
	
	public Queue<Node<T>> getNoIncomming_Nodes(HashMap<Node<T>,Boolean> visited) {
		Queue<Node<T>> noInc = new  LinkedList<Node<T>> ();
		Node<T> child;
		for(T c : nodes.keySet()){
			child = nodes.get(c);
			if(child.getInbound() == 0 && !visited.get(child))
				noInc.add(child);
		}
		return noInc;
	}
	
	//as we have an array list of nodes for neighbours we need to keep track when adding a new neighbour of the existing node
	// or if creating a new list of neigh. each time for each new node, we end up with no bounds
	public Node<T>findByVal (T val) {
		// create a new node if it does not already exist
		Node<T> temp = nodes.get(val);
		if( temp != null)
			return temp;
		else {
			temp = new Node<T>(new ArrayList<Node<T>>(),val);
			nodes.put(val, temp);
			return temp;
		}
			
	}
}
