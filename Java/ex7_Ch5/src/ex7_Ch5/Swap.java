package ex7_Ch5;

public class Swap {
	
	public static int swap(int n) {
		//0xaaaaaa = 1010101010
		//0x555555 = 0101010101
		// we move left with one and right with one than combine numbers
		return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x5555555) << 1);
	}

	public static void afis(int n) {
		for(int i = 31; i >= 0; i--){
			System.out.print((n & (1 << i)) == 0 ? 0 + " " : 1 + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap.afis(5);
		Swap.afis(Swap.swap(5));	
	}

}
