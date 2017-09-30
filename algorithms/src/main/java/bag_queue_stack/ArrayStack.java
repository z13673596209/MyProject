package bag_queue_stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by DELL on 2017/7/15.
 * 数组栈
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private int N;
    private Item[] a;

    public ArrayStack() {
        N = 0;
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N;
    }

    public void push(Item element) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = element;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N <= a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        Item[] newItemList = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            newItemList[i] = a[i];
        }
        a = newItemList;
    }

    public Iterator iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator {
        private int i = N;

        public boolean hasNext() {
            return (i > 0);
        }

        public Item next() {
            if (i > 0)
            {
                return a[--i];
            }else{
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}