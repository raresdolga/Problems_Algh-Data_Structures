package ex11_ch4;

import java.util.Random;

public class Rabdom {
	Node root = null;
	public int size1(){
		return root == null ? 0 : root.size;
	}
	public Node getRandom() {
		if(root == null) return null;
		
		Random rnd = new Random();
		int i = rnd.nextInt(size1());
		return root.getIthNode(i);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
