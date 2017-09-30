package bag_queue_stack;

import java.util.Iterator;

/**
 * Created by DELL on 2017/7/14.
 * 背包基于数组的实现
 */
public class ArrayBag<Item> implements Iterable<Item> {
    private int N;//背包目前存储数据的大小
    private Item[] a;

    public ArrayBag() {
        N = 0;
        a = (Item[]) new Object[1];
    }

    //重新变更数组大小
    private void resize(int max) {
        Item[] newItemList = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            newItemList[i] = a[i];
        }
        a = newItemList;
    }

    //返回背包目前的大小
    public int size() {
        return N;
    }

    //判断背包是否为空
    public boolean isEmpty() {
        return (N == 0);
    }

    //增添新元素
    public void add(Item element) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = element;
    }

    //实现Iterable接口，返回BagIterator
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    //Bag内部类，Bag的迭代器实现
    private class BagIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return (i > 0);
        }

        public Item next() {
            return (a[--i]);
        }

        public void remove() {

        }

    }
}
