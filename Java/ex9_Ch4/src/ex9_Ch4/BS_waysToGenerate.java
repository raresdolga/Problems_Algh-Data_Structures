package ex9_Ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BS_waysToGenerate {
public void insertBS(NodeBS root, int data) {
	NodeBS temp = root;
	NodeBS parent = temp;
	while(temp != null) {
		parent = temp;
		if(root.val > data)
			temp = temp.left;
		else
			temp = temp.right;
		}
		if(parent.val > data) 
			parent.left = new NodeBS(data,null,null);
		else
			parent.right = new NodeBS(data,null,null);
 } 
	
	public ArrayList<LinkedList<Integer>> generate(NodeBS root) {
		if(root == null) return new ArrayList<LinkedList<Integer>>();
		//System.out.println("intra");
		ArrayList<LinkedList<Integer>>  total = new ArrayList<LinkedList<Integer>>();
		ArrayList<LinkedList<Integer>>  partial;
		ArrayList<LinkedList<Integer>> waysL = generate(root.left);
		ArrayList<LinkedList<Integer>> waysR = generate(root.right);
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.addFirst(root.val);
	
		for(LinkedList<Integer> l : waysL) {
			for(LinkedList<Integer> r : waysR) {
				
			   partial = new ArrayList<LinkedList<Integer>>();
				combine(l,r,partial,prefix);
				total.addAll(partial);
			}
		}
		return total;
	}
	
	public void combine(LinkedList<Integer> waysL, LinkedList<Integer> waysR, ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix){
		if(waysL.size() == 0 || waysR.size() == 0) {
			LinkedList<Integer> temp = (LinkedList<Integer>) prefix.clone();
			results.add(waysL);
			results.add(waysR);
			results.add(temp);
		}
		
		//remove the head of the first list and create combinations with it
		Integer a = waysL.removeFirst();
		prefix.addLast(a);
		combine(waysL,waysR,results,prefix);
		//re-adjust to initial after the call for feature calls i.e waysR calls
		prefix.removeLast();
		waysL.addFirst(a);
		
		//remove head from the second list with the prefix and waysL updated 
		Integer b = waysR.removeFirst();
		prefix.addLast(b);
		combine(waysL,waysR,results,prefix);
		//re-adjust to initial after the call for feature calls i.e waysL calls on the stack
		prefix.removeLast();
		waysR.addFirst(b);;
	}
	
	public void BFS_generate(LinkedList<NodeBS> children,ArrayList<ArrayList<Integer>> result){
		LinkedList<NodeBS> a = new LinkedList<NodeBS>();
		ArrayList<Integer> toPer = new ArrayList <Integer>();
		while(!children.isEmpty()) {
			NodeBS pop = children.removeFirst();
			if(pop.left != null){
				toPer.add(pop.left.val);
				a.push(pop.left);
			}
			if(pop.right != null) {
				toPer.add(pop.right.val);
				a.push(pop.right);
			}
			ArrayList<ArrayList<Integer>> rez = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> new_rez = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp;
			combineOne(rez,toPer,0);
			for(ArrayList<Integer> fst : result) {
				temp = new ArrayList<Integer>();
				for(ArrayList<Integer> scd : rez) {
					//new_rez.addAll(c)
					temp.addAll(fst);
					temp.addAll(scd);
				}
				new_rez.add(temp);
			}
			BFS_generate(a,result);
		}
		
	}

	public void combineOne(ArrayList<ArrayList<Integer>> rez,ArrayList<Integer> set, int k){
		if(k == set.size()) {
			rez.add(set);
		}
		int temp;
		for(int i = k; i < set.size(); i++){
			temp = set.get(i);
			set.add(i, set.get(k));
			set.add(k, temp);
			combineOne(rez,set,k +1);
			// re arrange the array
			temp = set.get(i);
			set.add(i, set.get(k));
			set.add(k, temp);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeBS root = new NodeBS(5,null,null);
		BS_waysToGenerate obj = new BS_waysToGenerate();
		obj.insertBS(root, 45);
		obj.insertBS(root, 13);
		ArrayList<LinkedList<Integer>> result =  obj.generate(root); // new ArrayList<ArrayList<Integer>>();
		
		
		for(LinkedList<Integer> a : result){
			System.out.println();
			for(Integer b : a){
				System.out.println(b + " ");
			}
		}
	}

}
