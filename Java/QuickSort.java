import java.util.Scanner;

import java.util.Scanner;

public class QuickSort{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = in.nextInt();
		}
		quickSort(nums, 0, nums.length - 1);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void quickSort(int[] nums, int l , int r){
		if(l >= r) return;
		int piv = pivot(nums, l, r);
		quickSort(nums, l, piv);
		quickSort(nums, piv + 1, r);
	}		
	private static int  pivot(int[] A, int l, int r){
		int p = l + 1;
		for(int k = l + 1; k <= r; k++){
			if(A[k] < A[l]){
				swap(A, p, k);
				p++;
			}	
		}
		p--;
		swap(A, l, p);
		return p;
	}
	private static void swap(int [] arr, int i, int j){
		int aux = arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}
}