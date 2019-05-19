package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.ChooseSort
 *
 * @author Cloneable
 * @date 2019/5/19 16:58:19
 * @description choose sort
 */
public class ChooseSort extends Sort {
    public static void main(String[] args) {
        int[] a = new int[] {7, 16, 5, 2, 7, 9};
        System.out.println("before sort");
        printArray(a);
        new ChooseSort().sort(a, a.length);
        System.out.println("after sort");
        printArray(a);
    }

    @Override
    public void sort(int[] array, int len) {
        for(int i = 0; i < len; i++) {
            int minValueIndex = i;
            for(int j = i; j < len - 1; j++) {
                if(array[j + 1] < array[j]) {
                    minValueIndex = j + 1;
                }
            }

            int temp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = temp;
        }
    }
}
