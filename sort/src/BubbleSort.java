package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.BubbleSort
 *
 * @author Cloneable
 * @date 2019/5/19 16:01:19
 * @description bubble sort
 */
public class BubbleSort extends Sort {
    public static void main(String[] args) {
        int[] a = new int[] {7, 16, 5, 2, 7, 9};
        System.out.println("before sort");
        printArray(a);
        new BubbleSort().sort(a, a.length);
        System.out.println("after sort");
        printArray(a);
    }

    @Override
    public void sort(int[] values, int len) {
        for(int i = 0; i < len; i++) {
            // mark weather value is exchanged when bubble sorting
            boolean isExc = false;
            for(int j = 0; j < len - i - 1; j++) {
                if(values[j] > values[j + 1]) {
                    isExc = true;
                    int temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }

            if(!isExc) {break;}
        }
    }
}
