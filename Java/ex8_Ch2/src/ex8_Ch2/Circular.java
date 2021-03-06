package ex8_Ch2;

import java.util.Scanner;

public class Circular {
	
	private Node<Integer> isCircular(Node<Integer> head){
		Node<Integer> fast = head; // this moves 2 positions
		Node<Integer> slow = head;
		// fast will reach first to the end and restart if circular
		while(fast != null && fast.next != null ){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){
				break;
			}
		}	
		// there is math behind if we iterate from head with slow and meet point with fast
		// at the same ratio as at beginning we they will meet at the loop entry point
			
			if(fast == null  || fast.next == null)
				return null;
			slow = head;
			// we know that there will be an infinite loop
			while(slow != fast){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
	}
	
	//we must determine how many nodes are out of the cycle
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in  = new Scanner(System.in);
		Node<Integer> head = new Node<Integer>(in.nextInt());
		Node<Integer> aux = head;
		Node<Integer> t;
		
		while(in.hasNextInt()){
			t = new Node<Integer>(in.nextInt());
			aux.next = t;
			aux = t;
		}
		// Test Case, make it circular:
		//aux.next = head;
		Circular liC = new Circular();
		Node<Integer> res = liC.isCircular(head);
		if(res != null)
			System.out.println(res.data);
		else
			System.out.println("No cycle");
	}
}
