package ex5_Ch2;

import java.util.Scanner;

public class Add_Lists {
	private int add(Node<Integer> p1, Node<Integer> p2){
		Node<Integer> currentL1 = p1;
		Node <Integer> currentL2 = p2;
		int nr = 0;
		int r = 0;
		int p = 1;
		int lastdig;
		
		while(currentL1 != null && currentL2 != null){
			lastdig = currentL1.data + currentL2.data + r;	
			nr = (lastdig%10)*p + nr;
			p *= 10;
			r = lastdig/10;
			currentL1 = currentL1.next;
			currentL2 = currentL2.next;
		}
		while(currentL1 != null ){
			lastdig = currentL1.data + r;	
			nr = (lastdig%10)*p + nr;
			p *= 10;
			r = lastdig/10;
			currentL1 = currentL1.next;
		}
		
		while(currentL2 != null ){
			lastdig = currentL2.data + r;	
			nr = (lastdig%10)*p + nr;
			p *= 10;
			r = lastdig/10;
			currentL2 = currentL2.next;
		}
		nr = r*p + nr;
		return nr;
	}
	private int reverseAdd(Node<Integer> p1, Node<Integer> p2, int pow, int revPow){
		int partial;
		int p;
		
		if(p1 != null && p2 != null) {
			partial = reverseAdd(p1.next, p2.next,pow*10, revPow);
			p = partial  + (p1.data + p2.data)*(revPow/pow);
			return  p;
			//return partial/10 == 0 ? partial *10 +p : partial + p*10; 	
		}
		else
			if(p1 != null ) {
				partial = reverseAdd(p1.next, null,pow*10,revPow) ;
				
				p =  partial  + p1.data*(revPow/pow);
				return p;
				//return partial/10 == 0 ? partial *10 +p : partial + p*10; 	
			}
			else
				if(p2 != null){
					partial = reverseAdd(null,p2.next,pow*10, revPow);
					p =  partial  + p2.data *(revPow/pow);
					return p;
					//return partial/10 == 0 ? partial *10 +p : partial + p*10; 	
				}
				else
					return 0;
	}
	
	private static int maxLength(Node<Integer> p1, Node<Integer> p2){
		Node<Integer> currentL1 = p1;
		Node <Integer> currentL2 = p2;
		int nr1 =0, nr2 = 0;
		while(currentL1 != null && currentL2 != null){	
			currentL1 = currentL1.next;
			currentL2 = currentL2.next;
			nr1 ++;
			nr2 ++;
		}
		while(currentL1 != null ){
			nr1 ++;
			currentL1 = currentL1.next;
		}
		
		while(currentL2 != null ){
			nr2 ++;
			currentL2 = currentL2.next;
		}
		if(nr1 > nr2)
			return nr1;
		else
			return nr2;
	}
	public static void main(String[] args) {
		// TcODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		//List 1 represented by head1
		Node<Integer> head1 = new Node<Integer>(in.nextInt());
		Node<Integer> aux = head1 ;
		Node<Integer> t = null;
		while(in.hasNextInt()) {
			t = new Node<Integer>(in.nextInt());
			aux.next = t;
			aux = t;
		}
		
		in = new Scanner(System.in);
		// List 2 represented by head2
		Node<Integer> head2 = new Node<Integer>(in.nextInt());
		 aux = head2 ;
		 t = null;
		while(in.hasNextInt()) {
			t = new Node<Integer>(in.nextInt());
			aux.next = t;
			aux = t;
		}
		
		Add_Lists obj = new Add_Lists();
		int revPow = (int)Math.pow(10,maxLength(head1,head2) - 1);
		//System.out.println(revPow);
		System.out.println(obj.reverseAdd(head1, head2,1,revPow));
	}

}
