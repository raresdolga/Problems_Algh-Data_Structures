package e4_Ch8;

import java.util.ArrayList;

public class AllSubsets {
	
	private ArrayList<Integer> subsets(ArrayList<Integer> set){
		int n = set.size();
		ArrayList<Integer> partial;
		if(n == 0){
			partial = new ArrayList<>();
			partial.add(0);
			return partial;
		}
		
		set.remove(n - 1);
		partial = subsets(set);
		ArrayList<Integer> temp = new ArrayList<>();
		int val = 1 << (n - 1);
		for(int elem : partial){
			elem |= val;
			temp.add(elem);
		}
		partial.addAll(temp);
		return partial;
	}
	public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> set){
		int n = set.size();
		ArrayList<ArrayList<Integer>> partial;
		if(n == 0){
			partial = new ArrayList<>();
			
			partial.add(new ArrayList<Integer>());
			return partial;
		}
		
		int val = set.get(n - 1);
		set.remove(n - 1);
		partial = subsets2(set);
		ArrayList<Integer> temp;
		 ArrayList<ArrayList<Integer>> aux = new  ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subset : partial){
			temp = new ArrayList<>(subset);
			temp.add(val);
			aux.add(temp);
		}
		partial.addAll(aux);
		return partial;
	}
	
	private ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set){
		ArrayList<Integer> binSubsets = subsets(set);
		int val,k;
		System.out.println("gata");
		ArrayList<Integer> a;
		ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
		for(int i = 0; i < binSubsets.size(); i++){
			val = binSubsets.get(i);
		    a = new ArrayList<>();
			for(k = 31; k >= 0; k --)
				if((val & (1 << k)) == 1)
					a.add(set.get(k));
			subset.add(a);
		}
		
		return subset;
	}
	
	public ArrayList<ArrayList<Integer>> setOfSets(ArrayList<Integer> set){
		if(set.size() > 32){
			System.out.println("to many elements for finding subset/ memory exceeds");
			return null;
		}
		// if less than 32 elements add null;
		for(int i = set.size() - 1; i < 32; i++){
			set.add(null);
		}
		return findSubsets(set);
	}
	public void display(ArrayList<ArrayList<Integer>> a){
		for(ArrayList<Integer> b : a){
			for(Integer elem : b){
				if(elem != null){
					System.out.print(elem + " ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		AllSubsets a = new AllSubsets();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		a.display(a.subsets2(arr));
	}

}
