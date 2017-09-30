package bag_queue_stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by DELL on 2017/7/14.
 * 队列基于数组的实现
 */
public class ArrayQueue<Item> implements Iterable<Item> {
    private int N;//队列尾部的位置
    private int Q;//队列头部的位置
    private Item[] a;

    public ArrayQueue() {
        N = 0;
        Q = 0;
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N - Q;
    }

    public void enqueue(Item element) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = element;
    }

    public Item dequeue() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException();
        } else {
            Item item = a[Q];
            a[Q] = null;
            Q++;
            if (Q < N && N - Q <= a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }
    }

    private void resize(int maxSize) {
        Item[] newItem = (Item[]) new Object[maxSize];
        int b = 0;
        for (int i = Q; i < N; i++) {
            newItem[b++] = a[i];
        }
        N = N - Q;
        Q = 0;
        a = newItem;
    }

    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<Item> {
        int i = Q;

        public boolean hasNext() {
            return (i < N);
        }

        public Item next() {
            if (i < N) {
                return a[i++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
