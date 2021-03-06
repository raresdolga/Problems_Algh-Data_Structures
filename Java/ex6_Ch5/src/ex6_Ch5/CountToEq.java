package ex6_Ch5;

public class CountToEq {
	
	public int seeCount(int nr1, int nr2){
		int count = 0;
		//^ is XOR operation
		int nr = nr1^nr2;
		//count the number of ones in the sequence
		while(nr != 0) {
			if((nr & 1) == 1)
				count++;
			nr >>>= 1;
		}
		return count;
	}
	//faster method on the same idea
	public int seeCount2(int nr1,int nr2){
		int count = 0;
		// if we do nr &(nr -1) and go untill nr is 0 we count the digits that are equal to one 
		for(int nr = nr1 ^nr2; nr != 0; nr = nr &(nr -1))
			count ++;
		return count;
	}
	
	public void afiBin(int nr){
		for(int i = 31; i >= 0; i --){
			if((nr & (1 << i)) == 0)
				System.out.print("0 ");
			else
				System.out.print("1 ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountToEq obj = new CountToEq();
		obj.afiBin(5);
		obj.afiBin(6);
		System.out.println(obj.seeCount(5,6));

	}

}
