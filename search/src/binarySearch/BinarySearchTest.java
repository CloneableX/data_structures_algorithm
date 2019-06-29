package com.clo.dsa.search.binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * com.clo.dsa.search.binarySearch.BinarySearchTest
 *
 * @author Cloneable
 * @date 2019/6/23 13:32:23
 * @description unit test of BinarySearch
 */
public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        int[] a = new int[]{1, 3, 4, 7, 9, 12};
        int target = 9;
        int tarIndex = new BinarySearch().binarySearch(a, target);

        Assert.assertEquals(target, a[tarIndex]);
    }

    @Test
    public void binarySearchRecursiveTest() {
        int[] a = new int[]{1, 3, 4, 7, 9, 12};
        int target = 9;
        int tarIndex = new BinarySearch().binarySearchRecursive(a, target, 0, a.length - 1);

        Assert.assertEquals(target, a[tarIndex]);
    }

    @Test
    public void binarySearchLinkTest() {
        Link link = new Link();
        LinkNode head = new LinkNode();
        head.value = 0;
        link.head = head;
        link.tail = head;

        int i = 1;
        for(; i < 10; i++) {
            LinkNode linkNode = new LinkNode();
            linkNode.value = i;

            link.tail.next = linkNode;
            link.tail = linkNode;
        }
        link.len = i;

        int target = 3;
        int tarIndex = new BinarySearch().binarySearchLink(link, target);

        LinkNode result = head;
        for(int j = 1; j < tarIndex && result.next != null; j++) {
            result = result.next;
        }

        Assert.assertNotNull(result);
        Assert.assertEquals(target, result.value);
    }
}
