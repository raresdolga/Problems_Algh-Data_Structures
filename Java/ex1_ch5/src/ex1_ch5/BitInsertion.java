package ex1_ch5;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BitInsertion {
	//when we count position we start from left to right not from right as normal
	
	public int updateBit(int n, int pos, int val) {
		//val must be 0 or 1 = 000...0 (32 digits) or 000...1(32 digits) so we can shift by pos <= 32
		int mask = ~(1 << pos);
		// first free the position of val by using 0
		return (mask & n) | (val << pos);
		
	}
	
	public int getBit(int n, int pos) {
		int mask = 1 << pos;
		//we make a num with 1 just on pos rest is 0, depending on the pos bit we obtain nr 1 or 0
		return (n & mask) != 0 ? 1 : 0;
	}
	
	public int InsertInt(int a, int b, int pos1, int pos2) {
		/*insert b in a
		b has 32 bits but first of them are 0 and the actual number's length <= pos2 - pos1 + 1
		So we can safely shift be to left by pos2  
		 */
		//b = b << pos2;
		int val;
		for(int count = pos2; count >= pos1; count-- ){
		   val = getBit(b,count);
			a = updateBit(a,count,val);
		}
		return a;
	}
	
	public int updateBetween(int pos1, int pos2, int n, int m) {
		int part1, part2;
		part1 = part2 = n;
		int ones = ~0; 
		//make 0 from i to 0, then from j to i
		// pos2 near to right and pos1 near to left
		int mask2 = ones << (pos2 +1);
		// the right part
		int mask1 = ((1<< pos1) - 1);
		
		int mask = mask1 | mask2;
		m = m << pos1;
		n = n & mask;
		return n | m;
	}
	
	void afisBit(int n){
		int i, mask;
		//start from the right
		for(i = 31; i >= 0; i--){
			mask = 1 << i;
			System.out.print( ((n & mask) != 0 ? 1 : 0) + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitInsertion obj = new BitInsertion();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		obj.afisBit(n);
		obj.afisBit(m);
		obj.afisBit(obj.updateBetween(2, 6, n, m));
		
	}

}
