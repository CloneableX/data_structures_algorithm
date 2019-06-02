package com.clo.dsa.sort;

import java.util.Random;

/**
 * com.clo.dsa.sort.BucketSort
 *
 * @author Cloneable
 * @date 2019/6/2 15:00:02
 * @description demo of bucket sort
 */
public class BucketSort extends Sort {
    private int bucketAmount = 5;

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5) + 15;
        }

        System.out.println("before sort");
        printArray(array);
        new BucketSort().sort(array, array.length);
        System.out.println("after sort");
        printArray(array);

    }

    @Override
    public void sort(int[] array, int len) {
        if(array == null || array.length < 2) {
            return;
        }

        int[] range = getRange(array);
        int min = range[0];
        int bucketSize = (range[1] - min + 1) / bucketAmount;

        int[][] bucketArray = new int[bucketAmount][array.length];

        // initialize end index of every bucket array
        int[] bucketCount = new int[bucketAmount];
        for(int i = 0; i < bucketCount.length; i++) {
            bucketCount[i] = 0;
        }

        for(int i = 0; i < array.length; i++) {
            int bucketIndex = (array[i] - min) / bucketAmount;
            bucketArray[bucketIndex][bucketCount[bucketIndex]++] = array[i];
        }

        QuickSort quickSort = new QuickSort();
        for(int i = 0; i < bucketAmount; i++) {
            quickSort.sort(bucketArray[i], bucketArray[i].length);
        }

        int arrayCount = 0;
        for(int i = 0; i < bucketAmount; i++) {
            for(int j = 0; j < bucketCount[i]; j++) {
                array[arrayCount++] = bucketArray[i][j];
            }
        }
    }

    /**
     * get range of array, index 0 of return array is min,
     * index 1 of return array is max
     *
     * @param array
     * @return
     */
    public static int[] getRange(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        return new int[] {min, max};
    }
}
