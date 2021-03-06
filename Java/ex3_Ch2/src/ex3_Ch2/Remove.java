package ex3_Ch2;

import java.util.Scanner;

public class Remove {

	private Node<Integer> nod ;
	
	private void remove(Node <Integer> n){
		if( n == null || n.next == null ){
			System.out.println("could not delete");
			return;
		}
		Node<Integer> aux = n.next;
	
		n.data = aux.data;
		//delete aux;
		n.next = aux.next;
	}
	
	private Node<Integer> getNodeByIndex(int i, Node<Integer> start){
		int count  = 1;
		Node<Integer> current = start;
		while(count < i && current != null){
			current = current.next;
			count ++;
		}
		return current;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		Node<Integer> head = new Node<Integer>(in.nextInt());
		/* insert at head :
		Node<Integer> t = null;
		*/
		// insert at the end:
		Node<Integer> t = head;
		int val;
		int count = 1;
		while(in.hasNextInt()){
			val = in.nextInt();
			/* insert at head :
			 t = new Node<Integer>(val,t,head);
			Insert at the end:
			t = new Node<Integer>(val,null,t);
			Doubly linked List*/
			//Simple Linked List:
			Node <Integer> aux  = new Node<Integer>(val);
			t.next = aux;
			t = aux;
			count ++;
		}
		/*Node<Integer> current = head;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}*/
		System.out.println("put a value to remove in range: " + 2 + " " + (count -2));
		// new scanner as we stoped the old one with a non int val
		in = new Scanner(System.in);
		int index = in.nextInt(); 
		if(index < 2 || index > count - 2){
			System.out.println("cannot remove element at" + index);
		}
		else {
		Remove obj = new Remove();
		Node <Integer> input = obj.getNodeByIndex(index, head);
		System.out.println("de exstras: " + input.data);
		
		obj.remove(input);
		}
		// print to the screen:
		Node<Integer> current = head;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

}
