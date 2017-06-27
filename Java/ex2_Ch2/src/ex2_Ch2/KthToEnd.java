package ex2_Ch2;

public class KthToEnd {
private int retPos(Node<Integer> head, int k){
	int index;
	if(head == null)
	return 0;
	index = retPos(head,k) + 1;
	if(k == index)
		System.out.println(head.data);
	return index;
		
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
