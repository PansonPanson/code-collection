package com.panson.algorithm.sort;

/**
 * Package: com.panson.algorithm.sort
 * Description：
 * Author: Panson
 */
public class InsertionSort {

    public static void sort(int[] array) {

        if (array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            // value保存了未排序区间的第一个元素的值,初始为数组小标为1的元素值
            int value = array[i];
            // 从已排序的子序列中查找要插入的位置
            int j = i - 1;
            // 将已排序的子序列中的元素依次与是value对比，
            // 最后的array[j]为从后往前第一个小于等于value的数，所以插入下标为j+1
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j]; // 移动
                } else { // 优化，若array[j] < value，则说明前面的序列已全部小于
                    break;
                }
            }
            array[j + 1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {

    }
}
