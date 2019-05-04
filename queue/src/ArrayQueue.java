package com.clo.dsa.queue;

/**
 * com.clo.dsa.queue.ArrayQueue
 *
 * @author Cloneable
 * @date 2019/5/4 17:16:04
 * @description a queue by array
 */
public class ArrayQueue {
    private int head = 0;
    private int tail = 0;
    private int n;
    private String[] items;

    public ArrayQueue(int size) {
        this.n = size;
        items = new String[size];
    }

    public boolean enqueue(String item) {
        if(tail - head == n) {
            return false;
        } else if(tail == n) {
            moveData();
        }

        items[tail] = item;
        tail++;
        return true;
    }

    private void moveData() {
        for(int i = head; i < tail; i++) {
            items[i - head] = items[i];
        }
        tail = tail - head;
        head = 0;
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
        for(int i = head; i < tail; i++) {
            sb.append(items[i] + ",");
        }
        return sb.substring(0, sb.lastIndexOf(",")) + "]";
    }
}
