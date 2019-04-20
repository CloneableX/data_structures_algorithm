package com.clo.dsa.stack;

/**
 * com.clo.dsa.stack.LinkStack
 *
 * @author Cloneable
 * @date 2019/4/20 21:31:20
 * @description stack by link
 */
public class LinkStack {
    private LinkNode head;

    public void push(String data) {
        LinkNode node = new LinkNode(data, head);
        head = node;
    }

    public String pop() {
        if(head == null) {return null;}

        String data = head.val;
        head = head.next;
        return data;
    }
}
