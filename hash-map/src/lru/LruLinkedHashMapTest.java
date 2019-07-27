package com.clo.dsa.hashmap.lru;

import org.junit.Assert;
import org.junit.Test;

/**
 * com.clo.dsa.hashmap.lru.LruLinkedHashMapTest
 *
 * @author Cloneable
 * @date 2019/7/27 19:33:27
 * @description unit test for LruLinkedHashMapTest
 */
public class LruLinkedHashMapTest {
    @Test
    public void cacheTest() {
        int[] datas = new int[]{1, 2, 5, 3, 15, 5};
        LruLinkedHashMap lru = new LruLinkedHashMap();
        for(int data : datas) {
            lru.cache(data);
        }

        Assert.assertEquals("1->2->3->15->5", lru.print());
    }
}
