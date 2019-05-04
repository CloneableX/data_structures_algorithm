package com.clo.dsa.queue;

/**
 * com.clo.dsa.queue.LoopQueue
 *
 * @author Cloneable
 * @date 2019/5/4 18:23:04
 * @description a queue which array's head and tail will loop
 */
public class LoopQueue {
    private int head = 0;
    private int tail = 0;
    private int n;
    private String[] items;

    public LoopQueue(int size) {
        this.n = size;
        items = new String[size];
    }

    public boolean enqueue(String item) {
        if((tail + 1) % n == head) {
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if(head == tail) {
            return null;
        }

        String result = items[head];
        head++;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int i = head;
        while(i != tail) {
            sb.append(items[i] + ",");
            i = (i + 1) % n;
        }
        return sb.substring(0, sb.lastIndexOf(",")) + "]";
    }
}
