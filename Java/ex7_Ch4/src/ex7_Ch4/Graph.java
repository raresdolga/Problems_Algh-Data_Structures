package ex7_Ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T extends Comparable<T>> {
	private HashMap<T,Node<T>> nodes;
	
	public Graph() {
		nodes = new HashMap<>();
	}
	
	public void addNode(T key,Node<T> n) {
		nodes.put(key,n);
	}
	
	
	public HashMap<T,Node<T>> getNodes() {
		return new HashMap<T,Node<T>>(nodes);
	}
	
	public void setIncomming(){
		Node<T> child;
		ArrayList<T> children;
		for(T a : nodes.keySet()){
			child = nodes.get(a);
			children = child.neigh;
			for(T node : children) {
				// reuse of child variable
				child = nodes.get(node);
				child.incrementInbound();
			}
		}
	}
	
	public Queue<T> getNoIncomming_Nodes(HashMap<T,Boolean> visited) {
		Node<T> child ;
		Queue<T> noInc = new  LinkedList<T> ();
		for(T a : nodes.keySet()){
			child = nodes.get(a);
			if(child.getInbound() == 0 && !visited.get(a))
				noInc.add(a);
		}
		return noInc;
	}
}
