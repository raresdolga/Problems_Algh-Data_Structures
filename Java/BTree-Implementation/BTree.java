import java.util.TreeSet;
import java.util.Queue;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
/*
Use max 2n keys in one page and so 2n+1 max children
Use the rule to insert a value first and then break the node if more than 2n values
Assume all the values are different so that you can use a TreeSet
*/
public class BTree<E extends Comparable<E>> implements Iterable{
  // as it is not static the inner class knows the generic type of its parent
  private class Bt_Iterator implements Iterator{
    private Queue<Node<E>> nodes;
    public Bt_Iterator(){
      nodes = new LinkedList<>();
      //obtained values by dfs
      post_order(root);
      nodes.add(root);
    }
    private void post_order(Node<E> node){
      if(node == null)
        return;
      for(Node<E> child : node.children){
        post_order(child);
        nodes.add(child);
      }
    }
    public boolean hasNext(){
      return nodes.size() != 0;
    }
    public Node<E> next(){
      return nodes.poll();
    }
    public void remove(){
      throw new UnsupportedOperationException();
    }
  }
  private int order;
  private Node<E> root;
  public BTree(int order){
    this.order = order;
    root = new Node(new ArrayList<Node<E>>(), new TreeSet<Node<E>>(),null);
  }

  public Iterator<Node<E>> iterator(){
    return new Bt_Iterator();
  }

  public void insert(E val){
    Node<E> current = root;
    int pos;
    while(current.children.size() != 0){
      pos = 0;
      Iterator<E> it = current.values.iterator();
      while(it.hasNext() && val.compareTo(it.next()) > 0)
        pos++;
     current = current.children.get(pos);
  }
  current.values.add(val);
  if(current.values.size() > 2*order){
  // no more keys allowed => move key up
    split_node(current);
  }
}

private E getMiddle(Node<E> current){
  E move = null;
  int pos;
  Iterator<E> it = current.values.iterator();
  pos = 0;
  while(it.hasNext() && pos < (2*order + 1)/2 + 1){
    pos++;
    move = it.next();
  }
  return move;
}

private void split_node(Node<E> current){
  // we use get Middle because we need the element at a position in the TreeSet => possible only by iterations
  E move =  getMiddle(current);
  Node<E> parent;
  // check to see for new root
  if(current.parent == null) {
    root = new Node(new ArrayList<>(), new TreeSet<>(),null);
    current.parent = root;
  }
  parent = current.parent;
  parent.values.add(move);
  //current.values.remove(move);
  int insert_pos = (parent.values.headSet(move)).size();
  Node<E> left = new Node<>();
  Node<E> right = new Node<>();

  redistribute_vals(current,left,0,order,insert_pos);
  redistribute_vals(current,right,order + 1 ,2*order + 1 ,insert_pos + 1);
  // recursivly check the up the tree if more splits needed
  if(parent.values.size() > 2*order){
    split_node(parent);
  }
}

  private void redistribute_vals(Node<E> current, Node<E> newNode,int left, int right, int insert_pos){
    int count = 0;
    E val;
    TreeSet<E> new_values = new TreeSet<>();
    ArrayList<Node<E>> new_children = new ArrayList<>();
    Iterator<E> it = current.values.iterator();
    while(it.hasNext() && count < right){
      val = it.next();
      if(count >= left){
        new_values.add(val);
      }
      count++;
    }
    //switch boundaries for children as their number is odd

    count = 0;
    for(Node<E> child : current.children){
      // optimize just for the left new Node as go just half of the children
      // aici ii bug-ul
      if(count > right) break;
        else
      if(count >= left){
      child.parent = newNode;
      new_children.add(child);
    }
    count++;
    }
    newNode.children = new_children;
    newNode.values = new_values;
    newNode.parent = current.parent;
    //insert children in the right position
    current.parent.children.add(insert_pos,newNode);
    //remove the old node that has just been splited
    current.parent.children.remove(current);
  }

  public void delete(E value){
    Node<E> current = search(value);
    Node<E> y = successor(value);
    if(current != y){
      current.values.remove(value);
      // replace value by the successor and eliminate it as successsor will be the smallest value in y
      current.values.add(y.values.pollFirst());
    }
    else {
      // successor will be the same as current node
      y.values.remove(value);
    }
    if(y.values.size() < order)
      restructure(y);
  }

