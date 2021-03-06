package ex8_Ch4;

public class Common_Ancestor {
	private Node root ;
	
	public Common_Ancestor(int val) {	
		root = new Node(val,null,null); 
	}
	
	public Node insert( int val, int branch){
		Node t = new Node(val,null,null);
		// properties of root do note change as we do not modify the current object, we just overwrite the variable
		// with another reference
		//current.setVal(8); would modify the root as well
		Node current = root;
		while(current.getLeft() != null && current.getRight() != null) {
			if(branch == 0)
				current = current.getLeft();
			else
				current = current.getRight();
		//	branch = (int) ((branch + Math.random()*1)%2);
			branch = (branch + 1) %2;
		}
		if(branch%2 == 0 && current.getLeft() == null)
			current.setLeft(t);
		else
			current.setRight(t);
		return t;
	}
	
	public void preOrder(Node t){
		if(t != null) {
			System.out.println(t.getVal());
			preOrder(t.getLeft());
			preOrder(t.getRight());
		}
	}
	
	public Node findCommon_Ancestor(Node rot,Node p, Node q){
		Result rez = new Result();
		 AncHelp(rot.getLeft(),p,q,rez);
		if(rez.node1 != null && rez.node2 != null){
			return findCommon_Ancestor(rot.getLeft(),p,q);
		}
		else if(rez.node1 != null || rez.node2 != null){
			return rot;
		}
		else { 
				
				AncHelp(rot.getRight(),p,q,rez);
				if(rez.node1 != null && rez.node2 != null){
					return findCommon_Ancestor(rot.getRight(),p,q);
				}
				else if(rez.node1 != null || rez.node2 != null){
					return rot;
				}
				
		}
		return null;
	}
	
	public void AncHelp(Node rot, Node p, Node q,Result rez) {
		if(rot == null) return ;
		if(rot == p) {
			rez.node1 = p;
			if(rez.node2 != null)
				return ;
		}
		if(rot == q) {
			rez.node2 = q;
			if(rez.node1 != null)
				return ;
		}
	 AncHelp(rot.getLeft(), q, p,rez);
	 AncHelp(rot.getRight(),q,p,rez);
		
	}
	
	public static void main(String [] args) {
		Common_Ancestor obj = new Common_Ancestor(5);
		obj.insert(7, 0);
		obj.insert(90, 0);
		Node p =  obj.insert(45,1);
		Node q = obj.insert(17, 1);
		 obj.insert(12, 1);
		//obj.preOrder(obj.root);
		System.out.println(obj.findCommon_Ancestor(obj.root, p, q).getVal());
	}
}
