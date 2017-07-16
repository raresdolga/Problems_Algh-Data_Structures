package ex6_Ch2;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome { 
	// assume you do not have the size
	private static  Node<Integer> current;
	private static boolean checkPalindrome(Node<Integer> list){
		boolean b = true;
		if(list != null ){
			b = checkPalindrome(list.next);
			System.out.println(current.data + " " + list.data);
			
			if(list.data.compareTo(current.data) != 0)
				return false;
			current = current.next;
		}
		
		return b;
	}
	//  Run length with 2 pointers p1 slow, p2 fast
	private boolean stackCheck(Node<Integer> head){
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;
		Stack <Integer> half = new Stack<Integer>();
		
		while(p2 != null && p2.next != null){
			half.push(p1.data);
			p1 = p1.next;
			p2 = p2.next.next;
		}
		// check for odd numbers
		if(p2 != null){
			p1 = p1.next; // skip middle
		}
		
		//should be the same size (half a stack and half of list)
		while(!half.isEmpty() && p1 != null){
			if(p1.data.compareTo(half.pop()) != 0)
				return false;
			p1 = p1.next;	
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Node<Integer> head = new Node<Integer>(in.nextInt());
		Node<Integer> aux = head;
		Node<Integer> now;
		while(in.hasNextInt()){
			now = new Node<Integer>(in.nextInt());
			aux.next = now;
			aux = now;
		}
		now = head;
		current = head;
		Palindrome obj = new Palindrome();
		System.out.println(obj.stackCheck(now));
		//System.out.println(checkPalindrome(now);
	}

}
