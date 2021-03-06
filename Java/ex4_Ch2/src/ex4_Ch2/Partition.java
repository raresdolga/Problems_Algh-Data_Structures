package ex4_Ch2;

import java.util.Scanner;
public class Partition {
	private Node<Integer> reorganize(Node<Integer> head, int partition){
		Node<Integer> current = head;
		// used when insert before head
		Node<Integer> headNew = new Node<Integer>(head.data);
		Node<Integer> lastElem = headNew;
		Node<Integer> aux;
		current = current.next;
		
		while(current != null){
			if(current.data >= partition){
			//insert at the end:
				lastElem.next = new Node<Integer>(current.data);
				lastElem = lastElem.next;
			}
			else {
				aux = new Node<Integer>(current.data);
				aux.next = headNew;
				headNew = aux;
			}
			current = current.next;
		}
		return headNew;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Node<Integer> head = new Node<Integer>(in.nextInt());
		Node<Integer> t = head;
		while(in.hasNextInt()){
			Node<Integer> aux = new Node<Integer>(in.nextInt());
			t.setNext(aux);
			t = aux;
		}
		
		in = new Scanner(System.in);
		int partition = in.nextInt();
		/*t = head;
		while(t != null){
			System.out.print(t.data + " ");
			t = t.next;
		}*/
		Partition obj = new Partition();
		
		head = obj.reorganize(head, partition);
		t = head;
		
		while(t != null){
			System.out.print(t.data + " ");
			t = t.next;
		}
	
	}
}
