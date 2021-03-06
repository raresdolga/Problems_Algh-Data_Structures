package ex7_Ch4;

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
			ArrayList<Character> neigh = new ArrayList<Character>();
			
			String s = in.nextLine();
			if(!s.equals("NULL")){
				String [] c =  s.split(" ");
				Character temp;
				for(count = 0; count < c.length; count++) {
					 temp = new Character(c[count].charAt(0));
					 neigh.add(temp);
				}
			}
			
			Node<Character> node = new Node<Character>(neigh);
			g.addNode(d,node);
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
		HashMap<Character, Node<Character>> ed = g.getNodes();
		for(Character key : ed.keySet()){
			System.out.print(key + ":");
			ArrayList<Character> neigh = ed.get(key).neigh;
			for(Character node : neigh) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}

	public void top_sort(){
		HashMap<Character,Node<Character>> map = g.getNodes();
		HashMap <Character,Boolean> visited = new HashMap<>();
		//initialise visited
		for(Character key : map.keySet()){
			visited.put(key, false);
		}
		
		Queue<Character> noInNodes = g.getNoIncomming_Nodes(visited);
		ArrayList<Character> children;
		Node<Character> aux;
		Node<Character> temp;
		Character c;
		Character value;
		int i;
		if(noInNodes.isEmpty()) System.out.println("topoloical sort cannot be done with thid graph");
		while(!noInNodes.isEmpty()) {
			value = noInNodes.poll();
		    temp = map.get(value);
			children = temp.neigh;
			visited.put(value, true);
			for( i = 0; i < children.size(); i++){
				 c = children.get(i);
				aux = map.get(c);
				aux.decrementInbound();
				// this makes the for loop with children in getNoIncom values- faster
				aux.neigh.remove(value);
			}
			System.out.println(value + " ");
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
