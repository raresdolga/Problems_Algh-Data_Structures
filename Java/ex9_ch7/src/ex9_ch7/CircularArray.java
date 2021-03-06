package ex9_ch7;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
public class CircularArray<T extends Comparable<T>> implements Iterable<T>{
	private int size;
	private T[] arr;
	//head indicates to the first element
	private int head = -1;
	private int last = -1;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size){
		this.size = size;
		//cannot directly instantiate  from T type
		arr = (T[]) new Comparable[size];
	}
	
	public CircularArray(T[] arr){
		this.arr = arr;
		this.size = arr.length;
	}
	
	@Override
	public Iterator<T> iterator(){
		return new IteratorCA();
	}
	
	public int size(){
		return size;
	}
	
	
	public void insert(T a){
		if(head == -1){
			last = head = 0;
			arr[last] = a;
		}
		else {
			last ++;
			arr[last] = a;
		}
	}
	
	public void rotate(){
		head += 1;
		if(head >= last)
			head %= last;
	}

	private  class IteratorCA implements Iterator<T>{
		private int index;
		
		public IteratorCA(){
			index = head;
		}
		
		@Override
		public boolean hasNext(){
			if(index < last + head)
				return true;
			return false;
		}
		
		@Override
		public T next(){
			if(this.hasNext())
				return arr[index];
			else
				throw new ArrayIndexOutOfBoundsException();
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	public static void main(String [] args){
		//Test iterator
				HashMap<Integer,Integer> mp = new HashMap<>();
				mp.put(3, 6);
				mp.put(9, 8);
				Iterator<Integer> it = mp.values().iterator();
				while(it.hasNext()){
					int val = it.next();
					System.out.println(val);
				}
				CircularArray<Integer> a = new CircularArray<>(7);
	}
}
