package ex4_ch5;
public class SmallestLargest {
	
	public int getBigger(int n) {
		int c = n;
		int c0 =0;
		int c1 = 0;
		while(((c & 1) == 0) && (c != 0)) {
			//c & 1 is checking last bit of c to see if == 0 then it is 0 else it is 1
			// count nr of 0 until the first one
			c = c >> 1;
			c0 ++;
		}
		//count nr of 1 after the first non-terminal 0 (right to left)
		while( (c & 1) == 1 && (c != 0) && c1 < 32) {
			c1 ++;
			// put on the right the value of the
			c = c >> 1;
		}
		int pos = c1 + c0;
		// the nr is 111000 or 111111 = ~0 or 0 then there is no bigger nr with the same nr of ones
		if(pos == 0 || pos >= 31)
			return -1;
		//flip first non terminal 0
		n = n | (1 << pos);
		//clear right of pos;
		int a = 1 << pos;
		// transform just right part in ones
		int b = a - 1;
		// make right of pos just  bits
		 n = n &(~b);
		 //put c1 -1 ones at the end as we already put a 1 at pos position
		 int mask = 1 << (c1 - 1) - 1;
		 n |= mask;
		 return n; 
	}
	
	public int getPrev(int n) {
		int c = 0;
		int c1 = 0;
		int c0 = 0;
		// go until meet first 0 ( count lasts ones)
		while((c | 0) == 1 && c != 0 & c1 < 32) {
			c1 ++;
			// >> preservs the sign bit
			c >>= 1;
		}
		// count nr of right (last) zeros before meet "1" -bit 
		while((c | 0) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}
		int pos = c1 + c0;
		if(pos == 0 || pos >= 31){
			return -1;
		}
		n = n & ~(1 << pos);
		int a = 1 << (pos - 1);
		int b = a - 1;
		n = n & (~b);
		int mask = (1 << (c1 + 1)) - 1;
		mask <<= (c0 - 1);
		return n | mask;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestLargest obj = new SmallestLargest();
		System.out.println(obj.getBigger(-1));
	}

}
