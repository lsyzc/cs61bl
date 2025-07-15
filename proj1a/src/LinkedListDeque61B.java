import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private Node sentinel;
    private int size;

    public class Node {
        T item;
        Node next;
        Node prev;
        public Node(T item,Node prev,Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newnode = new Node(x,sentinel,sentinel.next);
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newnode = new Node(x,sentinel.prev,sentinel);
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size++;

    }

    @Override
    public List<T> toList() {

        List<T> list = new ArrayList<>();
        Node current = sentinel.next;
        for (int i = 0 ; i < size; i++) {
            list.add(current.item);
            current = current.next;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        // size == 1 时需要更改sentinel.prev指向
        if (size == 1) {
            sentinel.prev = sentinel;
        }
        size--;
        return first.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        Node last = sentinel.prev;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        size --;
        return last.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
//    public T getRecursive(int index) {
//        if(index < 0 || index >= size) return null;
//        if (index == 0)
//            return
//
//    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) return null;
        return getRecursiveHelper(sentinel.next, index);
    }
    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

}
