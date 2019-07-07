package com.clo.dsa.linkedlist.skiplist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * com.clo.dsa.linkedlist.skiplist.SkipList
 *
 * @author Cloneable
 * @date 2019/7/6 16:44:06
 * @description demo of Skip List
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;

    private Node head = new Node();
    private int levelCount = 1;
    private Random random = new Random();

    public void insert(int value) {
        // get random level and init node
        int level = randomLevel();
        Node node = new Node();
        node.value = value;
        node.maxLevel = level;

        // init update arrays
        Node[] update = new Node[levelCount > level ? levelCount : level];
        for(int i = 0; i < level; i++) {
            update[i] = head;
        }

        // get all previous node of inserted node
        Node prev = head;
        for(int i = levelCount - 1; i >= 0; i--) {
            while(prev.forwards[i] != null && prev.forwards[i].value < value) {
                prev = prev.forwards[i];
            }
            update[i] = prev;
        }

        // insert node to all level linked list
        for(int i = 0; i < level; i++) {
            node.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = node;
        }

        if(levelCount < level) {
            levelCount = level;
        }
    }

    public Node find(int value) {
        // find previous node of target node
        Node prev = head;
        for(int i = levelCount - 1; i >= 0; i--) {
            while(prev.forwards[i] != null && prev.forwards[i].value < value) {
                prev = prev.forwards[i];
            }
        }

        if(prev.forwards[0] != null && prev.forwards[0].value == value) {
            return prev.forwards[0];
        }

        return null;
    }

    public void delete(int value) {
        // get all previous node of deleted node
        Node[] update = new Node[levelCount];
        Node prev = head;
        for(int i = levelCount - 1; i >= 0; i--) {
            while(prev.forwards[i] != null && prev.forwards[i].value < value) {
                prev = prev.forwards[i];
            }
            update[i] = prev;
        }

        if(prev.forwards[0] != null && prev.forwards[0].value == value) {
            int i = 0;
            while(update[i].forwards[i] != null && update[i].forwards[i].value == value) {
                update[i].forwards[i] = update[i].forwards[i].forwards[i];
                i++;
            }
        }
    }

    public void print() {
        Node node = head.forwards[0];
        while(node != null) {
            System.out.print(node + " ");
            System.out.println();

            node = node.forwards[0];
        }
    }

    public Integer[] toArrays() {
        Node node = head.forwards[0];
        List<Integer> list = new ArrayList<>();
        while(node != null) {
            list.add(node.value);
            node = node.forwards[0];
        }


        return list.toArray(new Integer[list.size()]);
    }

    private int randomLevel() {
        int level = 1;
        for(int i = 1; i < MAX_LEVEL; i++) {
            if(random.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public class Node {
        private int value = -1;
        private int maxLevel = 0;
        private Node[] forwards = new Node[MAX_LEVEL];

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{value: " + value +", maxLevel: " + maxLevel + "}";
        }
    }
}
