package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.MergeSort
 *
 * @author Cloneable
 * @date 2019/5/25 21:08:25
 * @description merge sort demo
 */
public class MergeSort extends Sort {

    public static void main(String[] args) {
        int[] a = new int[] {7, 16, 5, 2, 7, 9};
        System.out.println("before sort");
        printArray(a);
        new MergeSort().sort(a, a.length);
        System.out.println("after sort");
        printArray(a);
    }

    @Override
    public void sort(int[] array, int len) {
        mergeSort(array, 0, len - 1);
    }

    public void mergeSort(int[] array, int head, int tail) {
        if(head >= tail) {return;}

        mergeSort(array, head, (head + tail) / 2);
        mergeSort(array, (head + tail) / 2 + 1, tail);
        //merge(array, head, tail);
        mergeWithGuard(array, head, tail);
    }

    private void mergeWithGuard(int[] array, int head, int tail) {
        int i = head, midPoint = (head + tail) / 2, j = midPoint + 1, k = 0;
        int[] temp = new int[tail - head + 1];

        // make max as guard
        int max = array[midPoint];
        if(array[tail] > max) {
            max = array[tail];
        }
        boolean isGuard = false;

        // merge sub arrays to temp
        while(i <= midPoint && j <= tail) {
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }

            // add guard
            if((i > midPoint || j > tail) && !isGuard) {
                if(i > midPoint) {
                    i--;
                    array[i] = max;
                } else {
                    j--;
                    array[j] = max;
                }
                isGuard = true;
            }
        }

        // move temp to array
        for(int s = 0; s < k; s++) {
            array[head + s] = temp[s];
        }
    }

    private void merge(int[] array, int head, int tail) {
        int i = head, midPoint = (head + tail) / 2, j = midPoint + 1, k = 0;
        int[] temp = new int[tail - head + 1];

        // merge sub arrays to temp
        while(i <= midPoint && j <= tail) {
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // merge extra elements of sub arrays to temp
        int start = i, end = midPoint;
        if(j <= tail) {
            start = j;
            end = tail;
        }

        while(start <= end) {
            temp[k++] = array[start++];
        }

        // move temp to array
        for(int s = 0; s < k; s++) {
            array[head + s] = temp[s];
        }
    }
}
