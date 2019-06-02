package com.clo.dsa.sort;

import java.util.Random;

/**
 * com.clo.dsa.sort.CountingSort
 *
 * @author Cloneable
 * @date 2019/6/2 16:01:02
 * @description demo of counting sort
 */
public class CountingSort extends Sort {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5) + 15;
        }

        System.out.println("before sort");
        printArray(array);
        new CountingSort().sort(array, array.length);
        System.out.println("after sort");
        printArray(array);

    }

    @Override
    public void sort(int[] array, int len) {
        if(array == null || array.length < 2) {
            return;
        }

        // initialize counting array
        int[] range = BucketSort.getRange(array);
        int min = range[0];
        int[] countingArray = new int[range[1] - min + 1];
        for(int i = 0; i < countingArray.length; i++) {
            countingArray[i] = 0;
        }

        // count value of array
        for(int i = 0; i < array.length; i++) {
            countingArray[array[i] - min]++;
        }

        // amount num of counting
        for(int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        int[] sortArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--) {
            int countingIndex = array[i] - min;
            sortArray[countingArray[countingIndex] - 1] = array[i];
            countingArray[countingIndex]--;
        }

        for(int i = 0; i < array.length; i++) {
            array[i] = sortArray[i];
        }
    }
}
