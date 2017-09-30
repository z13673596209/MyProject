package bag_queue_stack;

import java.util.Iterator;

/**
 * Created by DELL on 2017/7/17.
 */
public class LinkQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N = 0;
    private class Node {
        private Item data;
        private Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public void enqueue(Item element) {
        Node oldLast = last;
        last = new Node();
        last.data = element;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        N--;
        return item;
    }

    public Iterator iterator(){
        return new LinkQueueIterator();
    }

    private class LinkQueueIterator implements Iterator{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item  = current.data;
            current = current.next;
            return item;
        }
        public void remove(){

        }
    }
}
