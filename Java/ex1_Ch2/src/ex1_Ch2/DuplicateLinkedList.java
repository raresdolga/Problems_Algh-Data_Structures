package ex1_Ch2;
/*
 * This is a naive solution that takes O(n^2) time complexity
 * It iterates the intire list for all elements
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DuplicateLinkedList<T extends Comparable<T>> {
	// Use Integer instead of primitive int, for using Comparable interface
	private boolean check(LinkedList<T> list, T val){
		Iterator<T> it = list.iterator();
	int ok = 0;
		while(it.hasNext()){
			T elem = it.next();
			if(elem.compareTo(val) == 0){
				ok ++;
			}
		}
		if(ok > 1)
			return false;
		else
			return true;
	}
	private LinkedList<T> singleAppear(LinkedList<T> old){
		Iterator<T> it = old.iterator();
		LinkedList<T> coppy = new LinkedList<T>(old);
		LinkedList<T> newList = new LinkedList<T>();
		while(it.hasNext()){
			T current = it.next();
			//System.out.println(current);
			if(check(coppy, current)){
				newList.add(current);
			}
		}
		return new LinkedList<T>(newList);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		try{
			Scanner in = new Scanner(System.in);
			while(in.hasNextInt()){
				list.add(in.nextInt());
			}
			DuplicateLinkedList<Integer> obj = new DuplicateLinkedList<Integer>();
			LinkedList<Integer> result = obj.singleAppear(list);
			Iterator<Integer> it1 = result.iterator();

			while(it1.hasNext()){
			
				System.out.println(it1.next());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
