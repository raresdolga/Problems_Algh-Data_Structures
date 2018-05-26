import java.util.Scanner;

public class MergeSort{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = in.nextInt();
		}
		int[] sorted = mSort(nums, 0, nums.length - 1);
		for(int i = 0; i < sorted.length; i++){
			System.out.print(sorted[i] + " ");
		}
	}
	
	public static int[] mSort(int[] nums, int l , int r){
		if(l == r) return new int[]{nums[l]};
		int m = (l + r)/2;
		int [] A = mSort(nums, l , m);
		int [] B = mSort(nums, m + 1, r);
		int [] C = new int[r - l +  1];
		merge(A,B,C);
		return C;
	}		
	private static void merge(int[] A, int[] B, int[] C){
		int i = 0, j = 0, k = 0;
		while(i < A.length && j < B.length){
			if(A[i] < B[j])
				C[k++] = A[i++];
			else
				C[k++] = B[j++];
		}
		while(i < A.length){
			C[k] = A[i];
			k++;
			i++;
		}
		while( j < B.length){
			C[k] = B[j];
			k++;
			j++;
		}
	}
}