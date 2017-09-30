package bag_queue_stackTest;

import bag_queue_stack.ArrayBag;

/**
 * Created by DELL on 2017/7/15.
 */
public class BagTest {
    public static void main(String[] args) {
        ArrayBag<String> bag = new ArrayBag<String>();
        bag.add("1");
        bag.add("2");
        bag.add("3");
        System.out.println(bag.size());
        for (String a : bag) {
            System.out.println(a);
        }

    }
}
