package ex7_Ch4;

import java.util.ArrayList;

public class Node<T extends Comparable<T>> {
	protected ArrayList<T> neigh;
	private int inbound = 0;
	public Node( ArrayList<T> neigh) {
		this.neigh = neigh;
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
	
}

