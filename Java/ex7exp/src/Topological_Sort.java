

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Topological_Sort {
	private Graph<Character> g = new Graph<>();
	
	private void read() {
		File input = new File("D:\\Users\\Rares\\Documents\\Algorithm_Questions\\Java\\ex7_Ch4\\src\\input.txt");
		Scanner in;
		try {
			in = new Scanner(input);
			
		int nr_nodes = in.nextInt();
		in.nextLine();
		int i = 0;
		int count;
		while(i < nr_nodes && in.hasNextLine()) {
			char a = in.nextLine().charAt(0);
			Character d = new Character(a);
			Node<Character> node = g.findByVal(d);
			Node<Character> aux;
			String s = in.nextLine();
			if(!s.equals("NULL")){
				String [] c =  s.split(" ");
				Character temp;
				for(count = 0; count < c.length; count++) {
					 temp = new Character(c[count].charAt(0));
					 aux = g.findByVal(temp);
					 node.neigh.add(aux);
				}
			}
	
			i++;
		}
		if(i < nr_nodes) System.out.println("the input is not enaugh");
		in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setIncomming();
	}
	
	private void afish() {
		ArrayList<Node<Character>> ed = g.getNodes();
		for(Node<Character> node : ed){
			System.out.print(node.getVal() + ":");
			ArrayList<Node<Character>> neigh = node.neigh;
			for(Node<Character> child : neigh) {
				System.out.print(child.getVal() + " ");
			}
			System.out.println();
		}
	}

	public void top_sort(){
		ArrayList<Node<Character>> map = g.getNodes();
		HashMap <Node<Character>,Boolean> visited = new HashMap<>();
		//initialise visited
		for(Node<Character> var : map){
			visited.put(var, false);
		}
		
		Queue<Node<Character>> noInNodes = g.getNoIncomming_Nodes(visited);
		ArrayList<Node<Character>> children;
		Node<Character> aux;
		Node<Character> temp;
		int i;
		if(noInNodes.isEmpty()) System.out.println("topoloical sort cannot be done with thid graph");
		while(!noInNodes.isEmpty()) {
			temp = noInNodes.poll();
			children = temp.neigh;
			visited.put(temp, true);
			for( i = 0; i < children.size(); i++){
				 aux = children.get(i);
				aux.decrementInbound();
				// this makes the for loop with children in getNoIncom values- faster
				aux.neigh.remove(aux);
			}
			System.out.println(temp.getVal() + " ");
			//add new nodes with no incoming edges
			noInNodes = g.getNoIncomming_Nodes(visited);
		}
	}
	public static void main(String args[]) {
		Topological_Sort obj = new Topological_Sort();
		obj.read();
		obj.top_sort();
		//obj.afish();
	}
}
