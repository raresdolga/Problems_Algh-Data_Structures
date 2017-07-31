package ex12_ch4;

public class Node {
	public Node left;
	public Node right;
	public int data;
	
	public Node(int data, Node right, Node left) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
}
