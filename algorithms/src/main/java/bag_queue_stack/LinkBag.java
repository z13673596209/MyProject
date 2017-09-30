package bag_queue_stack;

import java.util.Iterator;

/**
 * Created by DELL on 2017/7/17.
 */
public class LinkBag<Item> implements Iterable<Item> {
    private int N = 0;
    private Node first;

    private class Node {
        private Item data;
        private Node next;
    }

    public int size() {
        return N;
    }

    public void add(Item element) {
        Node oldFirst = first;
        first = new Node();
        first.data = element;
        first.next = oldFirst;
        N++;
    }

    public Iterator iterator() {
        return new LinkBagIterator();
    }

    private class LinkBagIterator implements Iterator {
        Node current = first;

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            Item data = current.data;
            Node next = current.next;
            current = next;
            return data;
        }

        public void remove() {

        }
    }
}
