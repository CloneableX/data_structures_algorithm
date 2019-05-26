package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.QuickSort
 *
 * @author Cloneable
 * @date 2019/5/25 21:52:25
 * @description quick sort demo
 */
public class QuickSort extends Sort {
    public static void main(String[] args) {
        int[] a = new int[] {7, 16, 5, 2, 7, 9};
        System.out.println("before sort");
        printArray(a);
        new QuickSort().sort(a, a.length);
        System.out.println("after sort");
        printArray(a);
    }

    @Override
    public void sort(int[] array, int len) {
        quickSort(array, 0, len - 1);
    }

    private void quickSort(int[] array, int head, int tail) {
        if(head >= tail) {return;}

        int pivot = partition(array, head, tail);
        quickSort(array, head, pivot - 1);
        quickSort(array, pivot + 1, tail);
    }

    private int partition(int[] array, int head, int tail) {
        int i = 0;
        for(int j = 0; j <= tail; j++) {
            if(array[j] <= array[tail]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        return i - 1;
    }
}
