package com.clo.dsa.stack;

/**
 * com.clo.dsa.stack.LinkNode
 *
 * @author Cloneable
 * @date 2019/4/20 21:32:20
 * @description node of link
 */
public class LinkNode {
    String val;
    LinkNode next;

    public LinkNode(String val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}
