package ex8_Ch4More_effic;

public class Ancestor {
	
	public Result find_anc(Node root, Node a, Node b) {
		if(root == null) return new Result(null,false);
		if(root == a && root == b) 
			return new Result(root,true);
		Result p = find_anc(root.left,a,b);
		
		if(p.isNode) {
			//pass result from previous calls
			return p;
		}
		
	    Result q = find_anc(root.right,a,b);
	    if(q.isNode == true) {
	    	return q;
	    }
	    //still on the same side
	    if(p.anc != null && q.anc != null) {
	    	return new Result(root,true);
	    
	    } else if(a == root || b == root){
	    	//we are on one of looked nodes and we have not set it yet as ancestor
	    	//if the other node is in a subtree than return the ancestor
	    	boolean inAnc = (p.anc !=null || q.anc != null);
	    		return new Result(root,inAnc);
	    	
	    } else {
	    	if(p.anc != null)
	    		return new Result(p.anc,false);
	    	else
	    		return new Result(q.anc, false);
	    }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ancestor obj = new Ancestor();
		Node l = new Node(23,null,null);
		Node r = new Node(17,null,null);
		Node root = new Node(14,l,r);
		Result rez = obj.find_anc(root, l, r);
		System.out.println(rez.anc.val);
	}

}
