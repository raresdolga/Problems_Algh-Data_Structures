package ex7_Ch2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.Mac;

public class Intersect {
	private static HashMap<Node<Integer>,Integer> createRoad(Node<Integer> head1, Node<Integer> head2){
		HashMap<Node<Integer>,Integer> common = new  HashMap<Node<Integer>, Integer>();
		Node<Integer> p1 = head1;
		Node<Integer> p2 = head2;
		while(p1 != null){
			common.put(p1, 0);
			p1 = p1.next;
		}
		
		while(p2 != null){
			common.put(p2, 1);
			p2 = p2.next;
		}
		return common;
	}
	
	private static Node<Integer> simpleCheck(Node <Integer> head1, Node<Integer> head2){
		// get 2 return values by class Ret : size & last node
		Ret<Integer> list1 = getListSize(head1);
		Ret<Integer> list2 = getListSize(head2);
	
		// if different last nodes, no need to continue clearly no node in common
		if(list1.tail != list2.tail)
			return null;
		
		Node<Integer> longest = list1.size < list2.size ? head2 : head1;
		Node<Integer> shortest = list1.size < list2.size ? head1 : head2;
		
		Node<Integer> newStart_longer = getKthNode(Math.abs(list1.size - list2.size), longest);
		
		// if a node is in common should return it;
		while(shortest != null && newStart_longer != null){
			if(shortest == newStart_longer)
				return shortest;
			shortest = shortest.next;
			newStart_longer = newStart_longer.next;
		}
		return null;
	}
	
	// get kth to the end
	private static Node<Integer> getKthNode(int k, Node<Integer> head) {
		Node<Integer> current = head;
		for(int i = 0; i < k; i++){
			current = current.next;
		}
		return current;
	}
	
	private static  Ret<Integer> getListSize(Node<Integer> list){
		
		if(list == null)
			return null;
		Node<Integer> current = list;
		int sz = 1;
		while(current.next != null){
			sz ++;
			current = current.next;
		}
		
		return new Ret<Integer>(current,sz);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Node<Integer> head1 = new Node<Integer>(in.nextInt());
		Node<Integer> aux = head1;
		Node<Integer> t;
		
		while(in.hasNextInt()){
			t = new Node<Integer>(in.nextInt());
			aux.next = t;
			aux = t;
		}
		in = new Scanner(System.in);
		Node<Integer> head2 = new Node<Integer>(in.nextInt());
		aux = head2;

		while(in.hasNextInt()){
			t = new Node<Integer>(in.nextInt());
			aux.next = t;
		    aux = t;
		}
		// Test Case, uncomment to see the other case:
		aux.next = head1;
		HashMap<Node<Integer>,Integer> test = createRoad( head1, head2);
		
		// now just iterate through the first list again and get the value of the hash map
	aux = head1;
		while(aux != null ){
			if(test.get(aux) == 1){
				System.out.println("Lists have at least one  common node");
				break;
			}
			aux = aux.next;
		}
		if(aux == null)
			System.out.println("Lists do not have common nodes");
	
		if(simpleCheck(head1,head2) != null)
			System.out.println("they have at least one common node");
		else
			System.out.println("they don`t have  common nodes");
	}

}
