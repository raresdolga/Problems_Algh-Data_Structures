import java.util.TreeSet;
import java.util.Iterator;
import java.util.ArrayList;
public class Node<E extends Comparable<E>>{
  public ArrayList<Node<E>> children;
  public Node<E> parent;

  public TreeSet<E> values;
  public Node( ArrayList<Node<E>> children, TreeSet<E> values, Node<E> parent){
    this.children = children;
    this.values = values;
    this.parent = parent;
  }

  public Node(){
    this.children = null;
    this.values = null;
    this.parent = null;
  }

  public E getValue(int index) throws IndexOutOfBoundsException {
    Iterator<E> it = values.iterator();
    E value = null;
    if(it.hasNext())
      value = it.next();
    int pos = 0;
    while(it.hasNext() && pos < index ){
      value = it.next();
      pos++;
    }
    if(value == null)
      throw new IndexOutOfBoundsException();
    else
    return value;
  }
}
