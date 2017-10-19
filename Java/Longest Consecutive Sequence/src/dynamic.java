import java.util.Scanner;
import java.util.HashMap;
public class dynamic {
 public int longestConsecutive(int[] nums) {	 
	 HashMap<Integer, Integer> map = new HashMap<>();
	 int numbers = 0;
	 int left = 0, right = 0;
	 for(int nr : nums){
		 if(!map.containsKey(nr)){
			 // we check for the left or right neighbours
			 if(map.containsKey(nr -1))
				 left = map.get(nr - 1);
			 if(map.containsKey(nr + 1))
				 right = map.get(nr + 1);
			 numbers += left + right;
			 map.put(nr, numbers + 1);
			 
			 numbers = 0;
		 }
	 }
	 return map.get(nums[nums.length - 1]);
	 
 }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i;
        int [] a = new int[n + 1];
        for(i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        dynamic test = new dynamic();
        System.out.println(test.longestConsecutive(a));
	}

}
