package com.clo.dsa.queue;

/**
 * com.clo.dsa.queue.QueueTest
 *
 * @author Cloneable
 * @date 2019/5/4 17:32:04
 * @description test case for some queue
 */
public class QueueTest {
    public static void main(String[] args) {
        //testArrayQueue();
        //testLinkQueue();
        testLoopQueue();
    }

    private static void testLinkQueue() {
        System.out.println("Link Queue Test Start");
        LinkQueue linkQueue = new LinkQueue();
        for(int i = 0; i < 6; i++) {
            String item = "queueTest" + i;
            linkQueue.enqueue(item);
            System.out.println("enqueue:" + item);
        }

        System.out.println("before dequeue:" + linkQueue.toString() + ";queue size: " + linkQueue.size());
        System.out.println("dequeue:" + linkQueue.dequeue());
        System.out.println("after dequeue:" + linkQueue.toString() + ";queue size: " + linkQueue.size());
    }

    private static void testArrayQueue() {
        System.out.println("Array Queue Test Start");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for(int i = 0; i < 6; i++) {
            String item = "queueTest" + i;
            if(!arrayQueue.enqueue(item)) {
                System.err.println("enqueue fail:" + item);
                break;
            }
            System.out.println("enqueue:" + item);
        }

        System.out.println("before dequeue:" + arrayQueue.toString());
        System.out.println("dequeue:" + arrayQueue.dequeue());
        System.out.println("dequeue:" + arrayQueue.dequeue());
        System.out.println("after dequeue:" + arrayQueue.toString());

        arrayQueue.enqueue("queueTest5");
        System.out.println("after move data:" + arrayQueue.toString());
    }

    private static void testLoopQueue() {
        System.out.println("Loop Queue Test Start");
        LoopQueue loopQueue = new LoopQueue(5);
        for(int i = 0; i < 5; i++) {
            String item = "queueTest" + i;
            if(!loopQueue.enqueue(item)) {
                System.err.println("enqueue fail:" + item);
                break;
            }
            System.out.println("enqueue:" + item);
        }

        System.out.println("before dequeue:" + loopQueue.toString());
        System.out.println("dequeue:" + loopQueue.dequeue());
        System.out.println("after dequeue:" + loopQueue.toString());

        loopQueue.enqueue("queueTest4");
        System.out.println("after loop queue:" + loopQueue.toString());
    }
}
