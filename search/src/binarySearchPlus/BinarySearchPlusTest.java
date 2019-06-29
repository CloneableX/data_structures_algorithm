package com.clo.dsa.search.binarySearchPlus;

import org.junit.Assert;
import org.junit.Test;

/**
 * com.clo.dsa.search.binarySearchPlus.BinarySearchPlusTest
 *
 * @author Cloneable
 * @date 2019/6/29 13:27:29
 * @description unit test of BinarySearchPlus
 */
public class BinarySearchPlusTest {
    @Test
    public void searchFirstEqualTest() {
        int[] a = new int[]{1, 3, 4, 5, 5, 8, 8, 8, 12};
        int target = 8;
        int tarIndex = BinarySearchPlus.searchFirstEqual(a, target);

        Assert.assertTrue(target > -1 && target < a.length);
        Assert.assertEquals(target, a[tarIndex]);
        Assert.assertTrue(tarIndex == 0 || a[tarIndex - 1] < target);
    }

    @Test
    public void searchLatestEqualTest() {
        int[] a = new int[]{1, 3, 4, 5, 5, 8, 8, 8, 12};
        int target = 8;
        int tarIndex = BinarySearchPlus.searchLatestEqual(a, target);

        Assert.assertTrue(target > -1 && target < a.length);
        Assert.assertEquals(target, a[tarIndex]);
        Assert.assertTrue(tarIndex == a.length - 1 || a[tarIndex + 1] > target);
    }

    @Test
    public void searchFirstGteTest() {
        int[] a = new int[]{1, 3, 4, 5, 5, 8, 8, 8, 12};
        int target = 5;
        int tarIndex = BinarySearchPlus.searchFirstGte(a, target);

        Assert.assertTrue(target > -1 && target < a.length);
        Assert.assertTrue(a[tarIndex] >= target);
        Assert.assertTrue(tarIndex == 0 || a[tarIndex - 1] < target);
    }

    @Test
    public void searchLatestLteTest() {
        int[] a = new int[]{1, 3, 4, 5, 5, 8, 8, 8, 12};
        int target = 5;
        int tarIndex = BinarySearchPlus.searchLatestLte(a, target);

        Assert.assertTrue(target > -1 && target < a.length);
        Assert.assertTrue(a[tarIndex] <= target);
        Assert.assertTrue(tarIndex == a.length - 1 || a[tarIndex + 1] > target);
    }
}
