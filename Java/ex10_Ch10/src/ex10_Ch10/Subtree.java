package ex10_Ch10;

 //Time complexity: O(n +m*k) where m is the number of common values for the roots;
 //n,m are the number of nodes tree 1, tree2
public class Subtree {
	public void insertBS(Node root, int data) {
		Node temp = root;
		Node parent = temp;
		while(temp != null) {
			parent = temp;
			
			if(root.data > data)
				temp = temp.left;
			else
				temp = temp.right;
			}
			if(parent.data > data) 
				parent.left = new Node(data,null,null);
			else
				parent.right = new Node(data,null,null);
			//System.out.println(parent.data +" " + data + parent.right + " " + parent.left);
	 } 
	
	public boolean checkSubTree(Node root1, Node root2) {
		if(root1 == null) return false;
		if(root1.data == root2.data){
			if(checkRest(root1,root2))
					return true;
		}
		return checkSubTree(root1.left, root2) || checkSubTree(root1.right,root2);
	}
	
	public boolean checkRest(Node root1, Node root2){
		if(root2 == null && root1 == null) return true;
		else
			if(root2 == null || root1 == null)
				return false;
		System.out.println(root1.data );
		if(root1.data == root2.data)
			return checkRest(root1.left, root2.left) && checkRest(root1.right, root2.right);
		else
			return false;
	}
	
	public void preOrder(Node root){
		if(root == null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		Node root1 = new Node(27,null,null);
		Node root2 = new Node(21,null,null);
		Subtree obj = new Subtree();
		obj.insertBS(root1,34);
		obj.insertBS(root1, 21);
		obj.insertBS(root1, 25);
		obj.insertBS(root1, 26);
		
		obj.insertBS(root1, 10);
		obj.insertBS(root2, 25);
		obj.insertBS(root2, 26);
		obj.insertBS(root2, 10);
		obj.preOrder(root1);
	 System.out.println(obj.checkSubTree(root1, root2));
		/* A better approach would be to traverse in preOrder both trees and put nodes in a string. 
		 * However some strings might be identical but the tree structure might be different
		 * A fix is to put a special character 'X' instead of null and use pre-order not in-order or post order
		 * This approach has O(n +m) time */
		
	}

}
