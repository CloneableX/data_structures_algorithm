package com.clo.dsa.linkedlist.skiplist;

import org.junit.Assert;
import org.junit.Test;

/**
 * com.clo.dsa.linkedlist.skiplist.SkipListTest
 *
 * @author Cloneable
 * @date 2019/7/6 17:21:06
 * @description unit test of Skip List
 */
public class SkipListTest {
    @Test
    public void insertTest() {
        int[] values = new int[]{3, 8, 5, 7, 1, 10, 6};
        SkipList skipList = new SkipList();
        for(int i = 0; i < values.length; i++) {
            skipList.insert(values[i]);
        }
        skipList.print();

        Assert.assertArrayEquals(new Integer[]{1, 3, 5, 6, 7, 8, 10}, skipList.toArrays());
    }

    @Test
    public void findTest() {
        int[] values = new int[]{3, 8, 5, 7, 1, 10, 6};
        SkipList skipList = new SkipList();
        for(int i = 0; i < values.length; i++) {
            skipList.insert(values[i]);
        }
        skipList.print();

        int target = 5;
        SkipList.Node node = skipList.find(target);

        Assert.assertNotNull(node);
        Assert.assertEquals(target, node.getValue());
    }

    @Test
    public void deleteTest() {
        int[] values = new int[]{3, 8, 5, 7, 1, 10, 6};
        SkipList skipList = new SkipList();
        for(int i = 0; i < values.length; i++) {
            skipList.insert(values[i]);
        }

        System.err.println("before delete: ");
        skipList.print();

        int target = 5;
        skipList.delete(target);
        SkipList.Node node = skipList.find(target);

        System.err.println("after delete: ");
        skipList.print();

        Assert.assertNull(node);
    }
}
