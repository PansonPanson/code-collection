package com.panson.algorithm.sort;

/**
 * Package: com.panson.algorithm.sort
 * Description：选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 * Author: Panson
 */
public class SelectionSort {
    public static void sort(int[] array) {

        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将未排序子序列的最小元素与未排序子序列的起始元素交换位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
