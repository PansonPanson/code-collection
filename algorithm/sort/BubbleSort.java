package com.panson.algorithm.sort;

/**
 * Package: com.panson.algorithm.sort
 * Description：
 * Author: Panson
 */
public class BubbleSort {

    public static void sort(int[] array) {

        // 提前退出冒泡循环的标识位
        boolean flag = false;
        int length = array.length;

        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) { // 交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) {
                break; // 没有数据交换，提前退出
            }
        }


    }

    public static void main(String[] args ) {

    }
}
