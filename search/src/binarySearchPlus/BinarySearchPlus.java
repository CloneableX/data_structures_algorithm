package com.clo.dsa.search.binarySearchPlus;

/**
 * com.clo.dsa.search.binarySearchPlus.BinarySearchPlus
 *
 * @author Cloneable
 * @date 2019/6/29 13:19:29
 * @description binary search resolving variant problems
 */
public class BinarySearchPlus {
    public static int searchFirstEqual(int[] a, int target) {
        if(a.length < 1) { return -1;}

        int high = a.length - 1, low = 0;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if(a[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == 0 || a[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int searchLatestEqual(int[] a, int target) {
        if(a.length < 1) { return -1;}

        int high = a.length - 1, low = 0;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if(a[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == a.length - 1 || a[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int searchFirstGte(int[] a, int target) {
        if(a.length < 1) { return -1;}

        int high = a.length - 1, low = 0;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= target) {
                if(mid == 0 || a[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else if(a[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int searchLatestLte(int[] a, int target) {
        if(a.length < 1) { return -1;}

        int high = a.length - 1, low = 0;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if(a[mid] <= target) {
                if(mid == a.length - 1 || a[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }
}
