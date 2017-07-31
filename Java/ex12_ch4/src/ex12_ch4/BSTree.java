package ex12_ch4;

public class BSTree {
	public Node root = null;
 public void insertBS(int data){
		if(root == null)
			root = new Node(data,null,null);
		else
			insert(data);
	}
	
 	private void insert(int data) {
 		Node temp = root;
 		// root is not null as the method above takes care of that
 		Node par = root;
 		while(temp != null) {
 			par = temp;
 			if(data > temp.data)
 				temp = temp.right;
 			else
 				temp = temp.left;
 		}
 		
 		if(data > par.data) 
 				par.right = new Node(data,null,null);
 			else
 				par.left = new Node(data,null,null);	
 	}
 	
 	public void preOrder(Node root){
 		if (root == null)
 			return ;
 		System.out.println(root.data);
 		preOrder(root.left);
 	 	preOrder(root.right);
 	}
}