  private void restructure(Node<E> node){
    Node<E> parent = node.parent;
    Node<E> sibling = null;
    E parent_val;
    int pos_child = parent.children.indexOf(node);
    if(pos_child - 1 >= 0){
      sibling = parent.children.get(pos_child - 1);
      // carefully handle the position of value, as the set is smaller with one
      parent_val = parent.getValue(pos_child - 1);
    }
    else{
      sibling = parent.children.get(pos_child + 1);
      parent_val = parent.getValue(pos_child);
    }

    if(sibling.values.size() > order){
      // add first/last value from parent and in parent add first/last value from the sibling depending if we have right or left sibling
      if(pos_child - 1 >= 0){
        // leaft sibling
        node.values.add(parent_val);
        parent.values.remove(parent_val);
        parent.values.add(sibling.values.pollLast());
      }
      else {
        // right sibling
        node.values.add(parent_val);
        parent.values.remove(parent_val);
        parent.values.add(sibling.values.pollFirst());
      }
    }
    else{
      /* we join 2 nodes one with order keys and another one of order - 1 keys
      * get one key form the parent and join them
      total = 2order keys in the new node
      */
      node.values.add(parent_val);
      parent.values.remove(parent_val);
      node.values.addAll(sibling.values);
      //insert the sibling's children first or the node's children first ? depends if sibling was left or right sibling
      if(pos_child - 1 >= 0){
        ArrayList<Node<E>> new_ch = new ArrayList<>(sibling.children);
        new_ch.addAll(node.children);
        node.children = new_ch;
       }
      else {
        node.children.addAll(sibling.children);
      }
      parent.children.remove(sibling);
    }
    if(parent.values.size() < order && parent.values.size() != 0){
      System.out.println("aici");
      restructure(parent);
    }
    else if(parent.values.size() == 0){
      parent = null;
    }
  }

  public Node<E> treeMin(Node<E> current){
    if(current.children.size() == 0){
      return current;
    }
    return treeMin(current.children.get(0));
  }

  public Node<E> search(E val){
    Node<E> current = root;
    E aux = null, now = null;
    int count = 0;
    while(current.children.size() != 0){
      now = null;
      aux = null;
      count = 1;
      if( current == null) System.out.println("ce are???");
      if(current.values.contains(val))
        return current;
      Iterator<E> it = current.values.iterator();
      if(it.hasNext())
        aux = it.next();
      while(it.hasNext()){
        now = it.next();
        if(aux.compareTo(val) == -1 && val.compareTo(now) == -1){
          current = current.children.get(count);
          break;
        }
        count++;
        aux = now;
      }
      // just one value in the node
      if(now == null){
        if(aux.compareTo(val) == -1)
          current = current.children.get(count);
        else
          current = current.children.get(count - 1);
      }
      // treat the last child
      else if(!it.hasNext())
        current = current.children.get(count);
    }
      return current;
  }
  public Node<E> successor(E val){
    Node<E> node = search(val);
    // if it is a leaf
    if(node.children.size() == 0){
      return node;
    }
    // else there must be m + 1 children where m i s the order of the three
    else {
      //get position in the three set for val
      int pos = (node.values.headSet(val)).size();
      // treeMin of the right children for that value in the node
      return treeMin(node.children.get(pos + 1));
    }
  }

  private void preOrder(Node<E> current){
    if(current.children.size() == 0) {
      System.out.print("last elem in branch: ");
    }
      System.out.print("node: ");
      for(E val : current.values){
        System.out.print(val + " ");
      }
      System.out.println();
      for(Node<E> child : current.children)
        preOrder(child);
    }
    public void afis_postOrder(){
      Iterator<Node<E>> it = iterator();
      Node<E> current = null;
      while(it.hasNext()){
        current = it.next();
        System.out.print("node: ");
        for(E val : current.values){
          System.out.print(val + " ");
        }
        System.out.println();
      }
    }

    public void afis_preOrder(){
      preOrder(root);
    }
    private void inOrder(Node<E> current){
      if(current == null){
        return ;
      }
      if(current.children.size() == 0){
        Iterator<E> it = current.values.iterator();
        while(it.hasNext()){
          System.out.print(it.next() + " ");
        }
      }
      else{
        TreeSet<E> coppy = new TreeSet<>(current.values);
        int i;
        for(i = 0; i < current.children.size() - 1; i++){
          inOrder(current.children.get(i));
          System.out.print(coppy.pollFirst() + " ");
        }
        // one extra child in comparison with keys
        inOrder(current.children.get(i));
     }
    }
    public void afis_inOrder(){
      inOrder(root);
    }
  public static void main(String [] args){
    BTree<Integer> test = new BTree<Integer>(1);
    test.insert(2);
    test.insert(3);
    test.insert(1);
    test.insert(10);
    test.insert(0);
    test.insert(20);
    test.insert(50);
    test.insert(90);
    test.insert(100);
    test.insert(101);
    test.insert(150);
    test.insert(156);
    test.insert(170);
    test.insert(180);
    test.insert(190);
    test.insert(200);
    test.insert(217);

    test.afis_inOrder();
    System.out.println();
    test.delete(100);
    test.afis_preOrder();
   Node<Integer> n = test.search(150);
    System.out.println(n + " test");
    for(Node<Integer> ch : n.children){
      for(Integer val : ch.values)
        System.out.print(val + " val");
    }
  }
}
