package com.clo.dsa.sort;

/**
 * com.clo.dsa.sort.Sort
 *
 * @author Cloneable
 * @date 2019/5/19 16:27:19
 * @description super class for sort
 */
public abstract class Sort {
    public abstract void sort(int[] array, int len);

    public static void printArray(int[] array) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; ; i++) {
            stringBuffer.append(array[i]);
            if(i == array.length - 1) {
                break;
            }
            stringBuffer.append(",");
        }
        System.out.println(stringBuffer.toString());
    }
}
