package ex3_Ch2;
 public class Node<E>{
	 public Node<E> next,prev,last;
	 public E data ;
	 public Node( E data, Node <E> n, Node<E> p){
		 this.setNext(n);
		 this.setPrev(p);
		 this.data = data;
	 }
	 
	 public Node(E d){
		 data = d;
		 next = null;
		 prev = null;
		 last = null;
	 }
	 
	 public void setNext(Node<E> n){
		 next = n;
		 if(this == last){
			 last = n;
		 }
		 // check if not head
		 if(n != null && n.prev != this){
			 n.setPrev(this);
		 }
	 }
	 
	 public void setPrev(Node<E> m){
		 prev = m;
		 if(m != null && m.next != this)
			 m.setNext(this);
	 }
	
	 public Node<E> clone(){
		 Node<E> next2 = null;
		 if(this.next != null){
		//get the last element and copy form the last one 
			 next2 = next.clone();
		 }
		 Node<E> head = new Node<E>(data,next2,null);
		 return head;
	 }
	 
	 
 }
