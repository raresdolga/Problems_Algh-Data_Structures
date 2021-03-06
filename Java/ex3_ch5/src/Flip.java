public class Flip {
	public int getMaxLength(int n){
		int max = 0;
		int prevL = 0;
		int current = 0;
		while(n != 0){
			System.out.println(n);
			if((n  & 1) == 0) {
				if( current + prevL > max)
					max =  current + prevL;
				if((n  & 2) == 1) {
					prevL = current;
					current = 0;
				}
				else {
					// cannot add this sequence to the next one
					prevL = 0;
					current = 0;
				}
			}
			else
				current += 1;
			//>>> does not preserve the sign just  move on
			n = n >>> 1;
		}
		return max;
	}
	
	public void afis(int n) {
		int mask;
		for(int i = 31; i >= 0; i--){
			mask = 1 << i;
			System.out.print(((mask & n) == 0 ? 0 : 1) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flip obj = new Flip();
		obj.afis(1775);
		//System.out.println("lenh:"+obj.getMaxLength( 1775));
		obj.afis( -1775 >> 1);
		obj.afis( -1775 >> 2);
		
	}

}
