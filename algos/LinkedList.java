import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
  private Node first;
  private int size;

  public void addFirst(T data) {
    Node oldFirst = first;
    first = new Node();
    first.data = data;
    first.next = oldFirst;
    size++;
  }

  public T pop() {
    T data = first.data;
    first = first.next;
    size--;
    return data;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class Node {
    T data;
    Node next;
  }

  private class ListIterator implements Iterator<T> {

    @Override
    public boolean hasNext() {
      return size > 0;
    }

    @Override
    public T next() {
      return first.data;
    }
  }

  public static void main (String [] args) {
    LinkedList<Integer> l = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
      l.addFirst(i);
    }

    for (int i : l) {
      System.out.println(i);
    }
  }

}