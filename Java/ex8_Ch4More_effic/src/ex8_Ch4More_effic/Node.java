package ex8_Ch4More_effic;

public class Node {
	public Node left;
	public Node right;
	public int val;
	
	public Node(int val, Node right, Node left){
		this.val = val;
		this.right = right;
		this.left = left;
	}
}
