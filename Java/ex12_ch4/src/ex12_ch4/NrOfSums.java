package ex12_ch4;

import java.util.HashMap;

public class NrOfSums {
	
	public int getTotalPaths(BSTree t, int targetSum){
		HashMap<Integer, Integer> apparitions = new HashMap<>();
		return  getTotalPaths(t.root,apparitions,targetSum,0);
		}
	
	public int getTotalPaths(Node root,HashMap<Integer,Integer> appar, int targetSum, int partialSum){
		if(root == null) return 0;
		// this partial sum holds the previous calculated sum if it exists
		int sum = partialSum + root.data;
		// get or default returns value if key exists or the default value otherwise
		int total = appar.getOrDefault(sum - targetSum, 0);
		
		if(sum == targetSum)
			total = total + 1;
		//increase the apparitions of previous sum by one
		appar.put(sum, appar.getOrDefault(sum,0) + 1);
		total += getTotalPaths(root.left,appar,targetSum,sum);
		total += getTotalPaths(root.right,appar,targetSum,sum);
		// put the old value for key sum back to initial, as we go up to the tree, as calls ended and this node
		// does not count anymore
		appar.put(sum, appar.get(sum) - 1);
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree t = new BSTree();
		NrOfSums s = new NrOfSums();
		t.insertBS(5);
		t.insertBS(7);
		t.insertBS(67);
		t.insertBS(23);
		t.insertBS(12);
		t.insertBS(3);
		t.insertBS(4);
		int res = s.getTotalPaths(t, 12);
		//t.preOrder(t.root);
		System.out.println(res);
	}

}
