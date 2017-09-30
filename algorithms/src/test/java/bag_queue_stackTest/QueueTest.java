package bag_queue_stackTest;

import bag_queue_stack.ArrayQueue;

/**
 * Created by DELL on 2017/7/15.
 */
public class QueueTest {
    public static void main(String[] args){
        ArrayQueue<String> queue = new ArrayQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        queue.enqueue("4");
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        for(String a:queue){
            System.out.print(a);

        }
    }
}
