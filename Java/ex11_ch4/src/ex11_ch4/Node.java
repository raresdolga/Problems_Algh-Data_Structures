package ex11_ch4;

public class Node {
	public Node left;
	public Node right;
	public int data;
	
	public int size = 0;
	public Node(int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
		size = 1;
	}
	public Node getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size;
		if(i < leftSize) {
			return left.getIthNode(i);
		}
		else
			if(i == leftSize) {
				return this;
			}
			else
				return right.getIthNode(i - (leftSize - 1));
	}
	
}
