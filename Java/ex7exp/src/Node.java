

import java.util.ArrayList;

public class Node<T extends Comparable<T>> {
	protected ArrayList<Node<T>> neigh;
	private int inbound = 0;
	private final T val;
	
	public Node( ArrayList<Node<T>> neigh, T val) {
		this.neigh = neigh;
		this.val = val;
	}
	
	public int getInbound() {
		return inbound;
	}
	
	public void incrementInbound() {
		this.inbound++;
	}
	
	public void decrementInbound() {
		this.inbound--;
	}
	
	public T getVal() {
		return val;
	}
}

