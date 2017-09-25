import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;
public class Page<E extends Comparable<E>>{
  public ArrayList<Key<E>> values;

  public Node( ArrayList<Node<E>> values){
    this.values = values;
  }

  public Node(){
    this.values = null;
  }
}
