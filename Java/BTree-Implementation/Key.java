public class Key<E extends Comparable<E>> implements Comparable<Key<E>> {
  private E value;
  public Node<E> left;
  public Node<E> right;
  public Key(E value){
    left = null;
    right = null;
    this.value = value;
  }
  public E getValue(){
    return value;
  }

  public int compareTo(Key<E> e){
    return value.compareTo(e.getValue());
  }
}
