package com.clo.dsa.search.binarySearch;

/**
 * com.clo.dsa.search.binarySearch.BinarySearch
 *
 * @author Cloneable
 * @date 2019/6/23 13:26:23
 * @description demo about binary search
 */
public class BinarySearch {
    public int binarySearch(int[] a, int target) {
        if(a.length < 1) { return -1;}

        int high = a.length - 1;
        int low = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(target == a[mid]) {
                return mid;
            } else if(target > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearchRecursive(int[] a, int target, int low, int high) {
        if(low > high) {return -1;}

        int mid = low + ((high - low) >> 1);
        if(target == a[mid]) {
            return mid;
        } else if(target > a[mid]) {
            return binarySearchRecursive(a, target, mid + 1, high);
        } else {
            return binarySearchRecursive(a, target, low, mid - 1);
        }
    }

    public int binarySearchLink(Link link, int target) {
        if(link == null || link.len < 1) {return -1;}
        LinkNode head = link.head;
        LinkNode tail = link.tail;
        int len = link.len;
        int start = 0;

        while(head != null && tail != null) {
            LinkNode mid = head, prev = null;
            int i = 1;
            for(; i < (len + 1) / 2; i++) {
                prev = mid;
                mid = mid.next;
            }

            if(target == mid.value) {
                return start + i;
            } else if(target > mid.value) {
                head = mid.next;
                len = i - len % 2;
                start = start + i;
            } else {
                tail = prev;
                tail.next = null;
                len = i -1;
            }
        }

        return -1;
    }
}
