package com.clo.dsa.hashmap.lru;

/**
 * com.clo.dsa.hashmap.lru.LruLinkedHashMap
 *
 * @author Cloneable
 * @date 2019/7/27 17:06:27
 * @description LRU cache by Linked List and HashMap
 */
public class LruLinkedHashMap {
    private final static int capacity = 10;
    private final static int MAX_CACHE_CAPACITY = 10;
    private Node[] hashMap = new Node[capacity];

    private Node head;
    private Node tail;
    private int cacheCount = 0;

    private class Node {
        private Node prev;
        private Node next;
        private Node hnext;
        private int data;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }
    }

    public LruLinkedHashMap() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public void cache(int data) {
        int hashKey = hash(data);
        if(hashMap[hashKey] == null) {
            Node node = new Node(data);
            insertLinkedTail(node);
            hashMap[hashKey] = node;
        } else {
            Node hashNode = hashMap[hashKey];
            while(hashNode.data != data && hashNode.hnext != null) {
                hashNode = hashNode.next;
            }

            if(hashNode.data == data) {
                deleteLinkedNode(hashNode);
                insertLinkedTail(hashNode);
            } else {
                Node node = new Node(data);
                hashNode.hnext = node;
                insertLinkedTail(node);
            }
        }
    }

    private void deleteLinkedNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        cacheCount--;
    }

    private void insertLinkedTail(Node node) {
        if(cacheCount == MAX_CACHE_CAPACITY) {
            deleteLinkedNode(head.next);
        }

        node.prev = tail.prev;
        tail.prev = node;
        node.next = node.prev.next;
        node.prev.next = node;
        cacheCount++;
    }

    private int hash(int data) {
        return data % capacity;
    }

    public String print() {
        StringBuffer stringBuffer = new StringBuffer();
        Node node = head.next;
        for(;; node = node.next) {
            stringBuffer.append(node.data);
            if(node.next.next == null) {
                break;
            }

            stringBuffer.append("->");
        }

        return stringBuffer.toString();
    }
}
