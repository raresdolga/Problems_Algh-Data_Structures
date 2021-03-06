package ex8_Ch4;

public class Node {
	private Node left;
	private Node right;
	private int val;
	
	public Node(int val,Node right, Node left) {
		this.right = right;
		this.left = left;
		this.val = val;
	}
	
	public Node(Node t) {
		this.right = t.getRight();
		this.left = t.getLeft();
		this.val = t.getVal();
	}
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getRight(){
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}


}
