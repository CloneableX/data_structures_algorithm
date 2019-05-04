package com.clo.dsa.queue;

/**
 * com.clo.dsa.queue.LinkQueue
 *
 * @author Cloneable
 * @date 2019/5/4 18:02:04
 * @description a queue by link
 */
public class LinkQueue {
    private LinkNode head;
    private LinkNode tail;
    private int size = 0;

    public boolean enqueue(String item) {
        LinkNode linkNode = new LinkNode(item);

        if(tail != null) {
            tail.next = linkNode;
        }
        tail = linkNode;

        if(head == null) {
            head = linkNode;
        }

        size++;
        return true;
    }

    public String dequeue() {
        if(head == null) {
            return null;
        }

        String result = head.val;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        LinkNode currNode = head;
        while(currNode != null) {
            sb.append(currNode.val + ",");
            currNode = currNode.next;
        }

        return sb.substring(0, sb.lastIndexOf(",")) + "]";
    }

    public int size() {
        return this.size;
    }
}
