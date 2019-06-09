package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.InsertSort
 *
 * @author Cloneable
 * @date 2019/5/19 16:26:19
 * @description insert sorting
 */
public class InsertSort extends Sort {
    public static void main(String[] args) {
        int[] a = new int[] {7, 16, 5, 2, 7, 9};
        System.out.println("before sort");
        printArray(a);
        new InsertSort().sort(a, a.length);
        System.out.println("after sort");
        printArray(a);
    }

    @Override
    public void sort(int[] array, int len) {
        for(int i = 1; i < len; i++) {
            int value = array[i];
            int j = i -1;
            for(; j >= 0; j--) {
                if(value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }

            // insert value to suitable site of arrays
            array[j + 1] = value;
        }
    }
}
